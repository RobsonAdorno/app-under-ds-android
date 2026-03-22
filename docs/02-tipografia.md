# 02 — Tipografia

## Analise UX

O UnderDS usa duas familias tipograficas com papeis distintos:

1. **Playfair Display** (Serif) → Display styles (displayLarge/Medium/Small) — usados em headlines hero e branding. Peso Bold/SemiBold, com tracking negativo para sofisticacao.

2. **Inter** (Sans-serif) → Todo o resto (headlines, titles, body, labels) — moderno, legivel, otimizado para telas. Usa tracking negativo em headlines (-0.5sp a -0.2sp) para compactacao visual, e tracking positivo em body/labels (0.1sp a 0.5sp) para legibilidade.

> **Nota**: Atualmente ambas usam fallback do sistema (`FontFamily.Serif` e `FontFamily.SansSerif`). Para produção, carregar os .ttf reais.

---

## Escala Tipografica

### Display (Playfair Display / Serif)

| Style | Size | Line Height | Weight | Letter Spacing | Uso |
|---|---|---|---|---|---|
| `displayLarge` | 57sp | 64sp | Bold | -0.25sp | Hero headlines |
| `displayMedium` | 45sp | 52sp | Bold | 0 | Sub-hero |
| `displaySmall` | 36sp | 44sp | SemiBold | 0 | Display menor |

### Headline (Inter / Sans-serif)

| Style | Size | Line Height | Weight | Letter Spacing | Uso |
|---|---|---|---|---|---|
| `headlineLarge` | 32sp | 40sp | ExtraBold | -0.5sp | Status do pedido, titulos grandes |
| `headlineMedium` | 28sp | 36sp | Bold | -0.3sp | Subtitulos |
| `headlineSmall` | 24sp | 32sp | Bold | -0.2sp | "Ola, Nome!", titulos de secao |

### Title (Inter / Sans-serif)

| Style | Size | Line Height | Weight | Letter Spacing | Uso |
|---|---|---|---|---|---|
| `titleLarge` | 22sp | 28sp | Bold | -0.2sp | Toolbar titles (c/ ExtraBold override) |
| `titleMedium` | 16sp | 24sp | Medium | 0.15sp | Totais, precos destacados |
| `titleSmall` | 14sp | 20sp | Medium | 0.1sp | Labels de menu, botao secundario |

### Body (Inter / Sans-serif)

| Style | Size | Line Height | Weight | Letter Spacing | Uso |
|---|---|---|---|---|---|
| `bodyLarge` | 16sp | 24sp | Normal | 0.5sp | Texto corrido principal |
| `bodyMedium` | 14sp | 20sp | Normal | 0.25sp | Texto secundario, descricoes |
| `bodySmall` | 12sp | 16sp | Normal | 0.4sp | Helper text, subtitulos menores |

### Label (Inter / Sans-serif)

| Style | Size | Line Height | Weight | Letter Spacing | Uso |
|---|---|---|---|---|---|
| `labelLarge` | 14sp | 20sp | Medium | 0.1sp | Label de botao |
| `labelMedium` | 12sp | 16sp | Medium | 0.5sp | Tags, badges |
| `labelSmall` | 11sp | 16sp | Medium | 0.5sp | Nav label, version text, timestamps |

---

## Overrides comuns no codigo

| Padrao | Onde | Exemplo |
|---|---|---|
| `titleLarge + ExtraBold` | DSToolbar | Titulo centralizado da toolbar |
| `headlineSmall + ExtraBold` | FeedTab | Saudacao "Ola, Nome!" |
| `headlineSmall + Bold` | ProfileTab, DSDialog | Nome do usuario, titulo do dialog |
| `titleSmall + SemiBold` | ProfileTab, Buttons | Labels de menu, botoes secundarios |
| `labelSmall + letterSpacing(2.sp)` | ProfileTab | "UNDER V1.0.0" |
| `labelSmall + letterSpacing(1.5.sp)` | OrderDetail | "ETAPA ATUAL" |

---

## Como instalar fontes reais

```kotlin
// Em core/design-system/src/main/res/font/:
//   playfair_display_regular.ttf
//   playfair_display_medium.ttf
//   playfair_display_semibold.ttf
//   playfair_display_bold.ttf
//   inter_regular.ttf
//   inter_medium.ttf
//   inter_semibold.ttf
//   inter_bold.ttf
//   inter_extrabold.ttf

val PlayfairDisplayFamily = FontFamily(
    Font(R.font.playfair_display_regular, FontWeight.Normal),
    Font(R.font.playfair_display_medium,  FontWeight.Medium),
    Font(R.font.playfair_display_semibold, FontWeight.SemiBold),
    Font(R.font.playfair_display_bold,    FontWeight.Bold),
)

val InterFamily = FontFamily(
    Font(R.font.inter_regular,   FontWeight.Normal),
    Font(R.font.inter_medium,    FontWeight.Medium),
    Font(R.font.inter_semibold,  FontWeight.SemiBold),
    Font(R.font.inter_bold,      FontWeight.Bold),
    Font(R.font.inter_extrabold, FontWeight.ExtraBold),
)
```
