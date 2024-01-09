package com.landmuc.questionnaire_presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LastBaseline
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
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = onValueChange,
            textStyle = MaterialTheme.typography.displayMedium,
            singleLine = true,
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .alignBy(LastBaseline)
        )
        Spacer(modifier = Modifier.width(spacing.spaceSmall))
        Text(
            text = unit,
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier
                .alignBy(LastBaseline)
            )
    }
}