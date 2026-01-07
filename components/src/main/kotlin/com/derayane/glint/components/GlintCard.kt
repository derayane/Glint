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
import com.derayane.glint.coreui.tokens.GlintComponents

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
        GlintCardSize.Small -> GlintTheme.spacing.sm
        GlintCardSize.Medium -> GlintTheme.spacing.md
        GlintCardSize.Large -> GlintTheme.spacing.lg
    }
    
    val shape = when (size) {
        GlintCardSize.Small -> GlintTheme.shape.sm
        GlintCardSize.Medium -> GlintTheme.shape.md
        GlintCardSize.Large -> GlintTheme.shape.lg
    }
    
    val elevation = when (size) {
        GlintCardSize.Small -> GlintComponents.Card.elevationLow
        GlintCardSize.Medium -> GlintComponents.Card.elevationMedium
        GlintCardSize.Large -> GlintComponents.Card.elevationHigh
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
                    width = GlintComponents.Card.borderWidth,
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