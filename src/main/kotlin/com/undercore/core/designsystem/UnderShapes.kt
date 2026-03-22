package com.undercore.core.designsystem

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

/**
 * UnderDS — Escala de formas (border-radius).
 *
 * Escala: none=0  xs=4  s=8  m=12  l=16  xl=24  full=999
 *
 * Mapeia para Material3 [Shapes]:
 *   extraSmall → 4dp | small → 8dp | medium → 12dp
 *   large → 16dp | extraLarge → 24dp
 *
 * @see [docs/04-formas.md] para documentacao completa.
 */
val UnderShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small      = RoundedCornerShape(8.dp),
    medium     = RoundedCornerShape(12.dp),
    large      = RoundedCornerShape(16.dp),
    extraLarge = RoundedCornerShape(24.dp),
)

/** Pill / totalmente arredondado (radius = 999dp). */
val ShapeFull = RoundedCornerShape(999.dp)

/** Sem arredondamento (radius = 0). */
val ShapeNone = RoundedCornerShape(0.dp)
