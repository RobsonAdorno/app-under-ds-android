# Regra: Feedback Visual

## Regra

**Sempre usar DSDialog para feedback modal. Nunca usar Toast ou Snackbar.**

O DSDialog eh o unico componente aprovado para exibir mensagens de erro, aviso, sucesso ou informacao. Isso garante consistencia visual e uma experiencia premium.

## Variantes por contexto

| Contexto | Variante | Exemplo |
|---|---|---|
| Erro de rede / backend | `ERROR` | "Sistema fora do ar" |
| Acao destrutiva | `WARNING` | "Deseja cancelar o pedido?" |
| Pedido realizado | `SUCCESS` | "Pedido realizado com sucesso!" |
| Confirmacao de email | `INFO` | "Confirme seu e-mail" |
| Conflito de carrinho | `WARNING` | "Trocar cesta?" |

## Padrao de implementacao

### 1. Estado no Composable

```kotlin
var showErrorDialog by remember { mutableStateOf(false) }
var errorDialogMessage by remember { mutableStateOf("") }
```

### 2. Bridge do ViewModel → Dialog

```kotlin
LaunchedEffect(state.error) {
    state.error?.let { message ->
        errorDialogMessage = message
        showErrorDialog = true
        viewModel.onIntent(Contract.Intent.DismissError)
    }
}
```

### 3. Renderizacao

```kotlin
DSDialog(
    visible     = showErrorDialog,
    title       = "Ops, algo deu errado",
    message     = errorDialogMessage,
    onDismiss   = { showErrorDialog = false },
    confirmText = "Tentar Novamente",
    onConfirm   = {
        showErrorDialog = false
        viewModel.onIntent(Contract.Intent.Refresh)
    },
    variant     = DSDialogVariant.ERROR,
)
```

## Proibido

- `Toast.makeText(...)` — nunca usar
- `Snackbar` / `SnackbarHost` — nunca usar
- `AlertDialog` direto — usar DSDialog
- Mensagens tecnicas — ver [error-messages.md](error-messages.md)
