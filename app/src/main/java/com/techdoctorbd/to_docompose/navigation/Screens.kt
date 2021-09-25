package com.techdoctorbd.to_docompose.navigation

import androidx.navigation.NavHostController
import com.techdoctorbd.to_docompose.utils.Action
import com.techdoctorbd.to_docompose.utils.Constants.LIST_SCREEN

class Screens(navHostController: NavHostController) {
    val list: (Action) -> Unit = {
        navHostController.navigate("list/${it.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = { taskId ->
        navHostController.navigate("task/$taskId")
    }
}