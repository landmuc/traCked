package com.landmuc.questionnaire_presentation.activity_and_goal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.landmuc.core.domain.preferences.Preferences
import com.landmuc.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActivityAndGoalViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel() {

    var activityAndGoalUiState by mutableStateOf(ActivityAndGoalUiState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: ActivityAndGoalEvent) {
        when(event) {
            is ActivityAndGoalEvent.onActivityLevelSelect -> {
                activityAndGoalUiState = activityAndGoalUiState.copy(
                    activityLevel = event.activityLevel
                )
            }
            is ActivityAndGoalEvent.onGoalTypeSelect -> {
                activityAndGoalUiState = activityAndGoalUiState.copy(
                    goalType = event.goalType
                )
            }
        }
    }

    fun onNextCLick() {
        viewModelScope.launch {
            val activityLevel = activityAndGoalUiState.activityLevel
            val goalType = activityAndGoalUiState.goalType

            preferences.saveActivityLevel(activityLevel)
            preferences.saveGoalType(goalType)

            _uiEvent.send(UiEvent.Success)
        }
    }

}