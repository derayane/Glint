package com.derayane.glint.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.derayane.glint.coreui.theme.GlintTheme
import com.derayane.glint.coreui.tokens.GlintComponents
import com.derayane.glint.coreui.tokens.GlintSpacing

/**
 * GlintCard - Custom Card Component
 * 
 * Customization dari ElevatedCard Material 3:
 * - Elevation levels menggunakan design tokens (GlintComponents.Card)
 * - Padding menggunakan GlintSpacing tokens
 * - Colors menggunakan MaterialTheme.colorScheme (auto light/dark)
 * - Shape menggunakan MaterialTheme.shapes.medium
 * - Flexible content dengan ColumnScope
 * 
 * Design Decisions:
 * - Semua elevation values dari tokens untuk konsistensi
 * - State-based elevation (pressed, dragged) juga menggunakan tokens
 * - Auto dark mode support via MaterialTheme
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
 * Internal function untuk mendapatkan elevation value dari design tokens
 */
private fun getElevationValue(elevation: GlintCardElevation): Dp {
    return when (elevation) {
        GlintCardElevation.LOW -> GlintComponents.Card.elevationLow
        GlintCardElevation.MEDIUM -> GlintComponents.Card.elevationMedium
        GlintCardElevation.HIGH -> GlintComponents.Card.elevationHigh
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
        // Clickable card dengan interactive elevation
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
                pressedElevation = elevationValue + GlintComponents.Card.elevationPressedDelta,
                focusedElevation = elevationValue + GlintComponents.Card.elevationPressedDelta,
                hoveredElevation = elevationValue + GlintComponents.Card.elevationPressedDelta,
                draggedElevation = elevationValue + GlintComponents.Card.elevationDraggedDelta,
                disabledElevation = GlintComponents.Elevation.level0
            ),
            shape = MaterialTheme.shapes.medium
        ) {
            Column(
                modifier = Modifier.padding(GlintSpacing.lg),
                content = content
            )
        }
    } else {
        // Non-clickable card dengan static elevation
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
 * Preview untuk berbagai variasi card
 */
@Preview(name = "Light Mode", showBackground = true)
@Composable
private fun GlintCardPreview() {
    GlintTheme {
        Column(
            modifier = Modifier.padding(GlintSpacing.lg),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(GlintSpacing.md)
        ) {
            Text("Low Elevation Card", style = MaterialTheme.typography.titleSmall)
            GlintCard(elevation = GlintCardElevation.LOW) {
                Text("Card Title", style = MaterialTheme.typography.titleMedium)
                Text("This is a low elevation card with default styling.")
            }
            
            Text("Medium Elevation Card", style = MaterialTheme.typography.titleSmall)
            GlintCard(elevation = GlintCardElevation.MEDIUM) {
                Text("Card Title", style = MaterialTheme.typography.titleMedium)
                Text("This is a medium elevation card.")
            }
            
            Text("High Elevation Card", style = MaterialTheme.typography.titleSmall)
            GlintCard(elevation = GlintCardElevation.HIGH) {
                Text("Card Title", style = MaterialTheme.typography.titleMedium)
                Text("This is a high elevation card.")
            }
            
            Text("Clickable Card", style = MaterialTheme.typography.titleSmall)
            GlintCard(
                onClick = { /* Handle click */ },
                elevation = GlintCardElevation.MEDIUM
            ) {
                Text("Interactive Card", style = MaterialTheme.typography.titleMedium)
                Text("Click me! Elevation changes on interaction.")
            }
        }
    }
}
