package com.example.splitapp.presentation.core

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import com.example.splitapp.ui.theme.fonts

object SplitTypography {
    val SplitStyle700:TextStyle =TextStyle(
       fontFamily = fonts, fontWeight = FontWeight.Bold
    )

    val SplitStyle600:TextStyle = TextStyle(
       fontFamily = fonts, fontWeight =FontWeight.SemiBold
    )

    val SplitStyle500:TextStyle = TextStyle(
        fontFamily = fonts, fontWeight = FontWeight.Medium
    )

    val SplitStyle400 : TextStyle = TextStyle(
        fontFamily = fonts , fontWeight = FontWeight.Normal
    )
}