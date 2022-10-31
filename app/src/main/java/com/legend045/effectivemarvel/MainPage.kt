package com.legend045.effectivemarvel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun MainPage(navController: NavHostController, heroesState: MutableState<HeroesRowModel>) {
    val color = remember {
        mutableStateOf(Color.Black)
    }


    //val infoScreens = listOf("Iron Man", "Captain America", "Doctor Strange", "Spider Man", "Thor", "Thanos")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color.Black,
                        Color.DarkGray,
                        color.value
                    )
                )
            )
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize(),
        ) {

            Logo()
            Inscription()
            ScrollBar(color, navController, heroesState)

        }
    }
}
