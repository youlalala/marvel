package com.youlalala.marvel.feature.comics.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material.Text
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun TitleText(text: String) = Text(
    text = text,
    fontSize = 12.sp,
    color = Color.Black,
    fontWeight = FontWeight.Bold,
    fontFamily = FontFamily.SansSerif,
    textAlign = TextAlign.Center
)