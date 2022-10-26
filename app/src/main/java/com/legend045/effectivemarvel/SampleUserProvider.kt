package com.legend045.effectivemarvel

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

// This class is required for @Preview in "HeroesCards.kt"
class SampleUserProvider: PreviewParameterProvider<HeroesRowModel> {
    override val values = sequenceOf(
        HeroesRowModel(R.drawable.iron_man,  "Iron Man"),
        HeroesRowModel(R.drawable.captain_america,  "Captain America"),
        HeroesRowModel(R.drawable.doctor_strange,  "Doctor Strange"),
        HeroesRowModel(R.drawable.spider_man,  "Spider Man"),
        HeroesRowModel(R.drawable.thor,  "Thor"),
        HeroesRowModel(R.drawable.thanos,  "Thanos"),
    )
}
