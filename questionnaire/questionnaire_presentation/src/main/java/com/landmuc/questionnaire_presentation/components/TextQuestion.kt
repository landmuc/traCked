package com.landmuc.questionnaire_presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.text.input.KeyboardType
import com.landmuc.core_ui.LocalSpacing

@Composable
fun TextQuestion(
    questionText: String,
    text: String,
    onValueChange: (String) -> Unit,
    unit: String,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
) {
    val spacing = LocalSpacing.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = questionText,
            style = MaterialTheme.typography.displayLarge
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        UnitTextField(
            text = text,
            onValueChange = onValueChange,
            unit = unit,
            keyboardType = keyboardType
        )
    }

}