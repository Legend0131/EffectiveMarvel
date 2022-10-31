package com.legend045.effectivemarvel

import androidx.compose.ui.graphics.Color

data class HeroesRowModel(
    val heroesLink: String,
    val heroesInfo: String,
    val imageId: Int,
    val heroesName: String,
    val backgroundColor: Color
)
