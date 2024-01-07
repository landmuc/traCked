package com.landmuc.questionnaire_presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.landmuc.core_ui.LocalSpacing

@Composable
fun TextQuestion(
    questionText: String,
    text: String,
    onValueChange: (String) -> Unit,
    unit: String,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = questionText,
            style = MaterialTheme.typography.displayMedium
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        UnitTextField(
            text = text,
            onValueChange = onValueChange,
            unit = unit
        )
    }

}