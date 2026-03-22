package com.undercore.ds.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.undercore.ds.tokens.UnderColors

/**
 * Item de navegacao para [FloatingNavBar].
 *
 * @param label          Texto exibido abaixo do icone.
 * @param selectedIcon   Icone quando ativo (Filled).
 * @param unselectedIcon Icone quando inativo (Outlined).
 */
data class FloatingNavBarItem(
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

/**
 * UnderDS FloatingNavBar — barra de navegacao flutuante pill.
 *
 * Pill branco com sombra 12dp, cantos 32dp.
 * Item ativo: gold + dot indicator. Inativo: cinza #9E9E9E.
 * Animacoes spring suaves para cor e dot.
 *
 * Posicionar como overlay em `Box(Alignment.BottomCenter)`.
 *
 * @see [docs/10-floating-navbar.md]
 */
@Composable
fun FloatingNavBar(
    items: List<FloatingNavBarItem>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier        = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp)
            .navigationBarsPadding(),
        shape           = RoundedCornerShape(32.dp),
        color           = UnderColors.CardWhite,
        shadowElevation = 12.dp,
        tonalElevation  = 0.dp,
    ) {
        Row(
            modifier              = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment     = Alignment.CenterVertically,
        ) {
            items.forEachIndexed { index, item ->
                FloatingNavItemUi(
                    item     = item,
                    selected = selectedIndex == index,
                    onClick  = { onItemSelected(index) },
                )
            }
        }
    }
}

@Composable
private fun FloatingNavItemUi(
    item: FloatingNavBarItem,
    selected: Boolean,
    onClick: () -> Unit,
) {
    val iconColor by animateColorAsState(
        targetValue   = if (selected) UnderColors.Gold else UnderColors.Inactive,
        animationSpec = spring(stiffness = Spring.StiffnessMediumLow),
        label         = "floatingNavIcon",
    )
    val labelColor by animateColorAsState(
        targetValue   = if (selected) UnderColors.Gold else UnderColors.Inactive,
        animationSpec = spring(stiffness = Spring.StiffnessMediumLow),
        label         = "floatingNavLabel",
    )
    val dotSize by animateDpAsState(
        targetValue   = if (selected) 4.dp else 0.dp,
        animationSpec = spring(stiffness = Spring.StiffnessMediumLow),
        label         = "floatingNavDot",
    )

    Surface(
        onClick = onClick,
        shape   = RoundedCornerShape(20.dp),
        color   = Color.Transparent,
    ) {
        Column(
            modifier            = Modifier.padding(horizontal = 20.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp),
        ) {
            Icon(
                imageVector        = if (selected) item.selectedIcon else item.unselectedIcon,
                contentDescription = item.label,
                tint               = iconColor,
                modifier           = Modifier.size(22.dp),
            )
            Text(
                text       = item.label,
                style      = MaterialTheme.typography.labelSmall,
                color      = labelColor,
                fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
            )
            Box(
                modifier = Modifier
                    .size(dotSize)
                    .background(color = UnderColors.Gold, shape = CircleShape),
            )
        }
    }
}
