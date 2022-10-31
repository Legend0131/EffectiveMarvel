package com.legend045.effectivemarvel

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

@Composable
fun HeroesPage(navController: NavHostController, heroesState: MutableState<HeroesRowModel>) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Box(
            contentAlignment = Alignment.BottomStart,
        ) {

            AsyncImage(
                modifier= Modifier.fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .clickable { navController.navigate(NavRoute.MainPage.route)},
                placeholder = painterResource(heroesState.value.imageId),
                model = heroesState.value.heroesLink,
                contentDescription = heroesState.value.heroesName,

                )

            Column {
                Text(
                    text = heroesState.value.heroesName,
                    fontSize = 25.sp,
                    letterSpacing = 0.005.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth(1f),
                )
                Text(
                    text = heroesState.value.heroesInfo,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(1f),
                )
            }
        }
    }
}
