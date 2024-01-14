package com.landmuc.questionnaire_presentation.activity_and_goal

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.landmuc.core_ui.LocalSpacing
import com.landmuc.questionnaire_presentation.components.ButtonQuestion
import com.landmuc.core.R
import com.landmuc.core.domain.model.ActivityLevel
import com.landmuc.core.domain.model.GoalType
import com.landmuc.core.util.UiEvent
import com.landmuc.questionnaire_presentation.components.ActionButton
import com.landmuc.questionnaire_presentation.components.TopAppBar

@Composable
fun ActivityAndGoalScreen(
    onBackClick: () -> Unit,
    onNextClick: () -> Unit,
    viewModel: ActivityAndGoalViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect {event ->
            when(event) {
                is UiEvent.Success -> onNextClick()
                else -> Unit
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                firstProgress = 1f,
                secondProgress = 1f
            )
        }
    ) {
        LazyColumn(
            contentPadding = it,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = spacing.spaceMedium)
        ) {
            item {
                ButtonQuestion(
                    questionText = stringResource(id = R.string.whats_your_activity_level),
                    leftButtonText = stringResource(id = R.string.high),
                    middleButtonText = stringResource(id = R.string.medium),
                    rightButtonText = stringResource(id = R.string.low),
                    leftButtonOnClick = { viewModel.onEvent(ActivityAndGoalEvent.onActivityLevelSelect(ActivityLevel.High)) },
                    middleButtonOnClick = { viewModel.onEvent(ActivityAndGoalEvent.onActivityLevelSelect(ActivityLevel.Medium)) },
                    rightButtonOnClick = { viewModel.onEvent(ActivityAndGoalEvent.onActivityLevelSelect(ActivityLevel.Low))},
                    leftButtonIsSelected = viewModel.activityAndGoalUiState.activityLevel is ActivityLevel.High,
                    middleButtonIsSelected = viewModel.activityAndGoalUiState.activityLevel is ActivityLevel.Medium,
                    rightButtonIsSelected = viewModel.activityAndGoalUiState.activityLevel is ActivityLevel.Low
                )
                Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
                ButtonQuestion(
                    questionText = stringResource(id = R.string.lose_keep_or_gain_weight),
                    leftButtonText = stringResource(id = R.string.gain),
                    middleButtonText = stringResource(id = R.string.keep),
                    rightButtonText = stringResource(id = R.string.lose),
                    leftButtonOnClick = { viewModel.onEvent(ActivityAndGoalEvent.onGoalTypeSelect(GoalType.GainWeight)) },
                    middleButtonOnClick = { viewModel.onEvent(ActivityAndGoalEvent.onGoalTypeSelect(GoalType.KeepWeight)) },
                    rightButtonOnClick = { viewModel.onEvent(ActivityAndGoalEvent.onGoalTypeSelect(GoalType.LoseWeight))},
                    leftButtonIsSelected = viewModel.activityAndGoalUiState.goalType is GoalType.GainWeight,
                    middleButtonIsSelected = viewModel.activityAndGoalUiState.goalType is GoalType.KeepWeight,
                    rightButtonIsSelected = viewModel.activityAndGoalUiState.goalType is GoalType.LoseWeight
                )
                Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
                Row {
                    ActionButton(
                        text = stringResource(id = R.string.back),
                        onClick = onBackClick
                    )
                    ActionButton(
                        text = stringResource(id = R.string.next),
                        onClick = { viewModel.onNextCLick() }
                    )
                }
            }
        }
    }
}