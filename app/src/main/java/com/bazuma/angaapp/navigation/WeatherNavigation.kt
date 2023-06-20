package com.bazuma.angaapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bazuma.angaapp.screens.main.MainScreen
import com.bazuma.angaapp.screens.main.MainViewModel
import com.bazuma.angaapp.screens.splash.WeatherSplashScreen

@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = WeatherScreens.SplashScreen.name ){
         //start at splash screen with actual composable
         composable(WeatherScreens.SplashScreen.name){
             WeatherSplashScreen(navController)
         }
        composable(WeatherScreens.MainScreen.name){
            val mainViewModel= hiltViewModel<MainViewModel>()
            MainScreen(navController,mainViewModel)
        }
    }
}