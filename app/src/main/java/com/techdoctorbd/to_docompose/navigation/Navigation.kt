package com.techdoctorbd.to_docompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.techdoctorbd.to_docompose.navigation.destinations.listComposable
import com.techdoctorbd.to_docompose.navigation.destinations.taskComposable
import com.techdoctorbd.to_docompose.utils.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(navHostController: NavHostController) {
    val screens = remember(navHostController) {
        Screens(navHostController = navHostController)
    }

    NavHost(
        navController = navHostController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(navigateToTaskScreen = screens.task)
        taskComposable(navigateToListScreen = screens.list)
    }
}