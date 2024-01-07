package com.landmuc.questionnaire_presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.landmuc.core_ui.LocalSpacing

@Composable
fun ButtonQuestion(
    questionText: String,
    leftButtonText: String,
    middleButtonText: String,
    rightButtonText: String,
    leftButtonOnClick: () -> Unit,
    middleButtonOnClick: () -> Unit,
    rightButtonOnClick: () -> Unit,
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
        Row {
            SelectableButton(
                text = leftButtonText,
                onClick = leftButtonOnClick,
                isSelected = false,
                color = Color.Green,
                selectedColor = Color.Green
            )
            SelectableButton(
                text = middleButtonText,
                onClick = middleButtonOnClick,
                isSelected = false,
                color = Color.Green,
                selectedColor = Color.Green
            )
            SelectableButton(
                text = rightButtonText,
                onClick = rightButtonOnClick,
                isSelected = false,
                color = Color.Green,
                selectedColor = Color.Green
            )
        }
    }
}