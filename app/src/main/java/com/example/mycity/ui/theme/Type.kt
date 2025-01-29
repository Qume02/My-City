package com.example.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mycity.R

val AbrilFatface = FontFamily(
    Font(R.font.abrilfatface_regular, FontWeight.Normal)
)

val Lato = FontFamily(
    Font(R.font.lato_regular, FontWeight.Normal)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    displayLarge = TextStyle(
        fontFamily = AbrilFatface,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp
    ),
    displayMedium = TextStyle(
        fontFamily = AbrilFatface,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    )
)
