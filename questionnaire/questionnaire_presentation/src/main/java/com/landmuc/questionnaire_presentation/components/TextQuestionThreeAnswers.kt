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
    LeftInputText: String,
    MiddleInputText: String,
    RightInputText: String,
    LeftOnValueChange: (String) -> Unit,
    MiddleOnValueChange: (String) -> Unit,
    RightOnValueChange: (String) -> Unit,
    unit: String,
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
            style = MaterialTheme.typography.displayMedium
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            UnitTextField(
                text = LeftInputText,
                onValueChange = LeftOnValueChange,
                unit = unit
            )
            UnitTextField(
                text = MiddleInputText,
                onValueChange = MiddleOnValueChange,
                unit = unit
            )
            UnitTextField(
                text = RightInputText,
                onValueChange = RightOnValueChange,
                unit = unit
            )
        }
    }

}