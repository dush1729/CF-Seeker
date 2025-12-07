package com.example.cfseeker.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cfseeker.data.local.entity.RatingChangeEntity
import com.example.cfseeker.data.local.entity.UserEntity
import com.example.cfseeker.data.remote.model.RatingChange
import com.example.cfseeker.data.remote.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("DELETE FROM user WHERE handle = :handle")
    suspend fun deleteUser(handle: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRatingChanges(ratingChanges: List<RatingChangeEntity>)

    @Query("DELETE FROM rating_change WHERE handle = :handle")
    suspend fun deleteRatingChanges(handle: String)

    @Query("SELECT * FROM user JOIN rating_change ON user.handle = rating_change.handle")
    suspend fun getAllUserRatingChanges(): Map<User, List<RatingChange>>
}