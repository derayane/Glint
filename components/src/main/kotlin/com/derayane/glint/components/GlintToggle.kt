package com.derayane.glint.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.derayane.glint.coreui.theme.GlintTheme

/**
 * GlintToggle - A switch/toggle component for binary state selection
 *
 * This toggle follows Material Design 3 guidelines with smooth animations
 * and proper color theming for light and dark modes. Perfect for settings
 * like dark mode toggles, feature flags, or on/off states.
 *
 * Usage:
 * ```
 * var isChecked by remember { mutableStateOf(false) }
 * GlintToggle(
 *     checked = isChecked,
 *     onCheckedChange = { isChecked = it }
 * )
 * ```
 *
 * @param checked Whether the toggle is currently in the "on" state
 * @param onCheckedChange Callback invoked when the toggle state should change
 * @param modifier Modifier to be applied to the toggle
 * @param enabled Whether the toggle can be interacted with
 * @param size Size variant of the toggle (Small, Medium, Large)
 *
 * @see GlintToggleSize for available sizes
 */
@Composable
fun GlintToggle(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: GlintToggleSize = GlintToggleSize.Medium
) {
    val interactionSource = remember { MutableInteractionSource() }
    
    // Size configurations
    val (trackWidth, trackHeight, thumbSize) = when (size) {
        GlintToggleSize.Small -> Triple(40.dp, 20.dp, 16.dp)
        GlintToggleSize.Medium -> Triple(52.dp, 28.dp, 24.dp)
        GlintToggleSize.Large -> Triple(64.dp, 36.dp, 32.dp)
    }
    
    val thumbPadding = (trackHeight - thumbSize) / 2
    val thumbOffset = trackWidth - thumbSize - (thumbPadding * 2)
    
    // Animated colors
    val trackColor by animateColorAsState(
        targetValue = when {
            !enabled -> GlintTheme.colorScheme.surfaceVariant
            checked -> GlintTheme.colorScheme.primary
            else -> GlintTheme.colorScheme.outline
        },
        animationSpec = tween(durationMillis = 150),
        label = "trackColor"
    )
    
    val thumbColor by animateColorAsState(
        targetValue = when {
            !enabled -> GlintTheme.colorScheme.onSurfaceVariant
            checked -> GlintTheme.colorScheme.onPrimary
            else -> GlintTheme.colorScheme.surface
        },
        animationSpec = tween(durationMillis = 150),
        label = "thumbColor"
    )
    
    // Animated thumb position
    val thumbPosition by animateDpAsState(
        targetValue = if (checked) thumbOffset else 0.dp,
        animationSpec = tween(durationMillis = 150),
        label = "thumbPosition"
    )
    
    // Track (background)
    Box(
        modifier = modifier
            .size(width = trackWidth, height = trackHeight)
            .clip(GlintTheme.shape.full)
            .background(trackColor)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = enabled,
                role = Role.Switch,
                onClick = { onCheckedChange(!checked) }
            )
    ) {
        // Thumb (moving circle)
        Box(
            modifier = Modifier
                .offset(x = thumbPosition + thumbPadding, y = thumbPadding)
                .size(thumbSize)
                .clip(CircleShape)
                .background(thumbColor)
        )
    }
}

/**
 * Size variants for GlintToggle
 */
enum class GlintToggleSize {
    /** Small size (40x20dp) - Compact for dense UIs */
    Small,
    
    /** Medium size (52x28dp) - Default size for most use cases */
    Medium,
    
    /** Large size (64x36dp) - Prominent for important settings */
    Large
}

// ============================================
// PREVIEWS
// ============================================

@Preview(name = "Toggle - Light", showBackground = true)
@Composable
private fun PreviewGlintToggle() {
    GlintTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            var checked1 by remember { mutableStateOf(false) }
            GlintToggle(
                checked = checked1,
                onCheckedChange = { checked1 = it }
            )
            
            var checked2 by remember { mutableStateOf(true) }
            GlintToggle(
                checked = checked2,
                onCheckedChange = { checked2 = it }
            )
        }
    }
}

@Preview(name = "Toggle - Dark", showBackground = true)
@Composable
private fun PreviewGlintToggleDark() {
    GlintTheme(darkTheme = true) {
        Surface(color = GlintTheme.colorScheme.background) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                var checked1 by remember { mutableStateOf(false) }
                GlintToggle(
                    checked = checked1,
                    onCheckedChange = { checked1 = it }
                )
                
                var checked2 by remember { mutableStateOf(true) }
                GlintToggle(
                    checked = checked2,
                    onCheckedChange = { checked2 = it }
                )
            }
        }
    }
}

@Preview(name = "Toggle - All Sizes", showBackground = true)
@Composable
private fun PreviewGlintToggleSizes() {
    GlintTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Small
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                GlintToggle(
                    checked = false,
                    onCheckedChange = {},
                    size = GlintToggleSize.Small
                )
                GlintToggle(
                    checked = true,
                    onCheckedChange = {},
                    size = GlintToggleSize.Small
                )
            }
            
            // Medium
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                GlintToggle(
                    checked = false,
                    onCheckedChange = {},
                    size = GlintToggleSize.Medium
                )
                GlintToggle(
                    checked = true,
                    onCheckedChange = {},
                    size = GlintToggleSize.Medium
                )
            }
            
            // Large
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                GlintToggle(
                    checked = false,
                    onCheckedChange = {},
                    size = GlintToggleSize.Large
                )
                GlintToggle(
                    checked = true,
                    onCheckedChange = {},
                    size = GlintToggleSize.Large
                )
            }
        }
    }
}

@Preview(name = "Toggle - States", showBackground = true)
@Composable
private fun PreviewGlintToggleStates() {
    GlintTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Enabled Off
            GlintToggle(
                checked = false,
                onCheckedChange = {},
                enabled = true
            )
            
            // Enabled On
            GlintToggle(
                checked = true,
                onCheckedChange = {},
                enabled = true
            )
            
            // Disabled Off
            GlintToggle(
                checked = false,
                onCheckedChange = {},
                enabled = false
            )
            
            // Disabled On
            GlintToggle(
                checked = true,
                onCheckedChange = {},
                enabled = false
            )
        }
    }
}
