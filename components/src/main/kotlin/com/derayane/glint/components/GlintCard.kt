package com.derayane.glint.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.derayane.glint.coreui.theme.GlintTheme

/**
 * Glint Card using theme tokens only
 */

enum class GlintCardVariant {
    Filled,
    Outlined,
    Elevated
}

enum class GlintCardSize {
    Small,
    Medium,
    Large
}

@Composable
fun GlintCard(
    modifier: Modifier = Modifier,
    variant: GlintCardVariant = GlintCardVariant.Filled,
    size: GlintCardSize = GlintCardSize.Medium,
    backgroundColor: Color? = null,
    contentColor: Color? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    val padding = when (size) {
        GlintCardSize.Small -> GlintTheme.spacing.small
        GlintCardSize.Medium -> GlintTheme.spacing.medium
        GlintCardSize.Large -> GlintTheme.spacing.large
    }
    
    val shape = when (size) {
        GlintCardSize.Small -> GlintTheme.shape.small
        GlintCardSize.Medium -> GlintTheme.shape.medium
        GlintCardSize.Large -> GlintTheme.shape.large
    }
    
    val elevation = when (size) {
        GlintCardSize.Small -> 2.dp
        GlintCardSize.Medium -> 4.dp
        GlintCardSize.Large -> 8.dp
    }
    
    when (variant) {
        GlintCardVariant.Filled -> {
            Card(
                modifier = modifier,
                shape = shape,
                colors = CardDefaults.cardColors(
                    containerColor = backgroundColor ?: GlintTheme.colorScheme.surface,
                    contentColor = contentColor ?: GlintTheme.colorScheme.onSurface
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 0.dp
                )
            ) {
                Column(
                    modifier = Modifier.padding(padding)
                ) {
                    content()
                }
            }
        }
        
        GlintCardVariant.Outlined -> {
            OutlinedCard(
                modifier = modifier,
                shape = shape,
                colors = CardDefaults.outlinedCardColors(
                    containerColor = backgroundColor ?: GlintTheme.colorScheme.surface,
                    contentColor = contentColor ?: GlintTheme.colorScheme.onSurface
                ),
                border = BorderStroke(
                    width = 1.dp,
                    color = GlintTheme.colorScheme.outline
                )
            ) {
                Column(
                    modifier = Modifier.padding(padding)
                ) {
                    content()
                }
            }
        }
        
        GlintCardVariant.Elevated -> {
            Card(
                modifier = modifier,
                shape = shape,
                colors = CardDefaults.cardColors(
                    containerColor = backgroundColor ?: GlintTheme.colorScheme.surface,
                    contentColor = contentColor ?: GlintTheme.colorScheme.onSurface
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = elevation
                )
            ) {
                Column(
                    modifier = Modifier.padding(padding)
                ) {
                    content()
                }
            }
        }
    }
}

@Composable
fun GlintFilledCard(
    modifier: Modifier = Modifier,
    size: GlintCardSize = GlintCardSize.Medium,
    content: @Composable ColumnScope.() -> Unit
) {
    GlintCard(
        modifier = modifier,
        variant = GlintCardVariant.Filled,
        size = size,
        content = content
    )
}

@Composable
fun GlintOutlinedCard(
    modifier: Modifier = Modifier,
    size: GlintCardSize = GlintCardSize.Medium,
    content: @Composable ColumnScope.() -> Unit
) {
    GlintCard(
        modifier = modifier,
        variant = GlintCardVariant.Outlined,
        size = size,
        content = content
    )
}

@Composable
fun GlintElevatedCard(
    modifier: Modifier = Modifier,
    size: GlintCardSize = GlintCardSize.Medium,
    content: @Composable ColumnScope.() -> Unit
) {
    GlintCard(
        modifier = modifier,
        variant = GlintCardVariant.Elevated,
        size = size,
        content = content
    )
}