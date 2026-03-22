package com.undercore.core.designsystem.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

/**
 * Variante visual do DSToolbar.
 *
 * | Variante    | Container     | Content        | Uso                    |
 * |-------------|---------------|----------------|------------------------|
 * | PRIMARY     | Gold          | Black          | Branding (raro)        |
 * | SURFACE     | White         | Dark           | Padrao — 90% das telas |
 * | TRANSPARENT | Transparent   | onBackground   | Sobre imagens/covers   |
 */
enum class DSToolbarVariant { PRIMARY, SURFACE, TRANSPARENT }

/**
 * UnderDS Toolbar — header padrao de todas as telas.
 *
 * Usa [CenterAlignedTopAppBar] com titulo centralizado e
 * `titleLarge` + `ExtraBold`.
 *
 * Respeita os window insets do sistema (status bar).
 * Quando usado como `Scaffold.topBar`, a cor se estende
 * atras da status bar.
 *
 * @see [docs/08-toolbar.md]
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DSToolbar(
    title: String,
    modifier: Modifier = Modifier,
    variant: DSToolbarVariant = DSToolbarVariant.SURFACE,
    showBackButton: Boolean = false,
    onBackClick: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
) {
    val colors: TopAppBarColors = when (variant) {
        DSToolbarVariant.PRIMARY -> TopAppBarDefaults.topAppBarColors(
            containerColor             = MaterialTheme.colorScheme.primary,
            titleContentColor          = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor     = MaterialTheme.colorScheme.onPrimary,
        )
        DSToolbarVariant.SURFACE -> TopAppBarDefaults.topAppBarColors(
            containerColor             = MaterialTheme.colorScheme.surface,
            titleContentColor          = MaterialTheme.colorScheme.onSurface,
            navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
            actionIconContentColor     = MaterialTheme.colorScheme.onSurface,
        )
        DSToolbarVariant.TRANSPARENT -> TopAppBarDefaults.topAppBarColors(
            containerColor             = Color.Transparent,
            titleContentColor          = MaterialTheme.colorScheme.onBackground,
            navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
            actionIconContentColor     = MaterialTheme.colorScheme.onBackground,
        )
    }

    CenterAlignedTopAppBar(
        title = {
            Text(
                text  = title,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.ExtraBold,
                ),
            )
        },
        modifier       = modifier,
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector        = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                    )
                }
            }
        },
        actions = actions,
        colors  = colors,
    )
}
