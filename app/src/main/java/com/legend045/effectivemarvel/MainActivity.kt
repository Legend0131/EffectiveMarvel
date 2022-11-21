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
import com.legend045.effectivemarvel.network.marvel.data.HeroesData


class MainActivity : ComponentActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PageNavHost()
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
    //color: MutableState<Color>,
    navController: NavHostController,
    heroes: HeroesData?
) {

    val lazyListState: LazyListState = rememberLazyListState()

    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        state = lazyListState,
        flingBehavior = rememberSnapperFlingBehavior(lazyListState),
    ) {
        if (heroes != null) {
            itemsIndexed(
                heroes.data.results


            ) { _, item ->
                HeroesCards(hero = item, navController)

            }
        }
    }
}
