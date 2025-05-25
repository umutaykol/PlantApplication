package com.example.plantapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF28A745),         // Green buttons like "Continue", "Try Free"
    onPrimary = Color.White,             // Text on green
    secondary = Color(0xFFDDF5E1),       // Light green backgrounds or accents
    onSecondary = Color(0xFF1B4332),     // Dark green text/icons

    background = Color(0xFFF8FAF6),      // Very light natural background
    onBackground = Color(0xFF1E1E1E),    // Main dark text

    surface = Color.White,               // Cards and components
    onSurface = Color(0xFF1E1E1E),       // Text on cards

    error = Color(0xFFD32F2F),
    onError = Color.White
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF28A745),         // Keep buttons green
    onPrimary = Color.Black,             // Dark mode button text

    secondary = Color(0xFF2E3B2C),       // Deep forest green for accents
    onSecondary = Color(0xFFD0F0C0),     // Light green text on accent

    background = Color(0xFF101915),      // Near-black with greenish hue
    onBackground = Color(0xFFE0E0E0),    // Soft white text

    surface = Color(0xFF18211C),         // Slightly lighter than background
    onSurface = Color(0xFFFAFAFA),       // Bright text on cards

    error = Color(0xFFF28B82),
    onError = Color.Black
)

@Composable
fun PlantAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = MaterialTheme.typography,
        shapes = MaterialTheme.shapes,
        content = content
    )
}