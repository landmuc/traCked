package com.landmuc.questionnaire_presentation.activity_and_goal

import com.landmuc.core.domain.model.ActivityLevel
import com.landmuc.core.domain.model.GoalType

sealed class ActivityAndGoalEvent {
    data class onActivityLevelSelect(val activityLevel: ActivityLevel): ActivityAndGoalEvent()
    data class onGoalTypeSelect(val goalType: GoalType): ActivityAndGoalEvent()
}