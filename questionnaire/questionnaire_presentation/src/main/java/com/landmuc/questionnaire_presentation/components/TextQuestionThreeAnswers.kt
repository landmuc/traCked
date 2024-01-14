package com.landmuc.questionnaire_presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.landmuc.core_ui.LocalSpacing

@Composable
fun TextQuestionThreeAnswers(
    questionText: String,
    firstInputText: String,
    secondInputText: String,
    thirdInputText: String,
    firstOnValueChange: (String) -> Unit,
    secondOnValueChange: (String) -> Unit,
    thirdOnValueChange: (String) -> Unit,
    firstUnit: String,
    secondUnit: String,
    thirdUnit: String,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = questionText,
            style = MaterialTheme.typography.displayLarge
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            UnitTextField(
                text = firstInputText,
                onValueChange = firstOnValueChange,
                unit = firstUnit
            )
            UnitTextField(
                text = secondInputText,
                onValueChange = secondOnValueChange,
                unit = secondUnit
            )
            UnitTextField(
                text = thirdInputText,
                onValueChange = thirdOnValueChange,
                unit = thirdUnit
            )
        }
    }

}