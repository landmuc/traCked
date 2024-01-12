package com.landmuc.core.data.preferences

import android.content.SharedPreferences
import com.landmuc.core.domain.model.ActivityLevel
import com.landmuc.core.domain.model.Gender
import com.landmuc.core.domain.model.GoalType
import com.landmuc.core.domain.model.UserInfo
import com.landmuc.core.domain.preferences.Preferences

class DefaultPreferences(
    private val sharedPref: SharedPreferences
): Preferences {
    override fun saveName(name: String) {
        sharedPref.edit()
            .putString(Preferences.KEY_NAME, name)
            .apply()
    }

    override fun saveAge(age: Int) {
        sharedPref.edit()
            .putInt(Preferences.KEY_AGE, age)
            .apply()
    }

    override fun saveHeight(height: Int) {
        sharedPref.edit()
            .putInt(Preferences.KEY_HEIGHT, height)
            .apply()
    }

    override fun saveWeight(weight: Float) {
        sharedPref.edit()
            .putFloat(Preferences.KEY_WEIGHT, weight)
            .apply()
    }

    override fun saveGender(gender: Gender) {
        sharedPref.edit()
            .putString(Preferences.KEY_GENDER, gender.gender)
            .apply()
    }

    override fun saveActivityLevel(activityLevel: ActivityLevel) {
        sharedPref.edit()
            .putString(Preferences.KEY_ACTIVITY_LEVEL, activityLevel.activity)
            .apply()
    }

    override fun saveGoalType(goalType: GoalType) {
        sharedPref.edit()
            .putString(Preferences.KEY_GOAL_TYPE, goalType.goalType)
            .apply()
    }

    override fun saveCarbsRatio(carbsRatio: Int) {
        sharedPref.edit()
            .putInt(Preferences.KEY_CARBS_RATIO, carbsRatio)
            .apply()
    }

    override fun saveProteinRatio(proteinRatio: Int) {
        sharedPref.edit()
            .putInt(Preferences.KEY_PROTEIN_RATIO, proteinRatio)
            .apply()
    }

    override fun saveFatRatio(fatRatio: Int) {
        sharedPref.edit()
            .putInt(Preferences.KEY_FAT_RATIO, fatRatio)
            .apply()
    }

    override fun loadUserInfo(): UserInfo {
        val name =  sharedPref.getString(Preferences.KEY_NAME, null)
        val age = sharedPref.getInt(Preferences.KEY_AGE, -1)
        val height = sharedPref.getInt(Preferences.KEY_HEIGHT, -1)
        val weight = sharedPref.getFloat(Preferences.KEY_WEIGHT, -1f)
        val genderString = sharedPref.getString(Preferences.KEY_GENDER, null)
        val activityLevelString = sharedPref.getString(Preferences.KEY_ACTIVITY_LEVEL, null)
        val goalTypeString = sharedPref.getString(Preferences.KEY_GOAL_TYPE, null)
        val carbsRatio = sharedPref.getInt(Preferences.KEY_CARBS_RATIO, -1)
        val proteinRatio = sharedPref.getInt(Preferences.KEY_PROTEIN_RATIO, -1)
        val fatRatio = sharedPref.getInt(Preferences.KEY_FAT_RATIO, -1)

        return UserInfo(
            name = name ?: "User",
            age = age,
            height = height,
            weight = weight,
            gender = Gender.fromString(genderString ?: "male"),
            activityLevel = ActivityLevel.fromString(activityLevelString ?: "medium"),
            goalType = GoalType.fromString(goalTypeString ?: "keep_weight"),
            carbRatio = carbsRatio,
            proteinRatio = proteinRatio,
            fatRatio = fatRatio
        )
    }

    override fun saveShouldShowOnboarding(shouldShow: Boolean) {
        sharedPref.edit()
            .putBoolean(Preferences.KEY_SHOULD_SHOW_QUESTIONNAIRE, shouldShow)
            .apply()
    }

    override fun loadShouldShowOnboarding(): Boolean {
        return sharedPref.getBoolean(Preferences.KEY_SHOULD_SHOW_QUESTIONNAIRE, true)
    }

}