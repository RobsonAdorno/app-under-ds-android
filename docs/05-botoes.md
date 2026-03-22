# 05 — DSButton

## Analise UX

O DSButton eh o principal CTA do app. A variante **PRIMARY** (gold pill) eh usada em todas as acoes principais: "Adicionar ao carrinho", "Confirmar Pedido", "Precisa de ajuda?". O formato pill (full radius) cria destaque visual contra os cards retangulares.

A hierarquia de variantes:
- **PRIMARY** → acao principal (gold, alto contraste)
- **SECONDARY** → acao secundaria (tonal, menos destaque)
- **OUTLINE** → acao terciaria (borda, sem preenchimento)
- **TEXT** → acao inline (sem borda, sem preenchimento)
- **ERROR** → acao destrutiva (vermelho)
- **SUCCESS** → acao de confirmacao (verde)

---

## Variantes

| Variante | Container | Content | Estado Disabled |
|---|---|---|---|
| `PRIMARY` | `Gold (#D4A537)` | `Black (#000000)` | 38% opacity |
| `SECONDARY` | `secondary` (M3) | `onSecondary` (M3) | M3 default |
| `OUTLINE` | transparent + border | M3 default | M3 default |
| `TEXT` | transparent | M3 default | M3 default |
| `ERROR` | `Error (#E53935)` | `OnError (#FFFFFF)` | — |
| `SUCCESS` | `Success (#43A047)` | `OnSuccess (#FFFFFF)` | — |

## Tamanhos

| Size | Height | Horizontal Padding |
|---|---|---|
| `SMALL` | 40dp | 16dp |
| `MEDIUM` | 48dp | 24dp |
| `LARGE` | 56dp | 32dp |

## Props

| Prop | Tipo | Default | Descricao |
|---|---|---|---|
| `text` | String | — | Label do botao |
| `onClick` | () -> Unit | — | Callback de clique |
| `variant` | DSButtonVariant | PRIMARY | Estilo visual |
| `size` | DSButtonSize | LARGE | Preset de altura |
| `enabled` | Boolean | true | Interacao habilitada |
| `shape` | Shape | ShapeFull | Forma (pill default) |

## Tipografia

- Label usa `MaterialTheme.typography.labelLarge` (Inter Medium 14sp)

---

## Uso

```kotlin
// CTA principal
DSButton(
    text    = "Confirmar Pedido  ·  R$ 32,00",
    onClick = { /* ... */ },
)

// Botao de erro
DSButton(
    text    = "Cancelar Pedido",
    onClick = { /* ... */ },
    variant = DSButtonVariant.ERROR,
    size    = DSButtonSize.MEDIUM,
)

// Botao outline menor
DSButton(
    text    = "Ver Detalhes",
    onClick = { /* ... */ },
    variant = DSButtonVariant.OUTLINE,
    size    = DSButtonSize.SMALL,
)
```
