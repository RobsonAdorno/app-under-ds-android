# 01 — Paleta de Cores

## Analise UX

O UnderDS usa uma paleta **warm gold** como identidade de marca. O tema claro (padrao) usa fundo beige quente (`#F5F0E8`) com cards brancos e acentos dourados, criando uma sensacao premium e acolhedora — ideal para um app de delivery/marketplace.

A hierarquia visual eh:
- **Fundo (beige)** → define o tom geral da pagina
- **Cards (branco)** → elevam o conteudo acima do fundo
- **Gold** → chama atencao para CTAs e elementos interativos
- **Semanticas** → vermelho (erro), verde (sucesso), laranja (avisos/badges)

---

## Tokens de Cor

### Brand

| Token | Hex | Uso |
|---|---|---|
| `Black` | `#000000` | Texto sobre gold, contraste maximo |
| `Gold` | `#D4A537` | Cor primaria / brand / CTAs |
| `GoldDark` | `#B8911F` | Gold pressed / darker variant |
| `White` | `#FFFFFF` | Texto sobre superficies escuras |

### Light Surface Scale

| Token | Hex | Uso |
|---|---|---|
| `BeigeBg` | `#F5F0E8` | Fundo da pagina (background) |
| `CardWhite` | `#FFFFFF` | Cards, sheets, modais |
| `SurfaceWarm` | `#F0EBE0` | Inputs, areas secundarias |
| `CategoryDark` | `#1A1A1A` | Circulo escuro para icones de categoria |

### Dark Surface Scale (para dark mode)

| Token | Hex | Uso |
|---|---|---|
| `Background` | `#0A0A0A` | Fundo da pagina |
| `Surface` | `#1A1A1A` | Cards, modais |
| `SurfaceVar` | `#2A2A2A` | Inputs, elementos secundarios |

### Content on Light

| Token | Hex | Uso |
|---|---|---|
| `OnBeige` | `#1A1A1A` | Texto primario sobre beige |
| `TextSecLight` | `#666666` | Texto secundario |
| `TextHint` | `#999999` | Placeholder / hint |

### Content on Dark

| Token | Hex | Uso |
|---|---|---|
| `OnBackground` | `#FFFFFF` | Texto sobre background escuro |
| `OnSurface` | `#FFFFFF` | Texto sobre surface escura |
| `OnSurfaceVar` | `#B3B3B3` | Texto secundario no dark |

### Borders

| Token | Hex | Uso |
|---|---|---|
| `OutlineLight` | `#E0E0E0` | Borda sutil no light theme |
| `Outline` | `#404040` | Borda padrao no dark theme |
| `OutlineVar` | `#2A2A2A` | Borda variante no dark theme |

### Semantic

| Token | Hex | On-Color | Uso |
|---|---|---|---|
| `Error` | `#E53935` | `#FFFFFF` | Erros, cancelamentos |
| `Success` | `#43A047` | `#FFFFFF` | Sucesso, confirmacoes |
| `Warning` | `#FFB300` | `#000000` | Avisos |

### Accent

| Token | Hex | Uso |
|---|---|---|
| `AccentOrange` | `#E8720C` | Badges de notificacao, labels de categoria |

---

## Mapeamento Material3 (Light)

```kotlin
lightColorScheme(
    primary            = Gold           // #D4A537
    onPrimary          = Black          // #000000
    primaryContainer   = #FFF3D0
    onPrimaryContainer = #3A2E00
    background         = BeigeBg        // #F5F0E8
    onBackground       = OnBeige        // #1A1A1A
    surface            = CardWhite      // #FFFFFF
    onSurface          = OnBeige        // #1A1A1A
    surfaceVariant     = SurfaceWarm    // #F0EBE0
    onSurfaceVariant   = TextSecLight   // #666666
    outline            = OutlineLight   // #E0E0E0
    outlineVariant     = #F0EBE0
    error              = Error          // #E53935
    onError            = OnError        // #FFFFFF
    scrim              = #80000000
)
```

## Cores hardcoded encontradas nos componentes

| Hex | Onde | Uso |
|---|---|---|
| `#9E9E9E` | FloatingNavBar, DSDialog | Icone inativo, botao close |
| `#757575` | DSDialog | Texto de mensagem, dismiss link |
| `#1A1A1A` | DSDialog | Titulo do dialog |

> **Recomendacao**: Migrar essas cores hardcoded para tokens nomeados no `UnderColors`.
