package com.derayane.glint.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.derayane.glint.theme.GlintTheme

/**
 * GlintCard - A customizable card component using Glint design tokens.
 * Maximizes usage of GlintTheme.spacing, GlintTheme.shape, and GlintTheme.colorScheme.
 */
@Composable
fun GlintCard(
    modifier: Modifier = Modifier,
    shape: Shape = GlintTheme.shape.medium,
    backgroundColor: Color = GlintTheme.colorScheme.surface,
    contentColor: Color = GlintTheme.colorScheme.onSurface,
    elevation: Dp = GlintTheme.spacing.small,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier,
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = elevation
        )
    ) {
        Column(
            modifier = Modifier.padding(GlintTheme.spacing.medium)
        ) {
            content()
        }
    }
}

/**
 * GlintCard variant with custom padding.
 */
@Composable
fun GlintCard(
    modifier: Modifier = Modifier,
    shape: Shape = GlintTheme.shape.medium,
    backgroundColor: Color = GlintTheme.colorScheme.surface,
    contentColor: Color = GlintTheme.colorScheme.onSurface,
    elevation: Dp = GlintTheme.spacing.small,
    contentPadding: Dp = GlintTheme.spacing.medium,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier,
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = elevation
        )
    ) {
        Column(
            modifier = Modifier.padding(contentPadding)
        ) {
            content()
        }
    }
}
