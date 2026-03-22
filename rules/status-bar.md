# Regra: Status Bar e Window Insets

## Regra

A status bar deve ter a **mesma cor** do header/toolbar da tela. O app usa `enableEdgeToEdge()`, o que torna a status bar transparente — a cor visivel eh determinada pelo conteudo atras dela.

## Abordagem

### Telas com Scaffold + DSToolbar (topBar)

O Scaffold automaticamente estende o `topBar` atras da status bar. O DSToolbar usa os window insets padrao do `CenterAlignedTopAppBar`, que incluem a status bar.

```kotlin
Scaffold(
    topBar = {
        DSToolbar(
            title          = "Status do Pedido",
            variant        = DSToolbarVariant.SURFACE, // branco atras da status bar
            showBackButton = true,
            onBackClick    = onBack,
        )
    },
) { padding -> /* ... */ }
```

### Tabs dentro de HomeScreen

O Scaffold da HomeScreen **nao consome** o inset superior (`contentWindowInsets = WindowInsets(0)`). Cada tab eh responsavel por lidar com a status bar:

- **Tabs com DSToolbar** (HistoryTab, ProfileTab): o toolbar lida com os insets automaticamente
- **Tabs sem toolbar** (FeedTab, ChatTab, NoConnectionContent): usar `Modifier.statusBarsPadding()`

```kotlin
// Tab com toolbar — nao precisa de nada extra
Column(modifier = modifier.fillMaxSize()) {
    DSToolbar(title = "Meus Pedidos", variant = DSToolbarVariant.SURFACE)
    // ...conteudo
}

// Tab sem toolbar — precisa de statusBarsPadding
Column(modifier = modifier.fillMaxSize().statusBarsPadding()) {
    // ...conteudo customizado
}
```

## Status Bar Icons

O `UnderTheme` configura automaticamente os icones da status bar:
- **Light theme**: icones escuros (`isAppearanceLightStatusBars = true`)
- **Dark theme**: icones claros (`isAppearanceLightStatusBars = false`)

## DSToolbar Window Insets

O DSToolbar **nao** usa `windowInsets` customizado. Ele delega para o `CenterAlignedTopAppBar` padrao do Material3, que:
1. Quando dentro de `Scaffold.topBar` → Scaffold gerencia os insets
2. Quando usado como conteudo regular → respeita os insets do sistema automaticamente

## Proibido

- `WindowInsets(top = 8.dp)` — nunca hardcodar inset da status bar
- Criar `CenterAlignedTopAppBar` manual — usar DSToolbar
- Ignorar a cor da status bar ao criar headers customizados
