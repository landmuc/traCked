package com.landmuc.questionnaire_presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.landmuc.core_ui.LocalSpacing

@Composable
fun UnitTextField(
    text: String,
    onValueChange: (String) -> Unit,
    unit: String,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
) {
    val spacing = LocalSpacing.current
    val focusManager = LocalFocusManager.current
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Spacer(modifier = Modifier.weight(0.25f))
        OutlinedTextField(
            value = text,
            onValueChange = onValueChange,
            textStyle = MaterialTheme.typography.displayLarge,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down)}
            ),
            singleLine = true,
            modifier = Modifier
                .weight(0.50f)
                .alignBy(LastBaseline)
        )
        Spacer(modifier = Modifier.width(spacing.spaceSmall))
        Text(
            text = unit,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .weight(0.25f)
                .alignBy(LastBaseline)
            )
    }
}