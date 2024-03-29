package com.landmuc.questionnaire_presentation.personal_info

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.landmuc.core.domain.preferences.Preferences
import com.landmuc.core.util.UiEvent
import com.landmuc.core.util.UiText
import com.landmuc.core.R
import com.landmuc.core.domain.use_case.FilterOutDigits
import com.landmuc.core.domain.use_case.FilterOutDigitsAndDots
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonalInfoViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigits,
    private val filterOutDigitsAndDots: FilterOutDigitsAndDots
): ViewModel() {
    var personalInfoUiState by mutableStateOf(PersonalInfoUiState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: PersonalInfoEvent) {
        when(event) {
            is PersonalInfoEvent.OnNameEnter -> {
                personalInfoUiState = personalInfoUiState.copy(name = event.name)
            }
            is PersonalInfoEvent.OnAgeEnter -> {
                if (event.age.length <= 3) {
                    personalInfoUiState = personalInfoUiState.copy(age = filterOutDigits(event.age))
                }
            }
            is PersonalInfoEvent.OnHeightEnter -> {
                if (event.height.length <= 3) {
                    personalInfoUiState = personalInfoUiState.copy(height = filterOutDigits(event.height))
                }
            }
            is PersonalInfoEvent.OnWeightEnter -> {
                if (event.weight.length <= 5) {
                    personalInfoUiState = personalInfoUiState.copy(weight = filterOutDigitsAndDots(event.weight))
                }
            }
            is PersonalInfoEvent.OnGenderSelect -> {
                personalInfoUiState = personalInfoUiState.copy(gender = event.gender)
            }
        }
    }

    fun onNextClick() {
        viewModelScope.launch {
            val name = personalInfoUiState.name.ifEmpty {
                _uiEvent.send(
                    UiEvent.ShowSnackbar(UiText.StringResource(R.string.error_name_cant_be_empty))
                )
                return@launch
            }
            val age = personalInfoUiState.age.toIntOrNull() ?: kotlin.run {
                _uiEvent.send(
                    UiEvent.ShowSnackbar(UiText.StringResource(R.string.error_age_cant_be_empty))
                )
                return@launch
            }
            val height = personalInfoUiState.height.toIntOrNull() ?: kotlin.run {
                _uiEvent.send(
                    UiEvent.ShowSnackbar(UiText.StringResource(R.string.error_height_cant_be_empty))
                )
                return@launch
            }
            val weight = personalInfoUiState.weight.toFloatOrNull() ?: kotlin.run {
                _uiEvent.send(
                    UiEvent.ShowSnackbar(UiText.StringResource(R.string.error_weight_cant_be_empty))
                )
                return@launch
            }
            val gender = personalInfoUiState.gender

            preferences.saveName(name)
            preferences.saveAge(age)
            preferences.saveHeight(height)
            preferences.saveWeight(weight)
            preferences.saveGender(gender)

            _uiEvent.send(UiEvent.Success)
        }
    }
}