package com.undercore.ds.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.undercore.ds.tokens.UnderColors

/**
 * Variante visual do DSDialog.
 *
 * | Variante | Accent        | Halo Shape    | Icon         | Close X | Top Bar |
 * |----------|---------------|---------------|--------------|---------|---------|
 * | INFO     | Gold          | Circle        | ErrorOutline | nao     | nao     |
 * | ERROR    | Error (red)   | Circle        | ErrorOutline | sim     | nao     |
 * | WARNING  | Gold          | RoundedRect   | Warning      | nao     | gold    |
 * | SUCCESS  | Success (grn) | Circle        | CheckCircle  | nao     | nao     |
 */
enum class DSDialogVariant { INFO, ERROR, WARNING, SUCCESS }

/**
 * UnderDS Dialog — unico componente de feedback modal.
 *
 * Card branco com cantos 24dp, shadow 12dp, icone com halo colorido,
 * botao primario full-width e link secundario opcional.
 *
 * **Regra**: Nunca usar Toast, Snackbar ou AlertDialog. Sempre DSDialog.
 *
 * @see [docs/09-dialog.md]
 * @see [rules/visual-feedback.md]
 */
@Composable
fun DSDialog(
    visible: Boolean,
    title: String,
    message: String,
    onDismiss: () -> Unit,
    confirmText: String = "OK",
    dismissText: String? = null,
    onConfirm: () -> Unit = onDismiss,
    variant: DSDialogVariant = DSDialogVariant.INFO,
    showCloseButton: Boolean = variant == DSDialogVariant.ERROR,
    content: (@Composable () -> Unit)? = null,
) {
    if (!visible) return

    val accentColor = when (variant) {
        DSDialogVariant.INFO    -> UnderColors.Gold
        DSDialogVariant.ERROR   -> UnderColors.Error
        DSDialogVariant.WARNING -> UnderColors.Gold
        DSDialogVariant.SUCCESS -> UnderColors.Success
    }

    val haloColor = when (variant) {
        DSDialogVariant.INFO    -> UnderColors.Gold.copy(alpha = 0.12f)
        DSDialogVariant.ERROR   -> UnderColors.Error.copy(alpha = 0.12f)
        DSDialogVariant.WARNING -> UnderColors.Gold.copy(alpha = 0.15f)
        DSDialogVariant.SUCCESS -> UnderColors.Success.copy(alpha = 0.12f)
    }

    val iconVector: ImageVector = when (variant) {
        DSDialogVariant.INFO    -> Icons.Filled.ErrorOutline
        DSDialogVariant.ERROR   -> Icons.Filled.ErrorOutline
        DSDialogVariant.WARNING -> Icons.Filled.Warning
        DSDialogVariant.SUCCESS -> Icons.Filled.CheckCircle
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties       = DialogProperties(usePlatformDefaultWidth = false),
    ) {
        Card(
            shape     = RoundedCornerShape(24.dp),
            colors    = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
            modifier  = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
        ) {
            // Gold top accent line — WARNING only
            if (variant == DSDialogVariant.WARNING) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(3.dp)
                        .background(UnderColors.Gold),
                )
            }

            Box(modifier = Modifier.fillMaxWidth()) {
                // Close button — top-right (ERROR default)
                if (showCloseButton) {
                    IconButton(
                        onClick  = onDismiss,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(8.dp),
                    ) {
                        Icon(
                            imageVector        = Icons.Filled.Close,
                            contentDescription = "Fechar",
                            tint               = UnderColors.Inactive,
                            modifier           = Modifier.size(24.dp),
                        )
                    }
                }

                Column(
                    modifier            = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 28.dp, vertical = 32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    // ── Icon with halo (72dp) ──────────────────────────────
                    Box(
                        modifier = Modifier
                            .size(72.dp)
                            .clip(
                                if (variant == DSDialogVariant.WARNING)
                                    RoundedCornerShape(18.dp)
                                else CircleShape
                            )
                            .background(haloColor),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(
                            imageVector        = iconVector,
                            contentDescription = null,
                            tint               = accentColor,
                            modifier           = Modifier.size(36.dp),
                        )
                    }

                    Spacer(Modifier.height(20.dp))

                    // ── Title ───────────────────────────────────────────────
                    Text(
                        text      = title,
                        style     = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold,
                        ),
                        color     = UnderColors.DialogTitle,
                        textAlign = TextAlign.Center,
                    )

                    Spacer(Modifier.height(10.dp))

                    // ── Message ─────────────────────────────────────────────
                    Text(
                        text      = message,
                        style     = MaterialTheme.typography.bodyMedium,
                        color     = UnderColors.DialogBody,
                        textAlign = TextAlign.Center,
                    )

                    // ── Content slot ────────────────────────────────────────
                    if (content != null) {
                        Spacer(Modifier.height(20.dp))
                        content()
                    }

                    Spacer(Modifier.height(28.dp))

                    // ── Primary button (52dp, radius 16dp) ─────────────────
                    Button(
                        onClick   = onConfirm,
                        modifier  = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        shape     = RoundedCornerShape(16.dp),
                        colors    = ButtonDefaults.buttonColors(
                            containerColor = accentColor,
                            contentColor   = Color.White,
                        ),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 4.dp,
                        ),
                    ) {
                        Text(
                            text  = confirmText,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.SemiBold,
                            ),
                        )
                    }

                    // ── Secondary text link ─────────────────────────────────
                    if (dismissText != null) {
                        Spacer(Modifier.height(14.dp))
                        Text(
                            text     = dismissText,
                            style    = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.SemiBold,
                            ),
                            color    = UnderColors.DialogBody,
                            modifier = Modifier.clickable(
                                indication        = null,
                                interactionSource = remember { MutableInteractionSource() },
                                onClick           = onDismiss,
                            ),
                        )
                    }
                }
            }
        }
    }
}
