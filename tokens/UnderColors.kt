package com.undercore.ds.tokens

import androidx.compose.ui.graphics.Color

/**
 * UnderDS — Paleta de cores completa.
 *
 * Tema light-first: beige quente (#F5F0E8) + ouro (#D4A537) + cards brancos.
 * Tokens dark retidos para suporte futuro a dark mode.
 *
 * @see [docs/01-cores.md] para documentacao completa.
 */
object UnderColors {

    // ── Brand ─────────────────────────────────────────────────────────────────
    val Black        = Color(0xFF000000)
    val Gold         = Color(0xFFD4A537)   // Warm gold — cor primaria
    val GoldDark     = Color(0xFFB8911F)   // Gold pressed / darker
    val White        = Color(0xFFFFFFFF)

    // ── Light Surface Scale ───────────────────────────────────────────────────
    val BeigeBg      = Color(0xFFF5F0E8)   // Fundo da pagina
    val CardWhite    = Color(0xFFFFFFFF)   // Cards, sheets, modais
    val SurfaceWarm  = Color(0xFFF0EBE0)   // Inputs, areas secundarias
    val CategoryDark = Color(0xFF1A1A1A)   // Circulo escuro de icones de categoria

    // ── Dark Surface Scale ────────────────────────────────────────────────────
    val Background   = Color(0xFF0A0A0A)   // Fundo (dark mode)
    val Surface      = Color(0xFF1A1A1A)   // Cards (dark mode)
    val SurfaceVar   = Color(0xFF2A2A2A)   // Inputs (dark mode)

    // ── Content on Light ──────────────────────────────────────────────────────
    val OnBeige      = Color(0xFF1A1A1A)   // Texto primario sobre beige
    val TextSecLight = Color(0xFF666666)   // Texto secundario
    val TextHint     = Color(0xFF999999)   // Placeholder / hint

    // ── Content on Dark ───────────────────────────────────────────────────────
    val OnBackground = Color(0xFFFFFFFF)
    val OnSurface    = Color(0xFFFFFFFF)
    val OnSurfaceVar = Color(0xFFB3B3B3)

    // ── Borders ───────────────────────────────────────────────────────────────
    val OutlineLight = Color(0xFFE0E0E0)   // Borda sutil (light)
    val Outline      = Color(0xFF404040)   // Borda (dark)
    val OutlineVar   = Color(0xFF2A2A2A)   // Borda variante (dark)

    // ── Semantic ──────────────────────────────────────────────────────────────
    val Error        = Color(0xFFE53935)
    val OnError      = Color(0xFFFFFFFF)
    val Success      = Color(0xFF43A047)
    val OnSuccess    = Color(0xFFFFFFFF)
    val Warning      = Color(0xFFFFB300)
    val OnWarning    = Color(0xFF000000)

    // ── Accent ────────────────────────────────────────────────────────────────
    val AccentOrange = Color(0xFFE8720C)   // Badges, notificacoes

    // ── UI Utility (extraidos de componentes) ─────────────────────────────────
    val Inactive     = Color(0xFF9E9E9E)   // Icones inativos, close button
    val DialogBody   = Color(0xFF757575)   // Texto de mensagem em dialogs
    val DialogTitle  = Color(0xFF1A1A1A)   // Titulo de dialogs
}
