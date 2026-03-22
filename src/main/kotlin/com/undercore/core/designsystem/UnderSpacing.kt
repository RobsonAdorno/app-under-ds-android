package com.undercore.core.designsystem

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * UnderDS — Escala de espacamento.
 *
 * Baseada em multiplos de 4dp:
 *   xxs=2  xs=4  s=8  m=12  l=16  xl=24  xxl=32  xxxl=48
 *
 * Acessivel via `UnderTheme.spacing` dentro de um [UnderTheme].
 *
 * @see [docs/03-espacamento.md] para documentacao completa.
 */
data class UnderSpacingValues(
    val xxs:  Dp = 2.dp,    // Micro-gaps
    val xs:   Dp = 4.dp,    // Gaps minimos
    val s:    Dp = 8.dp,    // Padding interno de componentes
    val m:    Dp = 12.dp,   // Padding de rows, lista items
    val l:    Dp = 16.dp,   // Padding de conteudo, cards
    val xl:   Dp = 24.dp,   // Separacao entre secoes
    val xxl:  Dp = 32.dp,   // Separacao entre blocos
    val xxxl: Dp = 48.dp,   // Espacamento maximo
)

val LocalUnderSpacing = staticCompositionLocalOf { UnderSpacingValues() }
