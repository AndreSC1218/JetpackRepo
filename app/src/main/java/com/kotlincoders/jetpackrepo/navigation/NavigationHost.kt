package com.kotlincoders.jetpackrepo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kotlincoders.jetpackrepo.screens.home.HomeScreen
import com.kotlincoders.jetpackrepo.screens.welcome.WelcomeScreen

@Composable
fun NavigationHost(
    navController:NavHostController
) {
    NavHost(navController = navController, startDestination = NavigationRoute.Welcome.route) {
        //Welcome
        composable(NavigationRoute.Welcome.route){
            WelcomeScreen(onHome = {
                navController.navigate(NavigationRoute.Home.route)
            })
        }
        //Home
        composable(NavigationRoute.Home.route){
            HomeScreen(onUsers = {}, onCars = {})
        }
    }
}