package com.steli.app.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = SteliInk,
    onPrimary = SteliSurface,
    // Keep secondary neutral so default Material components don't introduce purple tints.
    secondary = SteliInkMuted,
    onSecondary = SteliSurface,
    primaryContainer = SteliSurface,
    onPrimaryContainer = SteliInk,
    secondaryContainer = SteliSurfaceVariant,
    onSecondaryContainer = SteliInk,
    background = SteliLavenderBg,
    onBackground = SteliInk,
    surface = SteliSurface,
    onSurface = SteliInk,
    surfaceVariant = SteliSurfaceVariant,
    onSurfaceVariant = SteliInkMuted,
    surfaceContainerHighest = SteliSurface,
    surfaceContainerHigh = SteliSurface,
    surfaceContainer = SteliSurface,
    surfaceContainerLow = SteliSurface,
    surfaceContainerLowest = SteliSurface,
    outline = SteliOutline,
    outlineVariant = SteliOutline.copy(alpha = 0.7f),
    inverseSurface = SteliInk,
    inverseOnSurface = SteliSurface,
    tertiary = SteliInkMuted,
    onTertiary = SteliSurface,
)

// Keep dark theme usable, but not a focus for mockup parity right now.
private val DarkColorScheme: ColorScheme = darkColorScheme()

@Composable
fun SteliTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            // Match background tint like the mockups.
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
