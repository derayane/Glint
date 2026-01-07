package com.derayane.glint.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.derayane.glint.coreui.theme.GlintTheme
import com.derayane.glint.coreui.tokens.GlintSpacing

/**
 * GlintTextField - Custom TextField Component
 * 
 * Customization dari OutlinedTextField Material 3:
 * - Custom border colors untuk berbagai state (focused, error, disabled)
 * - Custom label styling yang konsisten dengan design system
 * - Support untuk helper text dan error message
 * - Integrated dengan GlintTheme untuk styling otomatis
 * 
 * Alasan pemilihan OutlinedTextField:
 * - Lebih modern dan clean dibanding FilledTextField
 * - Border yang jelas memberikan feedback visual yang baik
 * - Lebih fleksibel untuk berbagai layout
 */

/**
 * GlintTextField - Custom styled OutlinedTextField
 * 
 * @param value Text value yang ditampilkan
 * @param onValueChange Callback ketika text berubah
 * @param modifier Modifier untuk customization
 * @param label Optional label text
 * @param placeholder Optional placeholder text
 * @param helperText Optional helper text di bawah field
 * @param errorMessage Optional error message (akan override helperText jika ada)
 * @param isError Boolean untuk state error
 * @param enabled Boolean untuk state enabled/disabled
 * @param readOnly Boolean untuk read-only state
 * @param singleLine Boolean untuk single line mode
 * @param maxLines Maximum lines untuk multiline mode
 * @param leadingIcon Optional composable untuk leading icon
 * @param trailingIcon Optional composable untuk trailing icon
 * @param visualTransformation VisualTransformation untuk password, etc
 * @param keyboardOptions Keyboard options
 * @param keyboardActions Keyboard actions
 */
@Composable
fun GlintTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String? = null,
    helperText: String? = null,
    errorMessage: String? = null,
    isError: Boolean = false,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            readOnly = readOnly,
            label = if (label != null) {
                { Text(text = label) }
            } else null,
            placeholder = if (placeholder != null) {
                { Text(text = placeholder) }
            } else null,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            isError = isError || errorMessage != null,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            colors = OutlinedTextFieldDefaults.colors(
                // Focused state colors
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                focusedLabelColor = MaterialTheme.colorScheme.primary,
                focusedTextColor = MaterialTheme.colorScheme.onSurface,
                focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
                focusedTrailingIconColor = MaterialTheme.colorScheme.primary,
                
                // Unfocused state colors
                unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
                unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
                unfocusedLeadingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                unfocusedTrailingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                
                // Error state colors
                errorBorderColor = MaterialTheme.colorScheme.error,
                errorLabelColor = MaterialTheme.colorScheme.error,
                errorTextColor = MaterialTheme.colorScheme.onSurface,
                errorLeadingIconColor = MaterialTheme.colorScheme.error,
                errorTrailingIconColor = MaterialTheme.colorScheme.error,
                
                // Disabled state colors
                disabledBorderColor = MaterialTheme.colorScheme.outlineVariant,
                disabledLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
                disabledTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                disabledLeadingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                disabledTrailingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                
                // Container colors
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
            ),
            shape = MaterialTheme.shapes.small,
            textStyle = MaterialTheme.typography.bodyLarge
        )
        
        // Helper text atau error message
        if (errorMessage != null) {
            Text(
                text = errorMessage,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(
                    start = GlintSpacing.lg,
                    top = GlintSpacing.xs
                )
            )
        } else if (helperText != null) {
            Text(
                text = helperText,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(
                    start = GlintSpacing.lg,
                    top = GlintSpacing.xs
                )
            )
        }
    }
}

// ============================================
// PREVIEWS
// ============================================

@Preview(name = "TextField - Empty", showBackground = true)
@Composable
private fun PreviewGlintTextFieldEmpty() {
    GlintTheme {
        var text by remember { mutableStateOf("") }
        GlintTextField(
            value = text,
            onValueChange = { text = it },
            label = "Email",
            placeholder = "Enter your email",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(name = "TextField - Filled", showBackground = true)
@Composable
private fun PreviewGlintTextFieldFilled() {
    GlintTheme {
        var text by remember { mutableStateOf("user@example.com") }
        GlintTextField(
            value = text,
            onValueChange = { text = it },
            label = "Email",
            helperText = "We'll never share your email",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(name = "TextField - Error", showBackground = true)
@Composable
private fun PreviewGlintTextFieldError() {
    GlintTheme {
        var text by remember { mutableStateOf("invalid-email") }
        GlintTextField(
            value = text,
            onValueChange = { text = it },
            label = "Email",
            errorMessage = "Please enter a valid email address",
            isError = true,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(name = "TextField - Disabled", showBackground = true)
@Composable
private fun PreviewGlintTextFieldDisabled() {
    GlintTheme {
        GlintTextField(
            value = "Disabled field",
            onValueChange = {},
            label = "Email",
            enabled = false,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(name = "TextField - Multiline", showBackground = true)
@Composable
private fun PreviewGlintTextFieldMultiline() {
    GlintTheme {
        var text by remember { mutableStateOf("This is a multiline\ntext field example") }
        GlintTextField(
            value = text,
            onValueChange = { text = it },
            label = "Description",
            placeholder = "Enter description",
            helperText = "Maximum 500 characters",
            singleLine = false,
            maxLines = 4,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(name = "TextField States", showBackground = true)
@Composable
private fun PreviewGlintTextFieldStates() {
    GlintTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(16.dp)
        ) {
            var text1 by remember { mutableStateOf("") }
            GlintTextField(
                value = text1,
                onValueChange = { text1 = it },
                label = "Normal State",
                placeholder = "Type something..."
            )
            
            var text2 by remember { mutableStateOf("user@example.com") }
            GlintTextField(
                value = text2,
                onValueChange = { text2 = it },
                label = "With Helper Text",
                helperText = "This is a helper text"
            )
            
            var text3 by remember { mutableStateOf("invalid") }
            GlintTextField(
                value = text3,
                onValueChange = { text3 = it },
                label = "Error State",
                errorMessage = "This field has an error"
            )
        }
    }
}
