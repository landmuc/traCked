package com.landmuc.core.domain.model

sealed class GoalType(goalType: String) {
    object LoseWeight: GoalType("lose_weight")
    object KeepWeight: GoalType("keep_weight")
    object GainWeight: GoalType("gain_weight")

    companion object {
        fun fromString(goalType: String): GoalType {
            return when(goalType) {
                "lose_weight" -> LoseWeight
                "keep_weight" -> KeepWeight
                "Gain_weight" -> GainWeight
                else -> KeepWeight
            }
        }
    }
}