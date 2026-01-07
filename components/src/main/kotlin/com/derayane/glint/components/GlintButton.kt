package com.derayane.glint.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.derayane.glint.coreui.theme.GlintTheme

/**
 * Glint button size variants
 */
enum class GlintButtonSize {
    Small,
    Medium,
    Large
}

/**
 * Primary Glint button using Glint design tokens
 * Minimizes MaterialTheme dependencies and uses Glint tokens directly
 * 
 * @param text Button text
 * @param onClick Click handler
 * @param modifier Modifier for the button
 * @param enabled Whether the button is enabled
 * @param size Button size variant
 * @param leadingIcon Optional leading icon
 * @param trailingIcon Optional trailing icon
 * @param interactionSource MutableInteractionSource for handling interactions
 */
@Composable
fun GlintButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: GlintButtonSize = GlintButtonSize.Medium,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val spacing = GlintTheme.spacing
    val typography = GlintTheme.typography
    val shape = GlintTheme.shape
    val colors = GlintTheme.colorScheme
    
    // Size-specific dimensions using Glint tokens
    val (horizontalPadding, verticalPadding, textStyle, iconSize, buttonShape) = when (size) {
        GlintButtonSize.Small -> {
            Tuple5(
                spacing.md,
                spacing.sm,
                typography.labelMedium,
                spacing.Component.iconSizeSmall,
                shape.Component.buttonSmall
            )
        }
        GlintButtonSize.Medium -> {
            Tuple5(
                spacing.Component.buttonHorizontalPadding,
                spacing.Component.buttonVerticalPadding,
                typography.labelLarge,
                spacing.Component.iconSize,
                shape.Component.buttonDefault
            )
        }
        GlintButtonSize.Large -> {
            Tuple5(
                spacing.lgPlus,
                spacing.md,
                typography.titleMedium,
                spacing.Component.iconSizeLarge,
                shape.Component.buttonLarge
            )
        }
    }
    
    Button(
        onClick = onClick,
        modifier = modifier.defaultMinSize(minHeight = 40.dp),
        enabled = enabled,
        shape = buttonShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.primary,
            contentColor = colors.onPrimary,
            disabledContainerColor = colors.surfaceVariant,
            disabledContentColor = colors.onSurfaceVariant
        ),
        contentPadding = PaddingValues(
            horizontal = horizontalPadding,
            vertical = verticalPadding
        ),
        interactionSource = interactionSource
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(spacing.Component.buttonIconSpacing),
            verticalAlignment = Alignment.CenterVertically
        ) {
            leadingIcon?.let { icon ->
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(iconSize)
                )
            }
            
            Text(
                text = text,
                style = textStyle
            )
            
            trailingIcon?.let { icon ->
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(iconSize)
                )
            }
        }
    }
}

/**
 * Outlined Glint button using Glint design tokens
 */
@Composable
fun GlintOutlinedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: GlintButtonSize = GlintButtonSize.Medium,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val spacing = GlintTheme.spacing
    val typography = GlintTheme.typography
    val shape = GlintTheme.shape
    val colors = GlintTheme.colorScheme
    
    val (horizontalPadding, verticalPadding, textStyle, iconSize, buttonShape) = when (size) {
        GlintButtonSize.Small -> {
            Tuple5(
                spacing.md,
                spacing.sm,
                typography.labelMedium,
                spacing.Component.iconSizeSmall,
                shape.Component.buttonSmall
            )
        }
        GlintButtonSize.Medium -> {
            Tuple5(
                spacing.Component.buttonHorizontalPadding,
                spacing.Component.buttonVerticalPadding,
                typography.labelLarge,
                spacing.Component.iconSize,
                shape.Component.buttonDefault
            )
        }
        GlintButtonSize.Large -> {
            Tuple5(
                spacing.lgPlus,
                spacing.md,
                typography.titleMedium,
                spacing.Component.iconSizeLarge,
                shape.Component.buttonLarge
            )
        }
    }
    
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.defaultMinSize(minHeight = 40.dp),
        enabled = enabled,
        shape = buttonShape,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = colors.primary,
            disabledContentColor = colors.onSurfaceVariant
        ),
        border = BorderStroke(1.dp, if (enabled) colors.outline else colors.outlineVariant),
        contentPadding = PaddingValues(
            horizontal = horizontalPadding,
            vertical = verticalPadding
        ),
        interactionSource = interactionSource
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(spacing.Component.buttonIconSpacing),
            verticalAlignment = Alignment.CenterVertically
        ) {
            leadingIcon?.let { icon ->
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(iconSize)
                )
            }
            
            Text(
                text = text,
                style = textStyle
            )
            
            trailingIcon?.let { icon ->
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(iconSize)
                )
            }
        }
    }
}

/**
 * Text Glint button using Glint design tokens
 */
@Composable
fun GlintTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: GlintButtonSize = GlintButtonSize.Medium,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val spacing = GlintTheme.spacing
    val typography = GlintTheme.typography
    val shape = GlintTheme.shape
    val colors = GlintTheme.colorScheme
    
    val (horizontalPadding, verticalPadding, textStyle, iconSize, buttonShape) = when (size) {
        GlintButtonSize.Small -> {
            Tuple5(
                spacing.sm,
                spacing.xs,
                typography.labelMedium,
                spacing.Component.iconSizeSmall,
                shape.Component.buttonSmall
            )
        }
        GlintButtonSize.Medium -> {
            Tuple5(
                spacing.md,
                spacing.sm,
                typography.labelLarge,
                spacing.Component.iconSize,
                shape.Component.buttonDefault
            )
        }
        GlintButtonSize.Large -> {
            Tuple5(
                spacing.lg,
                spacing.sm,
                typography.titleMedium,
                spacing.Component.iconSizeLarge,
                shape.Component.buttonLarge
            )
        }
    }
    
    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = buttonShape,
        colors = ButtonDefaults.textButtonColors(
            contentColor = colors.primary,
            disabledContentColor = colors.onSurfaceVariant
        ),
        contentPadding = PaddingValues(
            horizontal = horizontalPadding,
            vertical = verticalPadding
        ),
        interactionSource = interactionSource
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(spacing.Component.buttonIconSpacing),
            verticalAlignment = Alignment.CenterVertically
        ) {
            leadingIcon?.let { icon ->
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(iconSize)
                )
            }
            
            Text(
                text = text,
                style = textStyle
            )
            
            trailingIcon?.let { icon ->
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(iconSize)
                )
            }
        }
    }
}

/**
 * Helper data class to hold 5 values
 */
private data class Tuple5<A, B, C, D, E>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E
)