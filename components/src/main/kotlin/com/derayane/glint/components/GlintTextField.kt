package com.derayane.glint.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import com.derayane.glint.theme.GlintTheme

/**
 * GlintTextField - A customizable text field component using Glint design tokens.
 * Maximizes usage of GlintTheme.spacing, GlintTheme.typography, GlintTheme.shape, and GlintTheme.colorScheme.
 */
@Composable
fun GlintTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = GlintTheme.typography.bodyLarge,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    shape: Shape = GlintTheme.shape.small,
    colors: androidx.compose.material3.TextFieldColors = TextFieldDefaults.colors(
        focusedContainerColor = GlintTheme.colorScheme.surface,
        unfocusedContainerColor = GlintTheme.colorScheme.surface,
        disabledContainerColor = GlintTheme.colorScheme.surface.copy(alpha = 0.38f),
        focusedTextColor = GlintTheme.colorScheme.onSurface,
        unfocusedTextColor = GlintTheme.colorScheme.onSurface,
        disabledTextColor = GlintTheme.colorScheme.onSurface.copy(alpha = 0.38f),
        focusedIndicatorColor = GlintTheme.colorScheme.primary,
        unfocusedIndicatorColor = GlintTheme.colorScheme.outline,
        errorIndicatorColor = GlintTheme.colorScheme.error,
        focusedLabelColor = GlintTheme.colorScheme.primary,
        unfocusedLabelColor = GlintTheme.colorScheme.onSurfaceVariant,
        errorLabelColor = GlintTheme.colorScheme.error,
        cursorColor = GlintTheme.colorScheme.primary,
        errorCursorColor = GlintTheme.colorScheme.error
    )
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        supportingText = supportingText,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        minLines = minLines,
        shape = shape,
        colors = colors
    )
}

/**
 * GlintTextField variant with string label.
 */
@Composable
fun GlintTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = GlintTheme.typography.bodyLarge,
    placeholder: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    supportingText: String? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    shape: Shape = GlintTheme.shape.small
) {
    GlintTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        label = { Text(text = label, style = GlintTheme.typography.bodyMedium) },
        placeholder = placeholder?.let { { Text(text = it, style = GlintTheme.typography.bodyMedium) } },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        supportingText = supportingText?.let { { Text(text = it, style = GlintTheme.typography.bodySmall) } },
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        minLines = minLines,
        shape = shape
    )
}
