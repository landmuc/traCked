package com.landmuc.questionnaire_presentation.personal_info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.landmuc.core_ui.LocalSpacing
import com.landmuc.questionnaire_presentation.components.TextQuestion
import com.landmuc.core.R
import com.landmuc.core.domain.model.Gender
import com.landmuc.core.util.UiEvent
import com.landmuc.questionnaire_presentation.components.ActionButton
import com.landmuc.questionnaire_presentation.components.SelectableButton
import com.landmuc.questionnaire_presentation.components.TopAppBar

@Composable
fun PersonalInfoScreen(
    onNextClick: () -> Unit,
    scaffoldState: ScaffoldState,
    viewModel: PersonalInfoViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    //val listState = rememberLazyListState()
    
   LaunchedEffect(key1 = true) {
       viewModel.uiEvent.collect{ event ->
           when(event) {
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
                firstProgress = 1f
            )
        }
    ) {
        LazyColumn(
            //state = listState,
            contentPadding = it,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = spacing.spaceMedium)
        ) {
            item {
                TextQuestion(
                    questionText = stringResource(id = R.string.whats_your_name),
                    text = viewModel.personalInfoUiState.name,
                    onValueChange = { viewModel.onEvent(PersonalInfoEvent.OnNameEnter(it)) },
                    unit = ""
                )
                Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
                TextQuestion(
                    questionText = stringResource(id = R.string.whats_your_age),
                    text = viewModel.personalInfoUiState.age,
                    onValueChange = { viewModel.onEvent(PersonalInfoEvent.OnAgeEnter(it)) },
                    unit = stringResource(id = R.string.years),
                    keyboardType = KeyboardType.Number
                )
                Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
                TextQuestion(
                    questionText = stringResource(id = R.string.whats_your_height),
                    text = viewModel.personalInfoUiState.height,
                    onValueChange = { viewModel.onEvent(PersonalInfoEvent.OnHeightEnter(it))},
                    unit = stringResource(id = R.string.cm),
                    keyboardType = KeyboardType.Number
                )
                Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
                TextQuestion(
                    questionText = stringResource(id = R.string.whats_your_weight),
                    text = viewModel.personalInfoUiState.weight,
                    onValueChange = { viewModel.onEvent(PersonalInfoEvent.OnWeightEnter(it))},
                    unit = stringResource(id = R.string.kg),
                    keyboardType = KeyboardType.Number
                )
                Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                ) {
                    Text(
                        text = stringResource(id = R.string.whats_your_gender),
                        style = MaterialTheme.typography.displayLarge
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceSmall))
                    Row {
                        SelectableButton(
                            text = stringResource(id = R.string.male),
                            onClick = { viewModel.onEvent(PersonalInfoEvent.OnGenderSelect(Gender.Male)) },
                            isSelected = viewModel.personalInfoUiState.gender is Gender.Male,
                            color = MaterialTheme.colorScheme.primaryContainer,
                            selectedTextColor = Color.Black
                        )
                        Spacer(modifier = Modifier.width(spacing.spaceMedium))
                        SelectableButton(
                            text = stringResource(id = R.string.female),
                            onClick = { viewModel.onEvent(PersonalInfoEvent.OnGenderSelect(Gender.Female)) },
                            isSelected = viewModel.personalInfoUiState.gender is Gender.Female,
                            color = MaterialTheme.colorScheme.primaryContainer,
                            selectedTextColor = Color.Black
                        )
                    }
                }
                Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
                ActionButton(
                    text = stringResource(id = R.string.next),
                    onClick = { viewModel.onNextClick() }
                )
                Spacer(modifier = Modifier.size(300.dp))
            }
        }
    }
}