package com.samuelalmeida.cryptocurrencyandroidcompose.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = ColorPrimary,
    background = DarkGray,
    onBackground = TextWhite,
    onPrimary = DarkGray
)

private val LightColorsPalette = lightColors(
    primary = ColorPrimary,
    background = Colorwhite,
    onBackground = MediumGray,
    onPrimary = DarkGray
)

@Composable
fun CryptocurrencyComposeTheme(darkTheme: Boolean = true, content: @Composable() () -> Unit) {
    val colors = if (darkTheme) DarkColorPalette else LightColorsPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}