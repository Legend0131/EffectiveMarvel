package com.legend045.effectivemarvel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class NavRoute(val route: String){
    object MainPage: NavRoute("main_page")
    object HeroesPage: NavRoute("heroes_page")
}

@Composable
fun PageNavHost(heroesState: MutableState<HeroesRowModel>) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavRoute.MainPage.route
    ) {
        composable(NavRoute.MainPage.route) {
            MainPage(navController, heroesState)
        }
        composable(NavRoute.HeroesPage.route) {
            HeroesPage(navController, heroesState)
        }
    }
}
