@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.legend045.effectivemarvel

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

class MainActivity : ComponentActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val heroesState = remember {
                mutableStateOf(HeroesRowModel("","", R.drawable.iron_man, "Iron Man", Color.Black))
            }
            PageNavHost(heroesState)
        }
    }
}


@Composable
fun LogoMarvel() {
    Image(
        painter = painterResource(id = R.drawable.marvel),
        contentDescription = "Logo Marvel",
        modifier = Modifier
            .size(width = 100.dp, height = 50.dp),
    )
}

@Preview
@Composable
fun Inscription() {
    Text(
        text = "Choose your hero",
        fontSize = 30.sp,
        letterSpacing = 0.005.sp,
        fontWeight = FontWeight.Bold,
        softWrap = true,
        color = Color.White,
        modifier = Modifier
            .padding(vertical = 30.dp),
        )
}

@OptIn(ExperimentalSnapperApi::class)
@Composable
fun ScrollBar(
    color: MutableState<Color>,
    navController: NavHostController,
    heroesState: MutableState<HeroesRowModel>
) {

    val lazyListState: LazyListState = rememberLazyListState()

    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        state = lazyListState,
        flingBehavior = rememberSnapperFlingBehavior(lazyListState),
    ) {
        itemsIndexed(

            listOf(
                HeroesRowModel(
                    "https://terrigen-cdn-dev.marvel.com/content/prod/1x/002irm_ons_crd_03.jpg",
                    "Я Железный человек.",
                    R.drawable.iron_man, "Iron Man", Color.Black
                ),
                HeroesRowModel(
                    "https://terrigen-cdn-dev.marvel.com/content/prod/1x/003cap_ons_crd_03.jpg",
                    "Пока мы не начали, никто не желает выйти?",
                    R.drawable.captain_america, "Captain America", Color.Blue
                ),
                HeroesRowModel(
                    "https://terrigen-cdn-dev.marvel.com/content/prod/1x/009drs_ons_crd_03.jpg",
                    "Смерть придает жизни смысл.",
                    R.drawable.doctor_strange, "Doctor Strange", Color.Red
                ),
                HeroesRowModel(
                    "https://terrigen-cdn-dev.marvel.com/content/prod/1x/005smp_ons_crd_02.jpg",
                    "У всех есть тайны. Что-то скрываем мы, что-то они.",
                    R.drawable.spider_man, "Spider Man", Color.LightGray
                ),
                HeroesRowModel(
                    "https://terrigen-cdn-dev.marvel.com/content/prod/1x/004tho_ons_crd_04.jpg",
                    "Ты хочешь, чтобы я отпустил молот?!",
                    R.drawable.thor, "Thor", Color.Cyan
                ),
                HeroesRowModel(
                    "https://terrigen-cdn-dev.marvel.com/content/prod/1x/019tha_ons_crd_03.jpg",
                    "Проигрывать всегда горько.",
                    R.drawable.thanos, "Thanos", Color.DarkGray
                ),
            )

        ) { _, item ->
            HeroesCards(hero = item, navController)
            color.value = item.backgroundColor
            heroesState.value = item
        }
    }
}
