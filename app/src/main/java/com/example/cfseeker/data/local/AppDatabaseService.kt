package com.example.cfseeker.data.local

import com.example.cfseeker.data.local.entity.RatingChangeEntity
import com.example.cfseeker.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AppDatabaseService @Inject constructor(private val appDatabase: AppDatabase): DatabaseService {
    override suspend fun addUser(user: UserEntity, ratingChanges: List<RatingChangeEntity>) {
        appDatabase.userDao().addUser(user, ratingChanges)
    }

    override suspend fun deleteUser(handle: String) {
        appDatabase.userDao().deleteUserAndRatingChanges(handle)
    }

    override fun getAllUserRatingChanges(): Flow<List<Pair<UserEntity, RatingChangeEntity?>>> {
        return flow {
            val userRatingChanges = appDatabase.userDao().getAllUserRatingChanges()
                .map { (user, ratingChanges) -> user to ratingChanges.lastOrNull() }
            emit(userRatingChanges)
        }
    }
}