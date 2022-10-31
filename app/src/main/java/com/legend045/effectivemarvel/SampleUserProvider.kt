package com.legend045.effectivemarvel

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

// This class is required for @Preview in "HeroesCards.kt"
class SampleUserProvider: PreviewParameterProvider<HeroesRowModel> {
    override val values = sequenceOf(
        HeroesRowModel("","", R.drawable.iron_man,  "Iron Man", Color.Black),
        HeroesRowModel("","", R.drawable.captain_america,  "Captain America", Color.Blue),
        HeroesRowModel("","", R.drawable.doctor_strange,  "Doctor Strange", Color.Red),
        HeroesRowModel("","", R.drawable.spider_man,  "Spider Man", Color.LightGray),
        HeroesRowModel("","", R.drawable.thor,  "Thor", Color.Cyan),
        HeroesRowModel("","", R.drawable.thanos,  "Thanos", Color.DarkGray),
    )
}
