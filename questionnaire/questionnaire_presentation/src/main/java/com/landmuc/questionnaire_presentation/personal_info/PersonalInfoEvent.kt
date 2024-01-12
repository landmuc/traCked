package com.landmuc.questionnaire_presentation.personal_info

import com.landmuc.core.domain.model.Gender

sealed class PersonalInfoEvent {
    data class OnNameEnter(val name: String) : PersonalInfoEvent()
    data class OnAgeEnter(val age: String) : PersonalInfoEvent()
    data class OnHeightEnter(val height: String) : PersonalInfoEvent()
    data class OnWeightEnter(val weight: String) : PersonalInfoEvent()
    data class OnGenderSelect(val gender: Gender) : PersonalInfoEvent()
}