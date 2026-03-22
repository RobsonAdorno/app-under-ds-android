package com.undercore.core.designsystem

import androidx.activity.ComponentActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// ── Color Schemes ──────────────────────────────────────────────────────────

/**
 * Light scheme — beige quente + cards brancos + gold.
 * Tema padrao do app.
 */
private val UnderLightColors = lightColorScheme(
    primary              = UnderColors.Gold,
    onPrimary            = UnderColors.Black,
    primaryContainer     = Color(0xFFFFF3D0),
    onPrimaryContainer   = Color(0xFF3A2E00),
    secondary            = UnderColors.Gold,
    onSecondary          = UnderColors.Black,
    secondaryContainer   = Color(0xFFFFF0C0),
    onSecondaryContainer = Color(0xFF3A2E00),
    background           = UnderColors.BeigeBg,
    onBackground         = UnderColors.OnBeige,
    surface              = UnderColors.CardWhite,
    onSurface            = UnderColors.OnBeige,
    surfaceVariant       = UnderColors.SurfaceWarm,
    onSurfaceVariant     = UnderColors.TextSecLight,
    outline              = UnderColors.OutlineLight,
    outlineVariant       = Color(0xFFF0EBE0),
    error                = UnderColors.Error,
    onError              = UnderColors.OnError,
    scrim                = Color(0x80000000),
)

/** Dark scheme — gold sobre near-black. */
private val UnderDarkColors = darkColorScheme(
    primary              = UnderColors.Gold,
    onPrimary            = UnderColors.Black,
    primaryContainer     = Color(0xFF3A2E00),
    onPrimaryContainer   = UnderColors.Gold,
    secondary            = UnderColors.Gold,
    onSecondary          = UnderColors.Black,
    secondaryContainer   = Color(0xFF2A2200),
    onSecondaryContainer = UnderColors.Gold,
    background           = UnderColors.Background,
    onBackground         = UnderColors.OnBackground,
    surface              = UnderColors.Surface,
    onSurface            = UnderColors.OnSurface,
    surfaceVariant       = UnderColors.SurfaceVar,
    onSurfaceVariant     = UnderColors.OnSurfaceVar,
    outline              = UnderColors.Outline,
    outlineVariant       = UnderColors.OutlineVar,
    error                = UnderColors.Error,
    onError              = UnderColors.OnError,
    scrim                = UnderColors.Black,
)

// ── Theme Composable ───────────────────────────────────────────────────────

/**
 * UnderDS Theme — wrapper sobre MaterialTheme.
 *
 * Aplica color scheme, tipografia, shapes e spacing tokens.
 * Configura automaticamente os icones da status bar.
 *
 * ```kotlin
 * // Em MainActivity:
 * UnderTheme(darkTheme = false) {
 *     AppNavigation()
 * }
 * ```
 */
@Composable
fun UnderTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit,
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as ComponentActivity).window
            WindowCompat.getInsetsController(window, view)
                .isAppearanceLightStatusBars = !darkTheme
        }
    }

    CompositionLocalProvider(
        LocalUnderSpacing provides UnderSpacingValues(),
    ) {
        MaterialTheme(
            colorScheme = if (darkTheme) UnderDarkColors else UnderLightColors,
            typography  = UnderTypography,
            shapes      = UnderShapes,
            content     = content,
        )
    }
}

// ── Accessor ───────────────────────────────────────────────────────────────

/** Atalho para acessar tokens do UnderDS dentro de um [UnderTheme]. */
object UnderTheme {
    val spacing: UnderSpacingValues
        @Composable get() = LocalUnderSpacing.current
}
