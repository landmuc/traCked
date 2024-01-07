package com.landmuc.questionnaire_presentation

import androidx.compose.runtime.Composable
import com.landmuc.questionnaire_presentation.components.UnitTextField

@Composable
fun QuestionnaireScreen() {
    UnitTextField(text = "Hello", onValueChange = {}, unit = "cm")
}