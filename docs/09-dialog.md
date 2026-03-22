# 09 — DSDialog

## Analise UX

O DSDialog eh o unico componente de feedback modal do app. **Nunca** usar Toast, Snackbar ou AlertDialog diretamente — sempre usar DSDialog. Isso garante uma experiencia premium e consistente.

O dialog usa um card branco elevado (12dp shadow) com cantos arredondados (24dp), e cada variante tem um icone com "halo" colorido que comunica visualmente a severidade.

Hierarquia de variantes:
- **ERROR** → algo falhou, mostra X de fechar, halo vermelho
- **WARNING** → atencao necessaria, barra gold no topo, halo gold com cantos arredondados
- **SUCCESS** → acao concluida, halo verde
- **INFO** → informacao neutra, halo gold

---

## Variantes

| Variante | Accent Color | Halo | Halo Shape | Icon | Close X | Top Bar |
|---|---|---|---|---|---|---|
| `INFO` | Gold `#D4A537` | Gold 12% | Circle | ErrorOutline | nao | nao |
| `ERROR` | Error `#E53935` | Error 12% | Circle | ErrorOutline | **sim** | nao |
| `WARNING` | Gold `#D4A537` | Gold 15% | RoundedRect 18dp | Warning | nao | **gold 3dp** |
| `SUCCESS` | Success `#43A047` | Success 12% | Circle | CheckCircle | nao | nao |

## Layout do Dialog

```
+--------------------------------------+
|  [Gold bar 3dp — so WARNING]         |
|                              [X btn] |   ← so ERROR
|          +--------+                  |
|          | ICON   |   72dp           |
|          | halo   |                  |
|          +--------+                  |
|                                      |
|          Titulo                      |   headlineSmall + Bold
|          Mensagem                    |   bodyMedium, #757575
|                                      |
|          [content slot]              |   opcional
|                                      |
|    +----------------------------+    |
|    |     BOTAO PRIMARIO         |    |   52dp, radius 16dp
|    +----------------------------+    |
|                                      |
|          Texto secundario            |   titleSmall, #757575
+--------------------------------------+
```

## Dimensoes

| Elemento | Valor |
|---|---|
| Card radius | 24dp |
| Card elevation | 12dp |
| Card horizontal padding | 32dp (do Dialog) |
| Content padding | 28dp horizontal, 32dp vertical |
| Icon halo size | 72dp |
| Icon size | 36dp |
| Close button padding | 8dp |
| Close icon size | 24dp |
| Close icon tint | `#9E9E9E` |
| Primary button height | 52dp |
| Primary button radius | 16dp |
| Primary button elevation | 4dp |
| Warning top bar height | 3dp |
| Spacer icon → title | 20dp |
| Spacer title → message | 10dp |
| Spacer message → button | 28dp |
| Spacer button → dismiss text | 14dp |

## Props

| Prop | Tipo | Default | Descricao |
|---|---|---|---|
| `visible` | Boolean | — | Controla visibilidade |
| `title` | String | — | Headline |
| `message` | String | — | Corpo da mensagem |
| `onDismiss` | () -> Unit | — | Callback de dismiss |
| `confirmText` | String | "OK" | Label do botao primario |
| `dismissText` | String? | null | Label do link secundario |
| `onConfirm` | () -> Unit | onDismiss | Callback do botao primario |
| `variant` | DSDialogVariant | INFO | Estilo visual |
| `showCloseButton` | Boolean | true se ERROR | Mostra X no topo |
| `content` | @Composable? | null | Slot customizado |

## Tipografia

| Elemento | Style |
|---|---|
| Titulo | `headlineSmall` + Bold, `#1A1A1A` |
| Mensagem | `bodyMedium`, `#757575` |
| Botao primario | `titleMedium` + SemiBold, White |
| Link secundario | `titleSmall` + SemiBold, `#757575` |

---

## Uso

```kotlin
// Estado no ViewModel/Composable
var showErrorDialog by remember { mutableStateOf(false) }
var errorMessage by remember { mutableStateOf("") }

// Na composicao
DSDialog(
    visible     = showErrorDialog,
    title       = "Ops, algo deu errado",
    message     = errorMessage,
    onDismiss   = { showErrorDialog = false },
    confirmText = "Tentar Novamente",
    dismissText = "Voltar ao Inicio",
    onConfirm   = {
        showErrorDialog = false
        viewModel.retry()
    },
    variant     = DSDialogVariant.ERROR,
)

// Warning com content slot customizado
DSDialog(
    visible     = showWarning,
    title       = "Atencao",
    message     = "Seu endereco esta fora da area de cobertura.",
    onDismiss   = { showWarning = false },
    confirmText = "Sim, Continuar",
    dismissText = "Cancelar",
    variant     = DSDialogVariant.WARNING,
    content     = {
        // Mapa ou info card customizado aqui
    },
)
```
