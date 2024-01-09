package com.landmuc.questionnaire_presentation.activity_and_goal

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
import com.landmuc.core.R
import com.landmuc.questionnaire_presentation.components.ActionButton
import com.landmuc.questionnaire_presentation.components.TopAppBar

@Composable
fun ActivityAndGoalScreen(
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
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
            modifier = modifier
                .fillMaxSize()
                .padding(bottom = spacing.spaceMedium)
        ) {
            item {
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
                ActionButton(
                    text = stringResource(id = R.string.next),
                    onClick = { /*TODO*/ }
                )
            }
        }
    }
}