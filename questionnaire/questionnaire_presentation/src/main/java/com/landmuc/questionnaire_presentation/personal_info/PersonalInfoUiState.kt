package com.landmuc.questionnaire_presentation.personal_info

import com.landmuc.core.domain.model.Gender

data class PersonalInfoUiState(
    val name: String = "",
    val age: String = "",
    val height: String = "",
    val weight: String = "",
    val gender: Gender = Gender.Male
)
