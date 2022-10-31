package com.legend045.effectivemarvel

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

//@Preview
@Composable
fun HeroesCards(
    @PreviewParameter(SampleUserProvider::class) hero: HeroesRowModel,
    navController: NavHostController
) {
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = Modifier
            .padding(12.dp)
            .size(width = 385.dp, height = 440.dp),
    ) {

        AsyncImage(
            modifier= Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
                .clickable { navController.navigate(NavRoute.HeroesPage.route)},
            placeholder = painterResource(hero.imageId),
            model = hero.heroesLink,
            contentDescription = hero.heroesName,

            )

        Text(
            text = hero.heroesName,
            fontSize = 25.sp,
            letterSpacing = 0.005.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(1f),
        )
    }
}
