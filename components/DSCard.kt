package com.undercore.ds.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Variante visual do DSCard.
 *
 * | Variante | Container         | Elevacao        | Borda       |
 * |----------|-------------------|-----------------|-------------|
 * | ELEVATED | surface (white)   | 2dp / 6dp press | nenhuma     |
 * | OUTLINED | surface (white)   | 0dp             | OutlineLight|
 * | FILLED   | surfaceVariant    | 0dp             | nenhuma     |
 */
enum class DSCardVariant { ELEVATED, OUTLINED, FILLED }

/**
 * UnderDS Card — container padrao de conteudo.
 *
 * ELEVATED eh o padrao — cards brancos com sombra sutil sobre beige.
 *
 * @see [docs/07-cards.md]
 */
@Composable
fun DSCard(
    modifier: Modifier = Modifier,
    variant: DSCardVariant = DSCardVariant.ELEVATED,
    onClick: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    when (variant) {
        DSCardVariant.ELEVATED ->
            if (onClick != null) {
                ElevatedCard(
                    onClick   = onClick,
                    modifier  = modifier,
                    elevation = CardDefaults.elevatedCardElevation(
                        defaultElevation = 2.dp,
                        pressedElevation = 6.dp,
                    ),
                    colors    = CardDefaults.elevatedCardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    ),
                    content   = content,
                )
            } else {
                ElevatedCard(
                    modifier  = modifier,
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp),
                    colors    = CardDefaults.elevatedCardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    ),
                    content   = content,
                )
            }

        DSCardVariant.OUTLINED ->
            if (onClick != null) {
                OutlinedCard(
                    onClick  = onClick,
                    modifier = modifier,
                    colors   = CardDefaults.outlinedCardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    ),
                    content  = content,
                )
            } else {
                OutlinedCard(
                    modifier = modifier,
                    colors   = CardDefaults.outlinedCardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    ),
                    content  = content,
                )
            }

        DSCardVariant.FILLED ->
            if (onClick != null) {
                Card(
                    onClick  = onClick,
                    modifier = modifier,
                    colors   = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    ),
                    content  = content,
                )
            } else {
                Card(
                    modifier = modifier,
                    colors   = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    ),
                    content  = content,
                )
            }
    }
}
