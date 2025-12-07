package com.example.cfseeker.data.local

import com.example.cfseeker.data.local.entity.RatingChangeEntity
import com.example.cfseeker.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface DatabaseService {
    suspend fun addUser(user: UserEntity, ratingChanges: List<RatingChangeEntity>)
    suspend fun deleteUser(handle: String)
    fun getAllUserRatingChanges(): Flow<List<Pair<UserEntity, RatingChangeEntity?>>>
}