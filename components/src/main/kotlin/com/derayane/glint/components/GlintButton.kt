package com.derayane.glint.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.derayane.glint.coreui.theme.GlintTheme
import com.derayane.glint.coreui.tokens.GlintSpacing

/**
 * GlintButton - Custom Button Component dengan 3 variasi state
 * 
 * Variasi:
 * 1. Primary - Untuk aksi utama (filled button)
 * 2. Secondary - Untuk aksi sekunder (outlined button)
 * 3. Ghost - Untuk aksi tersier (text button)
 * 
 * Alasan pemilihan:
 * - Primary button menonjol untuk call-to-action utama
 * - Secondary button memberikan alternatif tanpa terlalu dominan
 * - Ghost button untuk aksi yang less important atau destructive
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
 */
private fun getButtonHeight(size: GlintButtonSize): Int {
    return when (size) {
        GlintButtonSize.SMALL -> 36
        GlintButtonSize.MEDIUM -> 48
        GlintButtonSize.LARGE -> 56
    }
}

/**
 * Internal function untuk mendapatkan padding berdasarkan size
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
        modifier = modifier.height(getButtonHeight(size).dp),
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
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Center
        )
    }
}

/**
 * GlintButton Primary dengan custom content (untuk icon + text)
 */
@Composable
fun GlintButtonPrimary(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: GlintButtonSize = GlintButtonSize.MEDIUM,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(getButtonHeight(size).dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
            disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        contentPadding = getButtonPadding(size),
        shape = MaterialTheme.shapes.small,
        content = content
    )
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
        modifier = modifier.height(getButtonHeight(size).dp),
        enabled = enabled,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        border = BorderStroke(
            width = 1.dp,
            color = if (enabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline
        ),
        contentPadding = getButtonPadding(size),
        shape = MaterialTheme.shapes.small
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Center
        )
    }
}

/**
 * GlintButton Secondary dengan custom content (untuk icon + text)
 */
@Composable
fun GlintButtonSecondary(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: GlintButtonSize = GlintButtonSize.MEDIUM,
    content: @Composable RowScope.() -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.height(getButtonHeight(size).dp),
        enabled = enabled,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        border = BorderStroke(
            width = 1.dp,
            color = if (enabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline
        ),
        contentPadding = getButtonPadding(size),
        shape = MaterialTheme.shapes.small,
        content = content
    )
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
        modifier = modifier.height(getButtonHeight(size).dp),
        enabled = enabled,
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        contentPadding = getButtonPadding(size),
        shape = MaterialTheme.shapes.small
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Center
        )
    }
}

/**
 * GlintButton Ghost dengan custom content (untuk icon + text)
 */
@Composable
fun GlintButtonGhost(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: GlintButtonSize = GlintButtonSize.MEDIUM,
    content: @Composable RowScope.() -> Unit
) {
    TextButton(
        onClick = onClick,
        modifier = modifier.height(getButtonHeight(size).dp),
        enabled = enabled,
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        contentPadding = getButtonPadding(size),
        shape = MaterialTheme.shapes.small,
        content = content
    )
}

// ============================================
// PREVIEWS
// ============================================

@Preview(name = "Primary Button - Light", showBackground = true)
@Composable
private fun PreviewGlintButtonPrimary() {
    GlintTheme {
        GlintButtonPrimary(
            text = "Primary Button",
            onClick = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(name = "Secondary Button - Light", showBackground = true)
@Composable
private fun PreviewGlintButtonSecondary() {
    GlintTheme {
        GlintButtonSecondary(
            text = "Secondary Button",
            onClick = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(name = "Ghost Button - Light", showBackground = true)
@Composable
private fun PreviewGlintButtonGhost() {
    GlintTheme {
        GlintButtonGhost(
            text = "Ghost Button",
            onClick = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(name = "Button Sizes", showBackground = true)
@Composable
private fun PreviewGlintButtonSizes() {
    GlintTheme {
        androidx.compose.foundation.layout.Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp)
        ) {
            GlintButtonPrimary(
                text = "Small",
                onClick = {},
                size = GlintButtonSize.SMALL
            )
            GlintButtonPrimary(
                text = "Medium",
                onClick = {},
                size = GlintButtonSize.MEDIUM
            )
            GlintButtonPrimary(
                text = "Large",
                onClick = {},
                size = GlintButtonSize.LARGE
            )
        }
    }
}

@Preview(name = "Button States", showBackground = true)
@Composable
private fun PreviewGlintButtonStates() {
    GlintTheme {
        androidx.compose.foundation.layout.Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp)
        ) {
            GlintButtonPrimary(
                text = "Enabled",
                onClick = {},
                enabled = true
            )
            GlintButtonPrimary(
                text = "Disabled",
                onClick = {},
                enabled = false
            )
        }
    }
}
