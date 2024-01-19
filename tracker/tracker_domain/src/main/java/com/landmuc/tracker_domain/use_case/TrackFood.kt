package com.landmuc.tracker_domain.use_case

import com.landmuc.tracker_domain.model.MealType
import com.landmuc.tracker_domain.model.TrackableFood
import com.landmuc.tracker_domain.model.TrackedFood
import com.landmuc.tracker_domain.repository.TrackerRepository
import java.time.LocalDate
import kotlin.math.roundToInt

class TrackFood(
    private val repository: TrackerRepository
) {

    suspend operator fun invoke(
        food: TrackableFood,
        mealType: MealType,
        amount: Int,
        date: LocalDate
    ) {
       return repository.insertTrackedFood(
           TrackedFood(
               name = food.name,
               carbs = ((food.carbsPer100g / 100f) * amount).roundToInt(),
               protein = ((food.proteinPer100g / 100f) * amount).roundToInt(),
               fat = ((food.fatPer100g / 100f) * amount).roundToInt(),
               imageUrl = food.imageUrl,
               mealType = mealType,
               amount = amount,
               date = date,
               calories = ((food.caloriesPer100g / 100f) * amount).roundToInt()
           )
       )
    }
}