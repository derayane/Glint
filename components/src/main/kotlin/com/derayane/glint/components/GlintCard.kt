package com.derayane.glint.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.derayane.glint.coreui.theme.GlintTheme
import com.derayane.glint.coreui.tokens.GlintSpacing

/**
 * GlintCard - Custom Card Component
 * 
 * Customization dari ElevatedCard Material 3:
 * - Custom elevation levels untuk hierarchy
 * - Custom padding yang konsisten dengan design system
 * - Pre-configured colors yang mengikuti theme
 * - Flexible content dengan ColumnScope
 * 
 * Alasan pemilihan ElevatedCard:
 * - Elevation memberikan depth dan hierarchy yang jelas
 * - Lebih modern dibanding OutlinedCard untuk content containers
 * - Shadow memberikan visual separation yang natural
 * - Sesuai dengan Material Design 3 guidelines
 */

/**
 * Elevation levels untuk GlintCard
 */
enum class GlintCardElevation {
    LOW,
    MEDIUM,
    HIGH
}

/**
 * Internal function untuk mendapatkan elevation value
 */
private fun getElevationValue(elevation: GlintCardElevation): Dp {
    return when (elevation) {
        GlintCardElevation.LOW -> 2.dp
        GlintCardElevation.MEDIUM -> 4.dp
        GlintCardElevation.HIGH -> 8.dp
    }
}

/**
 * GlintCard - Custom styled ElevatedCard
 * 
 * @param modifier Modifier untuk customization
 * @param elevation Level elevasi card (LOW, MEDIUM, HIGH)
 * @param onClick Optional click handler - akan membuat card clickable
 * @param enabled State enabled/disabled untuk clickable card
 * @param content Composable content di dalam card
 */
@Composable
fun GlintCard(
    modifier: Modifier = Modifier,
    elevation: GlintCardElevation = GlintCardElevation.LOW,
    onClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    content: @Composable ColumnScope.() -> Unit
) {
    val elevationValue = getElevationValue(elevation)
    
    if (onClick != null) {
        // Clickable card
        ElevatedCard(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface,
                disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = elevationValue,
                pressedElevation = elevationValue + 2.dp,
                focusedElevation = elevationValue + 2.dp,
                hoveredElevation = elevationValue + 2.dp,
                draggedElevation = elevationValue + 4.dp,
                disabledElevation = 0.dp
            ),
            shape = MaterialTheme.shapes.medium
        ) {
            Column(
                modifier = Modifier.padding(GlintSpacing.lg),
                content = content
            )
        }
    } else {
        // Non-clickable card
        ElevatedCard(
            modifier = modifier,
            colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = elevationValue
            ),
            shape = MaterialTheme.shapes.medium
        ) {
            Column(
                modifier = Modifier.padding(GlintSpacing.lg),
                content = content
            )
        }
    }
}

/**
 * GlintCard dengan custom padding
 * Untuk use case yang butuh control lebih terhadap padding
 */
@Composable
fun GlintCardWithCustomPadding(
    modifier: Modifier = Modifier,
    elevation: GlintCardElevation = GlintCardElevation.LOW,
    contentPadding: Dp = GlintSpacing.lg,
    onClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    content: @Composable ColumnScope.() -> Unit
) {
    val elevationValue = getElevationValue(elevation)
    
    if (onClick != null) {
        ElevatedCard(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface,
                disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = elevationValue,
                pressedElevation = elevationValue + 2.dp,
                focusedElevation = elevationValue + 2.dp,
                hoveredElevation = elevationValue + 2.dp,
                draggedElevation = elevationValue + 4.dp,
                disabledElevation = 0.dp
            ),
            shape = MaterialTheme.shapes.medium
        ) {
            Column(
                modifier = Modifier.padding(contentPadding),
                content = content
            )
        }
    } else {
        ElevatedCard(
            modifier = modifier,
            colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = elevationValue
            ),
            shape = MaterialTheme.shapes.medium
        ) {
            Column(
                modifier = Modifier.padding(contentPadding),
                content = content
            )
        }
    }
}

// ============================================
// PREVIEWS
// ============================================

@Preview(name = "Card - Basic", showBackground = true)
@Composable
private fun PreviewGlintCardBasic() {
    GlintTheme {
        GlintCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Card Title",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "This is a basic card with some content inside.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Preview(name = "Card - Clickable", showBackground = true)
@Composable
private fun PreviewGlintCardClickable() {
    GlintTheme {
        GlintCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            onClick = { /* Handle click */ }
        ) {
            Text(
                text = "Clickable Card",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "Click me to trigger an action!",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Preview(name = "Card - Elevations", showBackground = true)
@Composable
private fun PreviewGlintCardElevations() {
    GlintTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            GlintCard(
                modifier = Modifier.fillMaxWidth(),
                elevation = GlintCardElevation.LOW
            ) {
                Text(text = "Low Elevation", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "2dp elevation",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            
            GlintCard(
                modifier = Modifier.fillMaxWidth(),
                elevation = GlintCardElevation.MEDIUM
            ) {
                Text(text = "Medium Elevation", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "4dp elevation",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            
            GlintCard(
                modifier = Modifier.fillMaxWidth(),
                elevation = GlintCardElevation.HIGH
            ) {
                Text(text = "High Elevation", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "8dp elevation",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

@Preview(name = "Card - Complex Content", showBackground = true)
@Composable
private fun PreviewGlintCardComplexContent() {
    GlintTheme {
        GlintCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = GlintCardElevation.MEDIUM
        ) {
            Text(
                text = "Product Card",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "Glint Design System",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "A comprehensive UI component library for Android based on Material Design 3.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 4.dp)
            )
            GlintButtonPrimary(
                text = "Learn More",
                onClick = { /* Handle click */ },
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Preview(name = "Card - Custom Padding", showBackground = true)
@Composable
private fun PreviewGlintCardCustomPadding() {
    GlintTheme {
        GlintCardWithCustomPadding(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentPadding = GlintSpacing.xl
        ) {
            Text(
                text = "Custom Padding Card",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "This card has extra large padding (24dp).",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}
