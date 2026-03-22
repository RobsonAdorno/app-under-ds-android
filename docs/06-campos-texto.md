# 06 — DSTextField

## Analise UX

O DSTextField wrapa os campos de texto do Material3, garantindo consistencia visual. A variante **OUTLINED** (default) eh usada em formularios de cadastro e login, enquanto **FILLED** pode ser usada em areas onde o campo precisa se destacar menos (ex: busca dentro de um card).

Todos os campos sao `fillMaxWidth()` por padrao, seguindo o padrao de formularios mobile full-width.

---

## Variantes

| Variante | Componente M3 | Uso |
|---|---|---|
| `OUTLINED` | `OutlinedTextField` | Formularios (login, cadastro, edicao) |
| `FILLED` | `TextField` | Busca, campos inline |

## Props

| Prop | Tipo | Default | Descricao |
|---|---|---|---|
| `value` | String | — | Valor atual |
| `onValueChange` | (String) -> Unit | — | Callback de mudanca |
| `label` | String | — | Label flutuante |
| `variant` | DSTextFieldVariant | OUTLINED | Estilo visual |
| `placeholder` | String? | null | Hint quando vazio e focado |
| `supportingText` | String? | null | Texto auxiliar/erro abaixo |
| `isError` | Boolean | false | Estado de erro |
| `enabled` | Boolean | true | Campo habilitado |
| `singleLine` | Boolean | true | Linha unica |
| `visualTransformation` | VisualTransformation | None | Para senhas |
| `keyboardOptions` | KeyboardOptions | Default | Tipo de teclado |
| `keyboardActions` | KeyboardActions | Default | Acoes IME |
| `trailingIcon` | @Composable? | null | Icone trailing (ex: olho senha) |
| `leadingIcon` | @Composable? | null | Icone leading (ex: busca) |

---

## Uso

```kotlin
// Campo de email
DSTextField(
    value         = email,
    onValueChange = { email = it },
    label         = "E-mail",
    placeholder   = "seu@email.com",
    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
)

// Campo de senha com toggle
DSTextField(
    value         = password,
    onValueChange = { password = it },
    label         = "Senha",
    visualTransformation = if (showPassword)
        VisualTransformation.None
    else
        PasswordVisualTransformation(),
    trailingIcon = {
        IconButton(onClick = { showPassword = !showPassword }) {
            Icon(
                imageVector = if (showPassword) Icons.Filled.Visibility
                              else Icons.Filled.VisibilityOff,
                contentDescription = "Toggle senha",
            )
        }
    },
    isError        = state.passwordError != null,
    supportingText = state.passwordError?.asString(),
)
```
