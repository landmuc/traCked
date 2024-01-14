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
import com.landmuc.questionnaire_presentation.activity_and_goal.ActivityAndGoalScreen
import com.landmuc.questionnaire_presentation.nutrient_goal.NutrientGoalScreen
import com.landmuc.questionnaire_presentation.personal_info.PersonalInfoScreen

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
            startDestination = Route.PERSONALINFO,
            modifier = Modifier.padding(it)
        ) {
            composable(route = Route.PERSONALINFO) {
                PersonalInfoScreen(
                    onNextClick = { navController.navigate(Route.ACTIVITYANDGOAL) },
                    scaffoldState = scaffoldState
                )
            }
            composable(route = Route.ACTIVITYANDGOAL) {
                ActivityAndGoalScreen(
                    onBackClick = { navController.navigateUp()},
                    onNextClick = { navController.navigate(Route.NUTRIENTGOAL) }
                )
            }
            composable(route = Route.NUTRIENTGOAL) {
                NutrientGoalScreen(
                    onBackClick = { navController.navigateUp()},
                    onNextClick = {navController.navigate(Route.TRACKER)},
                    scaffoldState = scaffoldState
                )
            }
        }
    }
}