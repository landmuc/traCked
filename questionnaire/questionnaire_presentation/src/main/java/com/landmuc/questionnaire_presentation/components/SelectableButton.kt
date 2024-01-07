package com.landmuc.questionnaire_presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.landmuc.core_ui.LocalSpacing

@Composable
fun SelectableButton(
    text: String,
    onClick: () -> Unit,
    isSelected: Boolean,
    color: Color,
    selectedColor: Color,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.displayMedium
) {
    val spacing = LocalSpacing.current
    Box(
        modifier = modifier
            .clickable { onClick() }
            .clip(RoundedCornerShape(100.dp))
            .border(
                width = 2.dp,
                color = if (isSelected) selectedColor else color,
                shape = RoundedCornerShape(100.dp)
            )
            .background(
                color = if (isSelected) selectedColor else color,
                shape = RoundedCornerShape(100.dp)
            )
            .padding(spacing.spaceMedium),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (isSelected) selectedColor else color,
            style = textStyle
        )
    }
}