package com.derayane.glint.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.derayane.glint.coreui.theme.GlintTheme

/**
 * Glint Button using theme tokens only
 */

enum class GlintButtonSize {
    Small,
    Medium,
    Large
}

enum class GlintButtonVariant {
    Filled,
    Outlined,
    Text
}

@Composable
fun GlintButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    variant: GlintButtonVariant = GlintButtonVariant.Filled,
    size: GlintButtonSize = GlintButtonSize.Medium,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val contentPadding = when (size) {
        GlintButtonSize.Small -> PaddingValues(
            horizontal = GlintTheme.spacing.medium,
            vertical = GlintTheme.spacing.small
        )
        GlintButtonSize.Medium -> PaddingValues(
            horizontal = GlintTheme.spacing.large,
            vertical = GlintTheme.spacing.medium
        )
        GlintButtonSize.Large -> PaddingValues(
            horizontal = GlintTheme.spacing.extraLarge,
            vertical = GlintTheme.spacing.large
        )
    }
    
    val textStyle = when (size) {
        GlintButtonSize.Small -> GlintTheme.typography.bodySmallBold
        GlintButtonSize.Medium -> GlintTheme.typography.bodyMediumBold
        GlintButtonSize.Large -> GlintTheme.typography.titleSmallBold
    }
    
    val minHeight = when (size) {
        GlintButtonSize.Small -> 32.dp
        GlintButtonSize.Medium -> 40.dp
        GlintButtonSize.Large -> 48.dp
    }
    
    when (variant) {
        GlintButtonVariant.Filled -> {
            Button(
                onClick = onClick,
                modifier = modifier.defaultMinSize(minHeight = minHeight),
                enabled = enabled,
                shape = GlintTheme.shape.small,
                colors = ButtonDefaults.buttonColors(
                    containerColor = GlintTheme.colorScheme.primary,
                    contentColor = GlintTheme.colorScheme.onPrimary,
                    disabledContainerColor = GlintTheme.colorScheme.surfaceVariant,
                    disabledContentColor = GlintTheme.colorScheme.onSurfaceVariant
                ),
                contentPadding = contentPadding,
                interactionSource = interactionSource
            ) {
                Text(
                    text = text,
                    style = textStyle
                )
            }
        }
        
        GlintButtonVariant.Outlined -> {
            OutlinedButton(
                onClick = onClick,
                modifier = modifier.defaultMinSize(minHeight = minHeight),
                enabled = enabled,
                shape = GlintTheme.shape.small,
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = GlintTheme.colorScheme.primary,
                    disabledContentColor = GlintTheme.colorScheme.onSurfaceVariant
                ),
                border = BorderStroke(
                    width = 1.dp,
                    color = if (enabled) GlintTheme.colorScheme.outline else GlintTheme.colorScheme.outlineVariant
                ),
                contentPadding = contentPadding,
                interactionSource = interactionSource
            ) {
                Text(
                    text = text,
                    style = textStyle
                )
            }
        }
        
        GlintButtonVariant.Text -> {
            TextButton(
                onClick = onClick,
                modifier = modifier.defaultMinSize(minHeight = minHeight),
                enabled = enabled,
                shape = GlintTheme.shape.small,
                colors = ButtonDefaults.textButtonColors(
                    contentColor = GlintTheme.colorScheme.primary,
                    disabledContentColor = GlintTheme.colorScheme.onSurfaceVariant
                ),
                contentPadding = contentPadding,
                interactionSource = interactionSource
            ) {
                Text(
                    text = text,
                    style = textStyle
                )
            }
        }
    }
}

@Composable
fun GlintPrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: GlintButtonSize = GlintButtonSize.Medium
) {
    GlintButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        variant = GlintButtonVariant.Filled,
        size = size
    )
}

@Composable
fun GlintSecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: GlintButtonSize = GlintButtonSize.Medium
) {
    GlintButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        variant = GlintButtonVariant.Outlined,
        size = size
    )
}

@Composable
fun GlintTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: GlintButtonSize = GlintButtonSize.Medium
) {
    GlintButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        variant = GlintButtonVariant.Text,
        size = size
    )
}