package com.landmuc.tracker_domain.repository

import com.landmuc.tracker_domain.model.TrackableFood
import com.landmuc.tracker_domain.model.TrackedFood
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface TrackerRepository {
    suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>>
    // Result is a wrapper class which helps us to distinguish between Success and Error cases

    suspend fun insertTrackedFood(food: TrackedFood)

    suspend fun deleteTrackedFood(food: TrackedFood)

    fun getFoodsForDate(localDate: LocalDate): Flow<List<TrackedFood>>
}