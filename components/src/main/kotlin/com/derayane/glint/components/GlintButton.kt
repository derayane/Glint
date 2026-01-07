package com.derayane.glint.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.derayane.glint.coreui.theme.GlintTheme
import com.derayane.glint.coreui.tokens.GlintComponents
import com.derayane.glint.coreui.tokens.GlintSpacing

/**
 * GlintButton - Custom Button Component dengan 3 variasi state
 * 
 * Variasi:
 * 1. Primary - Untuk aksi utama (filled button)
 * 2. Secondary - Untuk aksi sekunder (outlined button)
 * 3. Ghost - Untuk aksi tersier (text button)
 * 
 * Design Decisions:
 * - Semua dimensi menggunakan design tokens (GlintComponents.Button)
 * - Colors menggunakan MaterialTheme.colorScheme (auto light/dark mode)
 * - Shape menggunakan MaterialTheme.shapes
 * - Typography responsive berdasarkan size
 * 
 * Alasan pemilihan:
 * - Primary button menonjol untuk call-to-action utama
 * - Secondary button memberikan alternatif tanpa terlalu dominan
 * - Ghost button untuk aksi yang less important
 * - Konsisten dengan Material Design 3 button patterns
 */

/**
 * Button Size enum untuk standardisasi ukuran
 */
enum class GlintButtonSize {
    SMALL,
    MEDIUM,
    LARGE
}

/**
 * Internal function untuk mendapatkan height berdasarkan size
 * Menggunakan GlintComponents.Button tokens
 */
private fun getButtonHeight(size: GlintButtonSize) = when (size) {
    GlintButtonSize.SMALL -> GlintComponents.Button.heightSmall
    GlintButtonSize.MEDIUM -> GlintComponents.Button.heightMedium
    GlintButtonSize.LARGE -> GlintComponents.Button.heightLarge
}

/**
 * Internal function untuk mendapatkan padding berdasarkan size
 * Menggunakan GlintSpacing tokens
 */
private fun getButtonPadding(size: GlintButtonSize): PaddingValues {
    return when (size) {
        GlintButtonSize.SMALL -> PaddingValues(
            horizontal = GlintSpacing.md,
            vertical = GlintSpacing.xs
        )
        GlintButtonSize.MEDIUM -> PaddingValues(
            horizontal = GlintSpacing.lg,
            vertical = GlintSpacing.md
        )
        GlintButtonSize.LARGE -> PaddingValues(
            horizontal = GlintSpacing.xl,
            vertical = GlintSpacing.lg
        )
    }
}

/**
 * GlintButton Primary - Filled button untuk aksi utama
 * 
 * @param text Text yang ditampilkan di button
 * @param onClick Callback ketika button diklik
 * @param modifier Modifier untuk customization
 * @param enabled State enabled/disabled button
 * @param size Ukuran button (SMALL, MEDIUM, LARGE)
 */
@Composable
fun GlintButtonPrimary(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: GlintButtonSize = GlintButtonSize.MEDIUM,
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(getButtonHeight(size)),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
            disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        contentPadding = getButtonPadding(size),
        shape = MaterialTheme.shapes.small
    ) {
        Text(
            text = text,
            style = when (size) {
                GlintButtonSize.SMALL -> MaterialTheme.typography.labelSmall
                GlintButtonSize.MEDIUM -> MaterialTheme.typography.labelLarge
                GlintButtonSize.LARGE -> MaterialTheme.typography.titleMedium
            }
        )
    }
}

/**
 * GlintButton Secondary - Outlined button untuk aksi sekunder
 * 
 * @param text Text yang ditampilkan di button
 * @param onClick Callback ketika button diklik
 * @param modifier Modifier untuk customization
 * @param enabled State enabled/disabled button
 * @param size Ukuran button (SMALL, MEDIUM, LARGE)
 */
@Composable
fun GlintButtonSecondary(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: GlintButtonSize = GlintButtonSize.MEDIUM,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.height(getButtonHeight(size)),
        enabled = enabled,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = MaterialTheme.colorScheme.surface,
            disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        border = BorderStroke(
            width = GlintComponents.Button.borderWidth,
            color = if (enabled) MaterialTheme.colorScheme.outline 
                   else MaterialTheme.colorScheme.onSurfaceVariant
        ),
        contentPadding = getButtonPadding(size),
        shape = MaterialTheme.shapes.small
    ) {
        Text(
            text = text,
            style = when (size) {
                GlintButtonSize.SMALL -> MaterialTheme.typography.labelSmall
                GlintButtonSize.MEDIUM -> MaterialTheme.typography.labelLarge
                GlintButtonSize.LARGE -> MaterialTheme.typography.titleMedium
            }
        )
    }
}

/**
 * GlintButton Ghost - Text button untuk aksi tersier
 * 
 * @param text Text yang ditampilkan di button
 * @param onClick Callback ketika button diklik
 * @param modifier Modifier untuk customization
 * @param enabled State enabled/disabled button
 * @param size Ukuran button (SMALL, MEDIUM, LARGE)
 */
@Composable
fun GlintButtonGhost(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: GlintButtonSize = GlintButtonSize.MEDIUM,
) {
    TextButton(
        onClick = onClick,
        modifier = modifier.height(getButtonHeight(size)),
        enabled = enabled,
        colors = ButtonDefaults.textButtonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = MaterialTheme.colorScheme.surface,
            disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        contentPadding = getButtonPadding(size),
        shape = MaterialTheme.shapes.small
    ) {
        Text(
            text = text,
            style = when (size) {
                GlintButtonSize.SMALL -> MaterialTheme.typography.labelSmall
                GlintButtonSize.MEDIUM -> MaterialTheme.typography.labelLarge
                GlintButtonSize.LARGE -> MaterialTheme.typography.titleMedium
            }
        )
    }
}

/**
 * Preview untuk semua variasi button
 */
@Preview(name = "Light Mode", showBackground = true)
@Composable
private fun GlintButtonPreview() {
    GlintTheme {
        androidx.compose.foundation.layout.Column(
            modifier = Modifier.padding(GlintSpacing.lg),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(GlintSpacing.md)
        ) {
            Text("Small Buttons", style = MaterialTheme.typography.titleSmall)
            GlintButtonPrimary(text = "Primary", onClick = {}, size = GlintButtonSize.SMALL)
            GlintButtonSecondary(text = "Secondary", onClick = {}, size = GlintButtonSize.SMALL)
            GlintButtonGhost(text = "Ghost", onClick = {}, size = GlintButtonSize.SMALL)
            
            Text("Medium Buttons", style = MaterialTheme.typography.titleSmall)
            GlintButtonPrimary(text = "Primary", onClick = {})
            GlintButtonSecondary(text = "Secondary", onClick = {})
            GlintButtonGhost(text = "Ghost", onClick = {})
            
            Text("Large Buttons", style = MaterialTheme.typography.titleSmall)
            GlintButtonPrimary(text = "Primary", onClick = {}, size = GlintButtonSize.LARGE)
            GlintButtonSecondary(text = "Secondary", onClick = {}, size = GlintButtonSize.LARGE)
            GlintButtonGhost(text = "Ghost", onClick = {}, size = GlintButtonSize.LARGE)
            
            Text("Disabled State", style = MaterialTheme.typography.titleSmall)
            GlintButtonPrimary(text = "Disabled", onClick = {}, enabled = false)
        }
    }
}