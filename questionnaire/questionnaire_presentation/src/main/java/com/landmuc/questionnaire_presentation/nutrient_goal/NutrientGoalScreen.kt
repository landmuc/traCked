package com.landmuc.questionnaire_presentation.nutrient_goal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.ScaffoldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.landmuc.core.R
import com.landmuc.core.util.UiEvent
import com.landmuc.core_ui.LocalSpacing
import com.landmuc.questionnaire_presentation.components.ActionButton
import com.landmuc.questionnaire_presentation.components.TextQuestionThreeAnswers
import com.landmuc.questionnaire_presentation.components.TopAppBar

@Composable
fun NutrientGoalScreen(
    onBackClick: () -> Unit,
    onNextClick: () -> Unit,
    scaffoldState: ScaffoldState,
    viewModel: NutrientGoalViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect{ event ->
            when(event){
                is UiEvent.Success -> onNextClick()
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        event.message.asString(context)
                    )
                }
                else -> Unit
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                firstProgress = 1f,
                secondProgress = 1f,
                thirdProgress = 1f
            )
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(it)
        ) {
            Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
            TextQuestionThreeAnswers(
                questionText = stringResource(id = R.string.what_are_your_nutrient_goals),
                firstInputText = viewModel.nutrientGoalUiState.carbsRatio,
                secondInputText = viewModel.nutrientGoalUiState.proteinRatio,
                thirdInputText = viewModel.nutrientGoalUiState.fatRatio,
                firstOnValueChange = { carbs -> viewModel.onEvent(NutrientGoalEvent.onCarbsRatioEnter(carbs)) },
                secondOnValueChange = { protein -> viewModel.onEvent(NutrientGoalEvent.onProteinRatioEnter(protein)) },
                thirdOnValueChange = { fat -> viewModel.onEvent(NutrientGoalEvent.onFatRatioEnter(fat)) },
                firstUnit = stringResource(id = R.string.percent_carbs),
                secondUnit = stringResource(id = R.string.percent_proteins),
                thirdUnit = stringResource(id = R.string.percent_fats)
            )
            Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
            Row {
                ActionButton(
                    text = stringResource(id = R.string.back),
                    onClick = onBackClick
                )
                Spacer(modifier = Modifier.width(spacing.spaceLarge))
                ActionButton(
                    text = stringResource(id = R.string.next),
                    onClick = { viewModel.onEvent(NutrientGoalEvent.onNextClick) }
                )
            }
            Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
        }
    }
}