package com.landmuc.questionnaire_presentation.nutrient_goal

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
import com.landmuc.questionnaire_domain.use_case.ValidateNutrients
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NutrientGoalViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigits,
    private val validateNutrients: ValidateNutrients
): ViewModel() {

    var nutrientGoalUiState by mutableStateOf(NutrientGoalUiState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: NutrientGoalEvent) {
        when(event) {
            is NutrientGoalEvent.onCarbsRatioEnter -> {
                if (event.carbsRatio.length <= 2) {
                    nutrientGoalUiState = nutrientGoalUiState.copy(carbsRatio = filterOutDigits(event.carbsRatio))
                }
            }
            is NutrientGoalEvent.onProteinRatioEnter -> {
                if (event.proteinRatio.length <= 2) {
                    nutrientGoalUiState = nutrientGoalUiState.copy(proteinRatio = filterOutDigits(event.proteinRatio))
                }
            }
            is NutrientGoalEvent.onFatRatioEnter -> {
                if (event.fatRatio.length <= 2) {
                    nutrientGoalUiState = nutrientGoalUiState.copy(fatRatio = filterOutDigits(event.fatRatio))
                }
            }
            is NutrientGoalEvent.onNextClick -> {
                val result = validateNutrients(nutrientGoalUiState.carbsRatio, nutrientGoalUiState.proteinRatio, nutrientGoalUiState.fatRatio)
                when(result) {
                    is ValidateNutrients.Result.Success -> {
                        preferences.saveCarbsRatio(result.carbsRatio)
                        preferences.saveProteinRatio(result.proteinRatio)
                        preferences.saveFatRatio(result.fatRatio)
                        viewModelScope.launch {
                            _uiEvent.send(UiEvent.Success)
                        }
                    }
                    is ValidateNutrients.Result.Error -> {
                        viewModelScope.launch {
                            _uiEvent.send(UiEvent.ShowSnackbar(result.message))
                        }
                    }
                }
            }
        }
    }

}