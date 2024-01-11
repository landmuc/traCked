package com.landmuc.questionnaire_presentation.personal_info

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
import com.landmuc.questionnaire_presentation.components.TextQuestion
import com.landmuc.core.R
import com.landmuc.questionnaire_presentation.components.ActionButton
import com.landmuc.questionnaire_presentation.components.TopAppBar

@Composable
fun PersonalInfoScreen(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    Scaffold(
        topBar = {
            TopAppBar(
                firstProgress = 1f
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
                TextQuestion(
                    questionText = stringResource(id = R.string.whats_your_gender),
                    text = "",
                    onValueChange = {},
                    unit = ""
                )
                Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
                ActionButton(
                    text = stringResource(id = R.string.next),
                    onClick = onClick
                )
            }
        }
    }
}