package com.derayane.glint.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.derayane.glint.coreui.theme.GlintTheme
import com.derayane.glint.coreui.tokens.GlintComponents
import com.derayane.glint.coreui.tokens.GlintPrimaryIrishGreen
import com.derayane.glint.coreui.tokens.GlintPrimaryPassionGreen

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
    val isFocused by interactionSource.collectIsFocusedAsState()
    val isPressed by interactionSource.collectIsPressedAsState()
    
    val contentPadding = when (size) {
        GlintButtonSize.Small -> PaddingValues(
            horizontal = GlintTheme.spacing.md,
            vertical = GlintTheme.spacing.sm
        )
        GlintButtonSize.Medium -> PaddingValues(
            horizontal = GlintTheme.spacing.lg,
            vertical = GlintTheme.spacing.md
        )
        GlintButtonSize.Large -> PaddingValues(
            horizontal = GlintTheme.spacing.xl,
            vertical = GlintTheme.spacing.lg
        )
    }
    
    val textStyle = when (size) {
        GlintButtonSize.Small -> GlintTheme.typography.bodySmallBold
        GlintButtonSize.Medium -> GlintTheme.typography.bodyMediumBold
        GlintButtonSize.Large -> GlintTheme.typography.titleSmallBold
    }
    
    val minHeight = when (size) {
        GlintButtonSize.Small -> GlintComponents.Button.heightSmall
        GlintButtonSize.Medium -> GlintComponents.Button.heightMedium
        GlintButtonSize.Large -> GlintComponents.Button.heightLarge
    }
    
    when (variant) {
        GlintButtonVariant.Filled -> {
            val containerColor = when {
                !enabled -> GlintTheme.colorScheme.surfaceVariant
                isPressed -> GlintPrimaryIrishGreen.base
                isFocused -> GlintPrimaryIrishGreen.base
                else -> GlintTheme.colorScheme.primary
            }
            
            Button(
                onClick = onClick,
                modifier = modifier.defaultMinSize(minHeight = minHeight),
                enabled = enabled,
                shape = GlintTheme.shape.sm,
                colors = ButtonDefaults.buttonColors(
                    containerColor = containerColor,
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
            val containerColor = when {
                !enabled -> GlintTheme.colorScheme.surfaceVariant
                isPressed -> GlintPrimaryIrishGreen.base
                isFocused -> GlintPrimaryIrishGreen.base
                else -> GlintTheme.colorScheme.surface
            }
            
            val borderColor = when {
                !enabled -> GlintTheme.colorScheme.outlineVariant
                isPressed -> GlintPrimaryIrishGreen.base
                isFocused -> GlintPrimaryPassionGreen.base
                else -> GlintTheme.colorScheme.outline
            }
            
            OutlinedButton(
                onClick = onClick,
                modifier = modifier.defaultMinSize(minHeight = minHeight),
                enabled = enabled,
                shape = GlintTheme.shape.sm,
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = containerColor,
                    contentColor = GlintTheme.colorScheme.primary,
                    disabledContentColor = GlintTheme.colorScheme.onSurfaceVariant
                ),
                border = BorderStroke(
                    width = GlintComponents.Button.borderWidth,
                    color = borderColor
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
            val containerColor = when {
                !enabled -> GlintTheme.colorScheme.surfaceVariant
                isPressed -> GlintPrimaryIrishGreen.base
                isFocused -> GlintPrimaryIrishGreen.base
                else -> GlintTheme.colorScheme.surface
            }
            
            TextButton(
                onClick = onClick,
                modifier = modifier.defaultMinSize(minHeight = minHeight),
                enabled = enabled,
                shape = GlintTheme.shape.sm,
                colors = ButtonDefaults.textButtonColors(
                    containerColor = containerColor,
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

@Composable
fun GlintButtonGhost(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: GlintButtonSize = GlintButtonSize.Medium
) {
    GlintTextButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        size = size
    )
}