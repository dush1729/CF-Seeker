package com.dush1729.cfseeker.data.local

import com.dush1729.cfseeker.data.local.entity.ContestEntity
import com.dush1729.cfseeker.data.local.entity.RatingChangeEntity
import com.dush1729.cfseeker.data.local.entity.UserEntity
import com.dush1729.cfseeker.data.local.entity.UserRatingChanges
import com.dush1729.cfseeker.ui.SortOption
import kotlinx.coroutines.flow.Flow

interface DatabaseService {
    suspend fun addUser(user: UserEntity, ratingChanges: List<RatingChangeEntity>)
    suspend fun deleteUser(handle: String)
    fun getAllUserRatingChanges(
        sortBy: String = SortOption.LAST_RATING_UPDATE.value,
        searchQuery: String = ""
    ): Flow<List<UserRatingChanges>>
    suspend fun getAllUserHandles(): List<String>
    fun getUserCount(): Flow<Int>
    fun getUserByHandle(handle: String): Flow<UserEntity>
    fun getRatingChangesByHandle(handle: String, searchQuery: String = ""): Flow<List<RatingChangeEntity>>

    // Contest methods
    suspend fun addAllContests(contests: List<ContestEntity>)
    fun getAllContests(): Flow<List<ContestEntity>>
    fun getUpcomingContests(): Flow<List<ContestEntity>>
    fun getPastContests(): Flow<List<ContestEntity>>
    fun getOngoingContests(): Flow<List<ContestEntity>>
}