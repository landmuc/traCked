package com.landmuc.questionnaire_presentation.nutrient_goal

sealed class NutrientGoalEvent {
    data class onCarbsRatioEnter(val carbsRatio: String): NutrientGoalEvent()
    data class onProteinRatioEnter(val proteinRatio: String): NutrientGoalEvent()
    data class onFatRatioEnter(val fatRatio: String): NutrientGoalEvent()
    object onNextClick: NutrientGoalEvent()
}