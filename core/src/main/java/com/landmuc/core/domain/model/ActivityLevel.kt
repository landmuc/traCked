package com.landmuc.core.domain.model

sealed class ActivityLevel(val activity: String) {
    object Low: ActivityLevel("low")
    object Medium: ActivityLevel("medium")
    object High: ActivityLevel("high")

    companion object {
        fun fromString(activity: String): ActivityLevel {
            return when(activity) {
                "low" -> Low
                "medium" -> Medium
                "high" -> High
                else -> Medium
            }
        }
    }
}