package com.undercore.ds.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.undercore.ds.tokens.ShapeFull
import com.undercore.ds.tokens.UnderColors

/**
 * Variante visual do DSButton.
 *
 * | Variante   | Container       | Content         |
 * |------------|-----------------|-----------------|
 * | PRIMARY    | Gold #D4A537    | Black #000000   |
 * | SECONDARY  | secondary (M3)  | onSecondary     |
 * | OUTLINE    | transparent     | M3 default      |
 * | TEXT       | transparent     | M3 default      |
 * | ERROR      | Error #E53935   | White           |
 * | SUCCESS    | Success #43A047 | White           |
 */
enum class DSButtonVariant { PRIMARY, SECONDARY, OUTLINE, TEXT, ERROR, SUCCESS }

/**
 * Preset de altura.
 *
 * | Size   | Height | H-Padding |
 * |--------|--------|-----------|
 * | SMALL  | 40dp   | 16dp      |
 * | MEDIUM | 48dp   | 24dp      |
 * | LARGE  | 56dp   | 32dp      |
 */
enum class DSButtonSize { SMALL, MEDIUM, LARGE }

/**
 * UnderDS Button — CTA principal do app.
 *
 * PRIMARY produz um botao pill dourado, usado em "Adicionar",
 * "Confirmar Pedido", "Precisa de ajuda?".
 *
 * @see [docs/05-botoes.md]
 */
@Composable
fun DSButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: DSButtonVariant = DSButtonVariant.PRIMARY,
    size: DSButtonSize = DSButtonSize.LARGE,
    enabled: Boolean = true,
    shape: Shape = ShapeFull,
) {
    val height = when (size) {
        DSButtonSize.SMALL  -> 40.dp
        DSButtonSize.MEDIUM -> 48.dp
        DSButtonSize.LARGE  -> 56.dp
    }
    val horizontalPadding = when (size) {
        DSButtonSize.SMALL  -> 16.dp
        DSButtonSize.MEDIUM -> 24.dp
        DSButtonSize.LARGE  -> 32.dp
    }
    val contentPadding = PaddingValues(horizontal = horizontalPadding, vertical = 0.dp)
    val label: @Composable () -> Unit = {
        Text(text = text, style = MaterialTheme.typography.labelLarge)
    }

    when (variant) {
        DSButtonVariant.PRIMARY -> Button(
            onClick        = onClick,
            modifier       = modifier.height(height),
            enabled        = enabled,
            shape          = shape,
            contentPadding = contentPadding,
            colors         = ButtonDefaults.buttonColors(
                containerColor         = UnderColors.Gold,
                contentColor           = UnderColors.Black,
                disabledContainerColor = UnderColors.Gold.copy(alpha = 0.38f),
                disabledContentColor   = UnderColors.Black.copy(alpha = 0.38f),
            ),
            content        = { label() },
        )

        DSButtonVariant.SECONDARY -> FilledTonalButton(
            onClick        = onClick,
            modifier       = modifier.height(height),
            enabled        = enabled,
            shape          = shape,
            contentPadding = contentPadding,
            colors         = ButtonDefaults.filledTonalButtonColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor   = MaterialTheme.colorScheme.onSecondary,
            ),
            content        = { label() },
        )

        DSButtonVariant.OUTLINE -> OutlinedButton(
            onClick        = onClick,
            modifier       = modifier.height(height),
            enabled        = enabled,
            shape          = shape,
            contentPadding = contentPadding,
            content        = { label() },
        )

        DSButtonVariant.TEXT -> TextButton(
            onClick        = onClick,
            modifier       = modifier.height(height),
            enabled        = enabled,
            shape          = shape,
            contentPadding = contentPadding,
            content        = { label() },
        )

        DSButtonVariant.ERROR -> Button(
            onClick        = onClick,
            modifier       = modifier.height(height),
            enabled        = enabled,
            shape          = shape,
            contentPadding = contentPadding,
            colors         = ButtonDefaults.buttonColors(
                containerColor = UnderColors.Error,
                contentColor   = UnderColors.OnError,
            ),
            content        = { label() },
        )

        DSButtonVariant.SUCCESS -> Button(
            onClick        = onClick,
            modifier       = modifier.height(height),
            enabled        = enabled,
            shape          = shape,
            contentPadding = contentPadding,
            colors         = ButtonDefaults.buttonColors(
                containerColor = UnderColors.Success,
                contentColor   = UnderColors.OnSuccess,
            ),
            content        = { label() },
        )
    }
}
