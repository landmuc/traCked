package com.landmuc.questionnaire_presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.landmuc.core_ui.LocalSpacing
import com.landmuc.questionnaire_presentation.components.ButtonQuestion
import com.landmuc.questionnaire_presentation.components.TextQuestion
import com.landmuc.core.R
import com.landmuc.questionnaire_presentation.components.TextQuestionThreeAnswers
import com.landmuc.questionnaire_presentation.components.TopAppBar

@Composable
fun QuestionnaireScreen(
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
  Scaffold(
      topBar = {
          TopAppBar()
      }
  ) {
      LazyColumn(
          contentPadding = it,
          horizontalAlignment = Alignment.CenterHorizontally,
          modifier = modifier
              .fillMaxSize()
              .padding(bottom = spacing.spaceMedium)
      ) {
          item {
              TextQuestion(
                  questionText = stringResource(id = R.string.whats_your_name),
                  text = "",
                  onValueChange = {},
                  unit = "    "
              )
              Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
              TextQuestion(
                  questionText = stringResource(id = R.string.whats_your_age),
                  text = "",
                  onValueChange = {},
                  unit = stringResource(id = R.string.years)
              )
              Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
              TextQuestion(
                  questionText = stringResource(id = R.string.whats_your_gender),
                  text = "",
                  onValueChange = {},
                  unit = ""
              )
              Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
              TextQuestion(
                  questionText = stringResource(id = R.string.whats_your_height),
                  text = "",
                  onValueChange = {},
                  unit = stringResource(id = R.string.cm)
              )
              Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
              TextQuestion(
                  questionText = stringResource(id = R.string.whats_your_weight),
                  text = "",
                  onValueChange = {},
                  unit = stringResource(id = R.string.kg)
              )
              Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
              ButtonQuestion(
                  questionText = stringResource(id = R.string.whats_your_activity_level),
                  leftButtonText = stringResource(id = R.string.high),
                  middleButtonText = stringResource(id = R.string.medium),
                  rightButtonText = stringResource(id = R.string.low),
                  leftButtonOnClick = { /*TODO*/ },
                  middleButtonOnClick = { /*TODO*/ },
                  rightButtonOnClick = { /*TODO*/ }
              )
              Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
              ButtonQuestion(
                  questionText = stringResource(id = R.string.lose_keep_or_gain_weight),
                  leftButtonText = stringResource(id = R.string.gain),
                  middleButtonText = stringResource(id = R.string.keep),
                  rightButtonText = stringResource(id = R.string.lose),
                  leftButtonOnClick = { /*TODO*/ },
                  middleButtonOnClick = { /*TODO*/ },
                  rightButtonOnClick = { /*TODO*/ }
              )
              Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
              TextQuestionThreeAnswers(
                  questionText = stringResource(id = R.string.what_are_your_nutrient_goals),
                  LeftInputText = "Hello",
                  MiddleInputText = "Hello2",
                  RightInputText = "Hello3",
                  LeftOnValueChange = {},
                  MiddleOnValueChange = {},
                  RightOnValueChange = {},
                  unit = stringResource(id = R.string.percent_fats)
              )
          }
      }
  }
}