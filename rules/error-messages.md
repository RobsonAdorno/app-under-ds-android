# Regra: Mensagens de Erro

## Regra

**Nunca exibir mensagens tecnicas para o usuario.**

Toda mensagem de erro visivel na UI deve ser escrita em linguagem simples e amigavel. O usuario nunca deve ver stack traces, nomes de excecao, codigos HTTP, "timeout", "null", "NullPointerException", etc.

## Exemplos

### Correto
- "Nao foi possivel carregar seus pedidos. Tente novamente mais tarde."
- "Sistema fora do ar, tente novamente mais tarde."
- "Sua sessao expirou. Faca login novamente."
- "Nao foi possivel conectar ao servidor."
- "Nao ha pedidos em seu historico."
- "Ainda nao ha parceiros na sua regiao."

### Incorreto
- "Error 500: Internal Server Error"
- "java.net.SocketTimeoutException"
- "Null response from server"
- "retrofit2.HttpException: HTTP 401"
- "Failed to fetch /api/orders"

## Implementacao

No ViewModel, sempre converter excecoes em mensagens amigaveis:

```kotlin
.onFailure { exception ->
    _state.update {
        it.copy(
            error = "Nao foi possivel atualizar seus pedidos. Tente novamente mais tarde."
        )
    }
}
```

Para mensagens reutilizaveis, usar `UiText.StringResource` com string resources:

```kotlin
UiText.StringResource(R.string.error_generic_retry)
```

## Padrao de exibicao

Erros devem ser exibidos via **DSDialog** (variante ERROR ou WARNING), nunca via Toast ou Snackbar.

```kotlin
DSDialog(
    visible     = showErrorDialog,
    title       = "Ops, algo deu errado",
    message     = errorMessage,
    onDismiss   = { showErrorDialog = false },
    confirmText = "Tentar Novamente",
    variant     = DSDialogVariant.ERROR,
)
```
