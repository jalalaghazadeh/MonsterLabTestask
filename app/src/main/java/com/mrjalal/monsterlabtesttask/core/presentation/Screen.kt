package com.mrjalal.monsterlabtesttask.core.presentation

sealed class Screen(val route:String) {
    object SignUp: Screen(route = "SignUpScreen")
    object Home:Screen(route = "HomeScreen")
}
