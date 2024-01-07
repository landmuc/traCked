package com.landmuc.tracked.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.landmuc.questionnaire_presentation.QuestionnaireScreen

@Composable
fun Navigation() {
    val navController: NavHostController = rememberNavController()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        NavHost(
            navController = navController,
            startDestination = Route.QUESTIONNAIRE,
            modifier = Modifier.padding(it)
        ) {
            composable(route = Route.QUESTIONNAIRE) {
                QuestionnaireScreen()
            }
        }
    }
}