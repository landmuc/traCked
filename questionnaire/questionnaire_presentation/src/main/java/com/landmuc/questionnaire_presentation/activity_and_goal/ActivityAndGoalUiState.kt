package com.landmuc.questionnaire_presentation.activity_and_goal

import com.landmuc.core.domain.model.ActivityLevel
import com.landmuc.core.domain.model.GoalType

data class ActivityAndGoalUiState(
    val activityLevel: ActivityLevel = ActivityLevel.Medium,
    val goalType: GoalType = GoalType.KeepWeight
)