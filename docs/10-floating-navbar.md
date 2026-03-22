# 10 — FloatingNavBar

## Analise UX

O FloatingNavBar eh uma barra de navegacao flutuante em formato pill, posicionada sobre o conteudo na parte inferior da tela. Diferente de um BottomNavigation convencional, ela "flutua" com sombra e cantos arredondados, reforçando a identidade premium do app.

A barra usa animacoes spring suaves para transicoes de cor e aparecimento/desaparecimento de dot indicator. O item ativo eh destacado com **gold**, enquanto inativos usam **cinza medio** (#9E9E9E).

---

## Anatomia

```
+---------------------------------------------------+
|                                                   |
|   [Icon]        [Icon]         [Icon]             |
|   Label         Label          Label              |
|     ·                                             |   ← dot indicator (gold, 4dp)
|                                                   |
+---------------------------------------------------+
     ↑ pill branco, shadow 12dp, radius 32dp
```

## Dimensoes

| Elemento | Valor |
|---|---|
| Pill shape | `RoundedCornerShape(32.dp)` |
| Pill color | `CardWhite (#FFFFFF)` |
| Pill shadow | 12dp |
| Pill margin horizontal | 24dp |
| Pill margin vertical | 12dp |
| Pill padding interno | 8dp |
| Item padding | 20dp horizontal, 8dp vertical |
| Item shape (touch area) | `RoundedCornerShape(20.dp)` |
| Icon size | 22dp |
| Dot size (ativo) | 4dp |
| Dot size (inativo) | 0dp |
| Gap icon → label | 2dp (via `Arrangement.spacedBy`) |

## Cores

| Estado | Icon/Label | Dot |
|---|---|---|
| Selecionado | `Gold (#D4A537)` | `Gold (#D4A537)` |
| Nao selecionado | `#9E9E9E` | 0dp (invisivel) |

## Tipografia

| Elemento | Style | Weight |
|---|---|---|
| Label (ativo) | `labelSmall` (11sp) | SemiBold |
| Label (inativo) | `labelSmall` (11sp) | Normal |

## Animacoes

| Propriedade | Tipo | Spec |
|---|---|---|
| Icon color | `animateColorAsState` | Spring MediumLow |
| Label color | `animateColorAsState` | Spring MediumLow |
| Dot size | `animateDpAsState` | Spring MediumLow |

## Props

### FloatingNavBarItem

| Prop | Tipo | Descricao |
|---|---|---|
| `label` | String | Texto abaixo do icone |
| `selectedIcon` | ImageVector | Icone quando ativo (Filled) |
| `unselectedIcon` | ImageVector | Icone quando inativo (Outlined) |

### FloatingNavBar

| Prop | Tipo | Descricao |
|---|---|---|
| `items` | List<FloatingNavBarItem> | Lista de itens |
| `selectedIndex` | Int | Indice do item ativo |
| `onItemSelected` | (Int) -> Unit | Callback de selecao |

---

## Uso

```kotlin
// Definicao dos itens
val navItems = listOf(
    FloatingNavBarItem("Home",    Icons.Filled.Home,        Icons.Outlined.Home),
    FloatingNavBarItem("Pedidos", Icons.Filled.ShoppingBag, Icons.Outlined.ShoppingBag),
    FloatingNavBarItem("Chat",    Icons.Filled.Chat,        Icons.Outlined.Chat),
)

// Posicionamento (overlay, nao dentro de Scaffold bottomBar)
Box(Modifier.fillMaxSize()) {
    // conteudo da pagina

    FloatingNavBar(
        items          = navItems,
        selectedIndex  = selectedTab,
        onItemSelected = { selectedTab = it },
        modifier       = Modifier.align(Alignment.BottomCenter),
    )
}
```

## Regra: Navigation Bar Padding

> Conteudo scrollavel deve ter `padding(bottom = 100.dp)` (ou usar Spacer) no final para nao ficar atras da nav bar flutuante. A nav bar tem ~80dp de altura total (pill + margens).
