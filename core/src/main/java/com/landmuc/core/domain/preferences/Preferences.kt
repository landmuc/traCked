package com.landmuc.core.domain.preferences

import com.landmuc.core.domain.model.ActivityLevel
import com.landmuc.core.domain.model.Gender
import com.landmuc.core.domain.model.GoalType
import com.landmuc.core.domain.model.UserInfo

interface Preferences {
    fun saveName(name: String)
    fun saveAge(age: Int)
    fun saveHeight(height: Int)
    fun saveWeight(weight: Float)
    fun saveGender(gender: Gender)
    fun saveActivityLevel(activityLevel: ActivityLevel)
    fun saveGoalType(goalType: GoalType)
    fun saveCarbsRatio(carbsRatio: Int)
    fun saveProteinRatio(proteinRatio: Int)
    fun saveFatRatio(fatRatio: Int)

    fun loadUserInfo(userInfo: UserInfo)

    fun saveShouldShowOnboarding(shouldShow: Boolean)
    fun loadShouldShowOnboarding(): Boolean

    companion object {
        const val KEY_NAME = "name"
        const val KEY_AGE = "age"
        const val KEY_HEIGHT = "height"
        const val KEY_WEIGHT = "weight"
        const val KEY_GENDER = "gender"
        const val KEY_ACTIVITY_LEVEL = "activity_level"
        const val KEY_GOAL_TYPE = "goal_type"
        const val KEY_CARBS_RATIO = "carbs_ratio"
        const val KEY_PROTEIN_RATIO = "protein_ratio"
        const val KEY_FAT_RATIO = "fat_ratio"
        const val KEY_SHOULD_SHOW_QUESTIONNAIRE = "should_show_questionnaire"
    }
}