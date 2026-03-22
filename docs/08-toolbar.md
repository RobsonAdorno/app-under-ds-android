# 08 — DSToolbar

## Analise UX

O DSToolbar eh o header padrao de todas as telas do app. Usa `CenterAlignedTopAppBar` do Material3, garantindo titulo centralizado em todas as telas. O texto usa `titleLarge` com `ExtraBold` para destaque visual.

A variante **SURFACE** (branca) eh o padrao — usada em 90% das telas. Quando colocada como `topBar` de um Scaffold, o background do toolbar se estende atras da status bar, garantindo cor uniforme.

---

## Variantes

| Variante | Container | Content | Uso |
|---|---|---|---|
| `PRIMARY` | `primary` (Gold) | `onPrimary` (Black) | Paginas de branding (raro) |
| `SURFACE` | `surface` (White) | `onSurface` (dark) | Padrao — 90% das telas |
| `TRANSPARENT` | transparent | `onBackground` | Sobre imagens/covers |

## Props

| Prop | Tipo | Default | Descricao |
|---|---|---|---|
| `title` | String | — | Texto centralizado |
| `variant` | DSToolbarVariant | SURFACE | Estilo de fundo |
| `showBackButton` | Boolean | false | Exibe seta de voltar |
| `onBackClick` | () -> Unit | {} | Callback do botao voltar |
| `actions` | @Composable RowScope.() -> Unit | {} | Icones trailing |

## Tipografia

- Titulo: `titleLarge` + `FontWeight.ExtraBold` (Inter Bold 22sp, tracking -0.2sp)

## Window Insets

- Usa os insets padrao do sistema (inclui status bar)
- Quando usado como `topBar` de `Scaffold`, a cor se estende atras da status bar
- Quando usado como conteudo regular (tabs), a `CenterAlignedTopAppBar` respeita os insets automaticamente

---

## Uso

```kotlin
// Toolbar com botao voltar (tela navegavel)
Scaffold(
    topBar = {
        DSToolbar(
            title          = "Status do Pedido",
            variant        = DSToolbarVariant.SURFACE,
            showBackButton = true,
            onBackClick    = { navController.popBackStack() },
        )
    },
) { /* ... */ }

// Toolbar sem botao voltar (tab)
DSToolbar(
    title   = "Meus Pedidos",
    variant = DSToolbarVariant.SURFACE,
)

// Toolbar com acoes
DSToolbar(
    title          = "Configuracoes",
    showBackButton = true,
    onBackClick    = onBack,
    actions        = {
        IconButton(onClick = { /* ... */ }) {
            Icon(Icons.Filled.Settings, contentDescription = null)
        }
    },
)
```

## Regra: Padronizacao de Headers

> Todas as telas devem usar `DSToolbar` como header. Nunca criar `CenterAlignedTopAppBar` manual ou `Box` + `Text` customizado. Isso garante titulo centralizado, fonte consistente, e tratamento correto da status bar.
