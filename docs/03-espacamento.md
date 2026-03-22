# 03 — Espacamento

## Analise UX

O UnderDS usa uma escala de espacamento baseada em multiplos de 4dp, com extensoes para valores extremos. Os tokens sao acessiveis via `CompositionLocal` (`LocalUnderSpacing`), permitindo consistencia em todo o app.

O espacamento segue o principio de **densidade crescente**: areas de conteudo principal usam `xl` (24dp) a `xxxl` (48dp), enquanto espacamentos internos de componentes usam `s` (8dp) a `m` (12dp).

---

## Escala de Espacamento

| Token | Valor | Uso tipico |
|---|---|---|
| `xxs` | 2dp | Micro-gaps (entre dot e label no NavBar) |
| `xs` | 4dp | Gaps minimos (entre badge e texto) |
| `s` | 8dp | Padding interno de componentes, gaps entre icone e texto |
| `m` | 12dp | Padding de rows, espacamento entre itens de lista |
| `l` | 16dp | Padding horizontal de conteudo, padding de cards |
| `xl` | 24dp | Separacao entre secoes, padding maior |
| `xxl` | 32dp | Separacao entre blocos grandes, padding de dialog |
| `xxxl` | 48dp | Espacamento maximo, bottom padding para nav bar clearance |

---

## Como acessar

```kotlin
// Dentro de um @Composable, apos envolver com UnderTheme:
val spacing = UnderTheme.spacing

Modifier.padding(
    horizontal = spacing.l,   // 16dp
    vertical   = spacing.xl,  // 24dp
)
```

---

## Paddings mais usados no app

| Contexto | Horizontal | Vertical | Tokens |
|---|---|---|---|
| Conteudo de pagina | 20dp | — | ~`l` + `xs` |
| Cards internos | 16dp | 18dp | `l` / ~`l+xxs` |
| Dialog | 28dp | 32dp | ~`xxl` |
| Toolbar | — | 8dp (top) | `s` |
| Floating NavBar | 24dp | 12dp | `xl` / `m` |
| Botao (LARGE) | 32dp | — | `xxl` |
| Botao (MEDIUM) | 24dp | — | `xl` |
| Botao (SMALL) | 16dp | — | `l` |

> **Nota**: O app usa mix de valores literais (20dp) e tokens. Recomendacao: alinhar 20dp → `xl` (24dp) ou criar token `page` = 20dp.

---

## Implementacao

```kotlin
data class UnderSpacingValues(
    val xxs:  Dp = 2.dp,
    val xs:   Dp = 4.dp,
    val s:    Dp = 8.dp,
    val m:    Dp = 12.dp,
    val l:    Dp = 16.dp,
    val xl:   Dp = 24.dp,
    val xxl:  Dp = 32.dp,
    val xxxl: Dp = 48.dp,
)

val LocalUnderSpacing = staticCompositionLocalOf { UnderSpacingValues() }
```

Acessivel via:
```kotlin
object UnderTheme {
    val spacing: UnderSpacingValues
        @Composable get() = LocalUnderSpacing.current
}
```
