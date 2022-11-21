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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.legend045.effectivemarvel.network.marvel.data.Result

@Composable
fun HeroesPage(
    navController: NavHostController,
    hero: Result?
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Box(
            contentAlignment = Alignment.BottomStart,
        ) {

            if (hero != null) {
                AsyncImage(
                    modifier= Modifier.fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .clickable { navController.navigate(NavRoute.MainPage.route)},
                    //placeholder = painterResource(heroesState.value.imageId),
                    model = hero.thumbnail.path + "." + hero.thumbnail.extension,
                    contentDescription = hero.name,

                    )
            }

            Column {
                if (hero != null) {
                    Text(
                        text = hero.name,
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
                        text = hero.description,
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
}
