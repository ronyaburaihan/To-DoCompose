package com.techdoctorbd.to_docompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.techdoctorbd.to_docompose.navigation.SetupNavigation
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navHostController = rememberNavController()
            SetupNavigation(navHostController = navHostController)
        }
    }
}