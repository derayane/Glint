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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.derayane.glint.coreui.theme.GlintTheme
import com.derayane.glint.coreui.tokens.GlintComponents
import com.derayane.glint.coreui.tokens.GlintSpacing

/**
 * GlintTextField - Custom TextField Component
 * 
 * Customization dari OutlinedTextField Material 3:
 * - Border colors menggunakan MaterialTheme.colorScheme (auto light/dark)
 * - Border width menggunakan design tokens (GlintComponents.TextField)
 * - Label styling konsisten dengan design system
 * - Support untuk helper text dan error message
 * - Integrated dengan GlintTheme untuk styling otomatis
 * 
 * Design Decisions:
 * - Semua colors dari MaterialTheme untuk auto dark mode
 * - Border width dari tokens untuk konsistensi
 * - Shape menggunakan MaterialTheme.shapes.small
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
            isError = isError,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            colors = OutlinedTextFieldDefaults.colors(
                // Focused state
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                focusedLabelColor = MaterialTheme.colorScheme.primary,
                focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
                focusedTrailingIconColor = MaterialTheme.colorScheme.primary,
                
                // Unfocused state
                unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
                unfocusedLeadingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                unfocusedTrailingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                
                // Disabled state
                disabledBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                disabledLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                disabledTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                disabledLeadingIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                disabledTrailingIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                
                // Error state
                errorBorderColor = MaterialTheme.colorScheme.error,
                errorLabelColor = MaterialTheme.colorScheme.error,
                errorLeadingIconColor = MaterialTheme.colorScheme.error,
                errorTrailingIconColor = MaterialTheme.colorScheme.error,
                
                // Container & text colors
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                disabledContainerColor = MaterialTheme.colorScheme.surface,
                errorContainerColor = MaterialTheme.colorScheme.surface,
                
                focusedTextColor = MaterialTheme.colorScheme.onSurface,
                unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
                errorTextColor = MaterialTheme.colorScheme.onSurface,
                
                // Cursor color
                cursorColor = MaterialTheme.colorScheme.primary,
                errorCursorColor = MaterialTheme.colorScheme.error,
            ),
            shape = MaterialTheme.shapes.small
        )
        
        // Helper text atau error message
        val supportingText = when {
            isError && errorMessage != null -> errorMessage
            helperText != null -> helperText
            else -> null
        }
        
        if (supportingText != null) {
            Text(
                text = supportingText,
                style = MaterialTheme.typography.bodySmall,
                color = if (isError) MaterialTheme.colorScheme.error 
                       else MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(
                    start = GlintSpacing.lg,
                    top = GlintSpacing.xs
                )
            )
        }
    }
}

/**
 * Preview untuk berbagai state text field
 */
@Preview(name = "Light Mode", showBackground = true)
@Composable
private fun GlintTextFieldPreview() {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("Sample text") }
    var text3 by remember { mutableStateOf("Error text") }
    
    GlintTheme {
        Column(
            modifier = Modifier.padding(GlintSpacing.lg),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(GlintSpacing.md)
        ) {
            Text("Empty with Label", style = MaterialTheme.typography.titleSmall)
            GlintTextField(
                value = text1,
                onValueChange = { text1 = it },
                label = "Email",
                placeholder = "Enter your email",
                helperText = "We'll never share your email"
            )
            
            Text("Filled State", style = MaterialTheme.typography.titleSmall)
            GlintTextField(
                value = text2,
                onValueChange = { text2 = it },
                label = "Username",
                helperText = "Choose a unique username"
            )
            
            Text("Error State", style = MaterialTheme.typography.titleSmall)
            GlintTextField(
                value = text3,
                onValueChange = { text3 = it },
                label = "Password",
                isError = true,
                errorMessage = "Password must be at least 8 characters"
            )
            
            Text("Disabled State", style = MaterialTheme.typography.titleSmall)
            GlintTextField(
                value = "Disabled field",
                onValueChange = {},
                label = "Disabled",
                enabled = false
            )
        }
    }
}