package com.landmuc.questionnaire_presentation.nutrient_goal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.landmuc.core.R
import com.landmuc.core_ui.LocalSpacing
import com.landmuc.questionnaire_presentation.components.ActionButton
import com.landmuc.questionnaire_presentation.components.TextQuestionThreeAnswers
import com.landmuc.questionnaire_presentation.components.TopAppBar

@Composable
fun NutrientGoalScreen(
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
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
           modifier = modifier.padding(it)
       ) {
           TextQuestionThreeAnswers(
               questionText = stringResource(id = R.string.what_are_your_nutrient_goals),
               leftInputText = "Hello",
               middleInputText = "Hello2",
               rightInputText = "Hello3",
               leftOnValueChange = {},
               middleOnValueChange = {},
               rightOnValueChange = {},
               unit = stringResource(id = R.string.percent_fats)
           )
           Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
           ActionButton(
               text = stringResource(id = R.string.next),
               onClick = { /*TODO*/ }
           )
       }
    }

}