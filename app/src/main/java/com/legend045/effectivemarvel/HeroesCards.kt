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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.legend045.effectivemarvel.network.marvel.data.Result

//@Preview
@Composable
fun HeroesCards(
    @PreviewParameter(SampleUserProvider::class) hero: Result,
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
            // placeholder = painterResource(hero.imageId),
            model = hero.thumbnail.path + "." + hero.thumbnail.extension,
            contentDescription = hero.name,

            )

        Text(
            text = hero.name,
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
