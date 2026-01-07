package com.derayane.glint.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import com.derayane.glint.coreui.theme.GlintTheme

/**
 * Glint TextField using theme tokens only
 */

enum class GlintTextFieldVariant {
    Filled,
    Outlined
}

enum class GlintTextFieldSize {
    Small,
    Medium,
    Large
}

@Composable
fun GlintTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String? = null,
    placeholder: String? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    supportingText: String? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    variant: GlintTextFieldVariant = GlintTextFieldVariant.Outlined,
    size: GlintTextFieldSize = GlintTextFieldSize.Medium,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val textStyle = when (size) {
        GlintTextFieldSize.Small -> GlintTheme.typography.bodySmall
        GlintTextFieldSize.Medium -> GlintTheme.typography.bodyMedium
        GlintTextFieldSize.Large -> GlintTheme.typography.titleSmall
    }
    
    val labelTextStyle = when (size) {
        GlintTextFieldSize.Small -> GlintTheme.typography.bodySmall
        GlintTextFieldSize.Medium -> GlintTheme.typography.bodyMedium
        GlintTextFieldSize.Large -> GlintTheme.typography.bodyMediumBold
    }
    
    Column(modifier = modifier) {
        when (variant) {
            GlintTextFieldVariant.Filled -> {
                TextField(
                    value = value,
                    onValueChange = onValueChange,
                    modifier = Modifier.fillMaxWidth(),
                    enabled = enabled,
                    readOnly = readOnly,
                    textStyle = textStyle,
                    label = label?.let { { Text(it, style = labelTextStyle) } },
                    placeholder = placeholder?.let { { Text(it, style = textStyle) } },
                    leadingIcon = leadingIcon,
                    trailingIcon = trailingIcon,
                    supportingText = supportingText?.let { { Text(it, style = GlintTheme.typography.bodySmall) } },
                    isError = isError,
                    visualTransformation = visualTransformation,
                    keyboardOptions = keyboardOptions,
                    keyboardActions = keyboardActions,
                    singleLine = singleLine,
                    maxLines = maxLines,
                    minLines = minLines,
                    interactionSource = interactionSource,
                    shape = GlintTheme.shape.sm,
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = GlintTheme.colorScheme.onSurface,
                        unfocusedTextColor = GlintTheme.colorScheme.onSurfaceVariant,
                        disabledTextColor = GlintTheme.colorScheme.onSurfaceVariant,
                        errorTextColor = GlintTheme.colorScheme.error,
                        
                        focusedContainerColor = GlintTheme.colorScheme.surfaceVariant,
                        unfocusedContainerColor = GlintTheme.colorScheme.surfaceVariant,
                        disabledContainerColor = GlintTheme.colorScheme.surfaceVariant,
                        errorContainerColor = GlintTheme.colorScheme.errorContainer,
                        
                        focusedIndicatorColor = GlintTheme.colorScheme.primary,
                        unfocusedIndicatorColor = GlintTheme.colorScheme.outline,
                        disabledIndicatorColor = GlintTheme.colorScheme.outlineVariant,
                        errorIndicatorColor = GlintTheme.colorScheme.error,
                        
                        focusedLabelColor = GlintTheme.colorScheme.primary,
                        unfocusedLabelColor = GlintTheme.colorScheme.onSurfaceVariant,
                        disabledLabelColor = GlintTheme.colorScheme.onSurfaceVariant,
                        errorLabelColor = GlintTheme.colorScheme.error,
                        
                        focusedPlaceholderColor = GlintTheme.colorScheme.onSurfaceVariant,
                        unfocusedPlaceholderColor = GlintTheme.colorScheme.onSurfaceVariant,
                        disabledPlaceholderColor = GlintTheme.colorScheme.onSurfaceVariant,
                        errorPlaceholderColor = GlintTheme.colorScheme.onErrorContainer
                    )
                )
            }
            
            GlintTextFieldVariant.Outlined -> {
                OutlinedTextField(
                    value = value,
                    onValueChange = onValueChange,
                    modifier = Modifier.fillMaxWidth(),
                    enabled = enabled,
                    readOnly = readOnly,
                    textStyle = textStyle,
                    label = label?.let { { Text(it, style = labelTextStyle) } },
                    placeholder = placeholder?.let { { Text(it, style = textStyle) } },
                    leadingIcon = leadingIcon,
                    trailingIcon = trailingIcon,
                    supportingText = supportingText?.let { { Text(it, style = GlintTheme.typography.bodySmall) } },
                    isError = isError,
                    visualTransformation = visualTransformation,
                    keyboardOptions = keyboardOptions,
                    keyboardActions = keyboardActions,
                    singleLine = singleLine,
                    maxLines = maxLines,
                    minLines = minLines,
                    interactionSource = interactionSource,
                    shape = GlintTheme.shape.sm,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = GlintTheme.colorScheme.onSurface,
                        unfocusedTextColor = GlintTheme.colorScheme.onSurfaceVariant,
                        disabledTextColor = GlintTheme.colorScheme.onSurfaceVariant,
                        errorTextColor = GlintTheme.colorScheme.error,
                        
                        focusedContainerColor = GlintTheme.colorScheme.surface,
                        unfocusedContainerColor = GlintTheme.colorScheme.surface,
                        disabledContainerColor = GlintTheme.colorScheme.surface,
                        errorContainerColor = GlintTheme.colorScheme.surface,
                        
                        focusedBorderColor = GlintTheme.colorScheme.primary,
                        unfocusedBorderColor = GlintTheme.colorScheme.outline,
                        disabledBorderColor = GlintTheme.colorScheme.outlineVariant,
                        errorBorderColor = GlintTheme.colorScheme.error,
                        
                        focusedLabelColor = GlintTheme.colorScheme.primary,
                        unfocusedLabelColor = GlintTheme.colorScheme.onSurfaceVariant,
                        disabledLabelColor = GlintTheme.colorScheme.onSurfaceVariant,
                        errorLabelColor = GlintTheme.colorScheme.error,
                        
                        focusedPlaceholderColor = GlintTheme.colorScheme.onSurfaceVariant,
                        unfocusedPlaceholderColor = GlintTheme.colorScheme.onSurfaceVariant,
                        disabledPlaceholderColor = GlintTheme.colorScheme.onSurfaceVariant,
                        errorPlaceholderColor = GlintTheme.colorScheme.onErrorContainer
                    )
                )
            }
        }
    }
}

@Composable
fun GlintOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String? = null,
    placeholder: String? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    supportingText: String? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    size: GlintTextFieldSize = GlintTextFieldSize.Medium
) {
    GlintTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
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
        variant = GlintTextFieldVariant.Outlined,
        size = size
    )
}

@Composable
fun GlintFilledTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String? = null,
    placeholder: String? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    supportingText: String? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    size: GlintTextFieldSize = GlintTextFieldSize.Medium
) {
    GlintTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
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
        variant = GlintTextFieldVariant.Filled,
        size = size
    )
}