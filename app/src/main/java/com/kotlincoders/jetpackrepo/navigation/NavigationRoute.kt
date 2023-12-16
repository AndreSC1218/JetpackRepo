package com.kotlincoders.jetpackrepo.navigation

sealed class NavigationRoute(val route:String) {
    object Welcome : NavigationRoute("welcome")
    object Home : NavigationRoute("home")
}