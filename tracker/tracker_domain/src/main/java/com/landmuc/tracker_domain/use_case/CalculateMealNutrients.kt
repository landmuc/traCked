package com.landmuc.tracker_domain.use_case

import com.landmuc.core.domain.model.ActivityLevel
import com.landmuc.core.domain.model.Gender
import com.landmuc.core.domain.model.GoalType
import com.landmuc.core.domain.model.UserInfo
import com.landmuc.core.domain.preferences.Preferences
import com.landmuc.tracker_domain.model.MealType
import com.landmuc.tracker_domain.model.TrackedFood
import kotlin.math.roundToInt

/***
 * calculates the total amount of nutrients (carbs, protein, fat, calories)
 * a user has (already) eaten and
 * shows the amount of nutrients a user should eat in a day for comparison.
 * The daily nutrient goal amounts depend on the information entered
 * in the questionnaire module
 */
class CalculateMealNutrients(
    private val preferences: Preferences
) {
    operator fun invoke(trackedFoods: List<TrackedFood>): Result {
        val allNutrients = trackedFoods
            .groupBy { it.mealType }
            .mapValues {entry ->
                // key is the MealType
                val type = entry.key
                // value is the List<TrackedFood> for a given MealType
                val foodList = entry.value
                MealNutrients(
                    carbs = foodList.sumOf { it.carbs },
                    protein = foodList.sumOf { it.protein },
                    fat = foodList.sumOf { it.fat },
                    calories = foodList.sumOf { it.calories },
                    mealType = type
                )
            }
        val totalCarbs = allNutrients.values.sumOf { it.carbs }
        val totalProtein = allNutrients.values.sumOf { it.protein }
        val totalFat = allNutrients.values.sumOf { it.fat }
        val totalCalories = allNutrients.values.sumOf { it.calories }

        val userInfo = preferences.loadUserInfo()
        val caloryGoal = dailyCaloryRequirement(userInfo)
        // 1g of carbs  = 4 kcal
        // Example: 500 kcal * 0.5 = 250kcal / 4 kcal/carbs = 62.5 carbs
        val carbsGoal = (caloryGoal * userInfo.carbRatio / 4f).roundToInt()
        // 1g of protein = 4 kcal
        val proteinGoal = (caloryGoal * userInfo.proteinRatio / 4f).roundToInt()
        // 1g of fat = 9 kcal
        val fatGoal = (caloryGoal * userInfo.fatRatio / 9f).roundToInt()

        return Result(
            carbsGoal = carbsGoal,
            proteinGoal = proteinGoal,
            fatGoal = fatGoal,
            caloriesGoal = caloryGoal,
            totalCarbs = totalCarbs,
            totalProtein = totalProtein,
            totalFat = totalFat,
            totalCalories = totalCalories,
            mealNutrients = allNutrients
        )
    }

    private fun bmr(userInfo: UserInfo): Int {
        return when(userInfo.gender) {
            is Gender.Male -> {
                (66.47f + 13.75f * userInfo.weight +
                        5f * userInfo.height - 6.75f * userInfo.age).roundToInt()
            }
            is Gender.Female ->  {
                (665.09f + 9.56f * userInfo.weight +
                        1.84f * userInfo.height - 4.67 * userInfo.age).roundToInt()
            }
        }
    }

    private fun dailyCaloryRequirement(userInfo: UserInfo): Int {
        val activityFactor = when(userInfo.activityLevel) {
            is ActivityLevel.Low -> 1.2f
            is ActivityLevel.Medium -> 1.3f
            is ActivityLevel.High -> 1.4f
        }
        val caloryExtra = when(userInfo.goalType) {
            is GoalType.LoseWeight -> -500
            is GoalType.KeepWeight -> 0
            is GoalType.GainWeight -> 500
        }
        return (bmr(userInfo) * activityFactor + caloryExtra).roundToInt()
    }
    data class MealNutrients(
        val carbs: Int,
        val protein: Int,
        val fat: Int,
        val calories: Int,
        val mealType: MealType
    )
    data class Result(
        val carbsGoal: Int,
        val proteinGoal: Int,
        val fatGoal: Int,
        val caloriesGoal: Int,
        val totalCarbs: Int,
        val totalProtein: Int,
        val totalFat: Int,
        val totalCalories: Int,
        val mealNutrients: Map<MealType, MealNutrients>
    )
}