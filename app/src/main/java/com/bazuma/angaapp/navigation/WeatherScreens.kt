package com.bazuma.angaapp.navigation

//steps 1
//1 - add permision, inherit from application,add hilt,annotate the entry point,add manifest application
//2 - for screens use enum list all screen,use weather  navigation(navcontroller,navhost and navgraph(composable)
enum class WeatherScreens {
    SplashScreen,
    MainScreen,
    AboutScreen,
    FavouriteScreen,
    SearchScreen,
    SettingsScreen
}