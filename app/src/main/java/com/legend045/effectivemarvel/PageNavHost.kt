package com.legend045.effectivemarvel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class NavRoute(val route: String){
    object MainPage: NavRoute("main_page")
    object HeroesPage: NavRoute("heroes_page")
}

@Composable
fun PageNavHost() {
    val viewModel = viewModel(modelClass = OverviewViewModel::class.java)
    val heroes by viewModel.heroesData.observeAsState()
    val hero by viewModel.heroData.observeAsState()

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavRoute.MainPage.route
    ) {
        composable(NavRoute.MainPage.route) {
            MainPage(navController, heroes)
        }
        composable(NavRoute.HeroesPage.route) {
            HeroesPage(navController, hero)
        }
    }
}
