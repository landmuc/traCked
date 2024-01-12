package com.landmuc.core.domain.model

data class UserInfo(
    val name: String,
    val age: Int,
    val height: Int,
    val weight: Float,
    val gender: Gender,
    val activityLevel: ActivityLevel,
    val goalType: GoalType,
    val carbRatio: Int,
    val proteinRatio: Int,
    val fatRatio: Int
)