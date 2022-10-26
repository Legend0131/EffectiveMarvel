package com.legend045.effectivemarvel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
            ){

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize(),
                ) {

                    Logo()
                    Inscription()
                    ScrollBar()

                }
            }
        }
    }
}

@Composable
fun Logo(){ // Логотип Marvel
    Image(
        painter = painterResource(id = R.drawable.marvel),
        contentDescription = "Logo Marvel",
        modifier = Modifier
            .size(width = 100.dp, height = 50.dp),
         )

}

@Preview
@Composable
fun Inscription(){ // Надпись "Choose your hero"
    Text(
        text = "Choose your hero",
        fontSize = 30.sp,
        letterSpacing= 0.005.sp,
        fontWeight= FontWeight.Bold,
        softWrap = true,
        color=Color.White,
        modifier = Modifier
            .padding(vertical = 30.dp),

    )
}

@Composable
fun ScrollBar(){ // Скролл бар с героями
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ){
        itemsIndexed(

            listOf(
                HeroesRowModel(R.drawable.iron_man,  "Iron Man"),
                HeroesRowModel(R.drawable.captain_america,  "Captain America"),
                HeroesRowModel(R.drawable.doctor_strange,  "Doctor Strange"),
                HeroesRowModel(R.drawable.spider_man,  "Spider Man"),
                HeroesRowModel(R.drawable.thor,  "Thor"),
                HeroesRowModel(R.drawable.thanos,  "Thanos"),
            )

        ){
            _, item ->
            HeroesCards(hero = item)
        }
    }
}
