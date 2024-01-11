package com.landmuc.core.domain.model

// you can't save a sealed class directly in shared preferences
// so you need a string or another value which shared preferences understands

// this would also work with an enum class
// so you would not have to make a function "fromString"
sealed class Gender(val gender: String) {
    object Male: Gender("male")
    object Female: Gender("female")

    // to transform the string saved in SharedPreferences to the gender object
    companion object {
        fun fromString(gender: String): Gender {
            return when(gender) {
                "male" -> Male
                "female" -> Female
                else -> Male
            }
        }
    }
}
