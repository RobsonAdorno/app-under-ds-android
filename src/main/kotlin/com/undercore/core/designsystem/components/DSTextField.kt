package com.undercore.core.designsystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation

/**
 * Variante visual do DSTextField.
 *
 * | Variante | Componente M3      | Uso                              |
 * |----------|--------------------|----------------------------------|
 * | OUTLINED | OutlinedTextField   | Formularios (login, cadastro)    |
 * | FILLED   | TextField          | Busca, campos inline             |
 */
enum class DSTextFieldVariant { FILLED, OUTLINED }

/**
 * UnderDS TextField — campo de texto padrao.
 *
 * Sempre `fillMaxWidth()` por padrao.
 * Usa cores e shapes do Material3 via UnderTheme.
 *
 * @see [docs/06-campos-texto.md]
 */
@Composable
fun DSTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    variant: DSTextFieldVariant = DSTextFieldVariant.OUTLINED,
    placeholder: String? = null,
    supportingText: String? = null,
    isError: Boolean = false,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    val labelSlot: @Composable () -> Unit          = { Text(label) }
    val placeholderSlot: (@Composable () -> Unit)?  = placeholder?.let { p -> { Text(p) } }
    val supportingSlot: (@Composable () -> Unit)?   = supportingText?.let { s -> { Text(s) } }

    when (variant) {
        DSTextFieldVariant.OUTLINED -> OutlinedTextField(
            value                = value,
            onValueChange        = onValueChange,
            modifier             = modifier.fillMaxWidth(),
            label                = labelSlot,
            placeholder          = placeholderSlot,
            supportingText       = supportingSlot,
            isError              = isError,
            enabled              = enabled,
            singleLine           = singleLine,
            visualTransformation = visualTransformation,
            keyboardOptions      = keyboardOptions,
            keyboardActions      = keyboardActions,
            trailingIcon         = trailingIcon,
            leadingIcon          = leadingIcon,
        )

        DSTextFieldVariant.FILLED -> TextField(
            value                = value,
            onValueChange        = onValueChange,
            modifier             = modifier.fillMaxWidth(),
            label                = labelSlot,
            placeholder          = placeholderSlot,
            supportingText       = supportingSlot,
            isError              = isError,
            enabled              = enabled,
            singleLine           = singleLine,
            visualTransformation = visualTransformation,
            keyboardOptions      = keyboardOptions,
            keyboardActions      = keyboardActions,
            trailingIcon         = trailingIcon,
            leadingIcon          = leadingIcon,
        )
    }
}
