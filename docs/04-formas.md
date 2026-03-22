# 04 — Formas (Shapes)

## Analise UX

O UnderDS usa cantos arredondados progressivos, do sutil (4dp) ao totalmente arredondado (pill). A escala mapeia diretamente para os slots do Material3 `Shapes`, com duas formas especiais adicionais.

Cards e dialogs tendem a usar `large` (16dp) ou `extraLarge` (24dp), enquanto botoes usam `ShapeFull` (pill). Inputs usam o default do Material3 que herda de `medium` (12dp).

---

## Escala de Formas

| Token M3 | Token DS | Radius | Uso |
|---|---|---|---|
| `extraSmall` | xs | 4dp | Badges, tags pequenas |
| `small` | s | 8dp | Chips, elementos menores |
| `medium` | m | 12dp | Inputs, botoes secundarios |
| `large` | l | 16dp | Cards, botoes, surfaces |
| `extraLarge` | xl | 24dp | Dialogs, bottom sheets, cards premium |
| — | `ShapeFull` | 999dp | Botoes pill, pills de filtro, NavBar |
| — | `ShapeNone` | 0dp | Sem arredondamento |

---

## Uso por componente

| Componente | Shape | Radius |
|---|---|---|
| DSButton (todos) | `ShapeFull` (default) | 999dp (pill) |
| DSDialog | `RoundedCornerShape(24.dp)` | 24dp |
| DSCard (todas variantes) | M3 default | herda do `Shapes` |
| DSToolbar | — (retangular) | 0dp |
| FloatingNavBar (pill) | `RoundedCornerShape(32.dp)` | 32dp |
| FloatingNavBar (item) | `RoundedCornerShape(20.dp)` | 20dp |
| Dialog icon halo | `CircleShape` / `RoundedCornerShape(18.dp)` | 50% / 18dp |
| Profile avatar | `CircleShape` | 50% |
| Category icon circle | `CircleShape` | 50% |
| Company card thumb | `RoundedCornerShape(12.dp)` | 12dp |

---

## Implementacao

```kotlin
val UnderShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small      = RoundedCornerShape(8.dp),
    medium     = RoundedCornerShape(12.dp),
    large      = RoundedCornerShape(16.dp),
    extraLarge = RoundedCornerShape(24.dp),
)

val ShapeFull = RoundedCornerShape(999.dp)  // Pill
val ShapeNone = RoundedCornerShape(0.dp)    // Sem arredondamento
```
