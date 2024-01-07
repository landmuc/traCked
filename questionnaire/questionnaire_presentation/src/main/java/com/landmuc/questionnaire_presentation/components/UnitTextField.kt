package com.landmuc.questionnaire_presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.landmuc.core_ui.LocalSpacing

@Composable
fun UnitTextField(
    text: String,
    onValueChange: (String) -> Unit,
    unit: String,
    modifier: Modifier = Modifier
) {
   val spacing = LocalSpacing.current
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = onValueChange,
            textStyle = MaterialTheme.typography.displayMedium
        )
        Spacer(modifier = Modifier.width(spacing.spaceSmall))
        Text(
            text = unit,
            style = MaterialTheme.typography.displaySmall
            )
    }
}