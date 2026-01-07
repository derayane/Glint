package com.derayane.glint.coreui.tokens

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

/**
 * GlintShape - Design Token untuk Shape System
 * 
 * Mendefinisikan corner radius untuk berbagai komponen:
 * - Konsistensi visual di seluruh aplikasi
 * - Hierarchy yang jelas antara komponen berbeda
 * - Fleksibilitas untuk berbagai use case
 * 
 * Alasan pemilihan:
 * - Material 3 shapes memberikan guidance yang baik
 * - Corner radius yang proporsional membuat UI modern dan friendly
 * - Variety yang cukup untuk berbagai komponen tanpa overwhelming
 */

/**
 * Custom Shapes untuk Glint Design System
 * Mengikuti Material Design 3 shape scale
 */
val GlintShapes = Shapes(
    // Extra Small - 4dp radius
    // Digunakan untuk komponen sangat kecil seperti badge, chips kecil
    extraSmall = RoundedCornerShape(4.dp),

    // Small - 8dp radius
    // Digunakan untuk komponen kecil seperti button, chips
    small = RoundedCornerShape(8.dp),

    // Medium - 12dp radius
    // Standard untuk mayoritas komponen seperti card, textfield
    medium = RoundedCornerShape(12.dp),

    // Large - 16dp radius
    // Digunakan untuk komponen besar seperti bottom sheet, dialog
    large = RoundedCornerShape(16.dp),

    // Extra Large - 28dp radius
    // Digunakan untuk komponen sangat besar atau special UI elements
    extraLarge = RoundedCornerShape(28.dp)
)

/**
 * Additional custom shapes untuk use case khusus
 */
object GlintCustomShapes {
    /**
     * None - No rounded corners
     * Untuk komponen yang butuh sharp corners
     */
    val none = RoundedCornerShape(0.dp)

    /**
     * Full - Fully rounded (circular)
     * Untuk avatar, FAB, atau komponen circular
     */
    val full = RoundedCornerShape(50)

    /**
     * Button shapes - Berbagai variasi untuk button
     */
    val buttonSmall = RoundedCornerShape(8.dp)
    val buttonMedium = RoundedCornerShape(12.dp)
    val buttonLarge = RoundedCornerShape(16.dp)
    val buttonPill = RoundedCornerShape(50) // Fully rounded button

    /**
     * Card shapes - Berbagai variasi untuk card
     */
    val cardSmall = RoundedCornerShape(8.dp)
    val cardMedium = RoundedCornerShape(12.dp)
    val cardLarge = RoundedCornerShape(16.dp)

    /**
     * TextField shapes
     */
    val textFieldOutlined = RoundedCornerShape(8.dp)
    val textFieldFilled = RoundedCornerShape(
        topStart = 8.dp,
        topEnd = 8.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp
    )

    /**
     * Sheet shapes - Untuk bottom sheet dan modal
     */
    val sheetTop = RoundedCornerShape(
        topStart = 16.dp,
        topEnd = 16.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp
    )
    val sheetBottom = RoundedCornerShape(
        topStart = 0.dp,
        topEnd = 0.dp,
        bottomStart = 16.dp,
        bottomEnd = 16.dp
    )

    /**
     * Dialog shapes
     */
    val dialog = RoundedCornerShape(24.dp)

    /**
     * Chip shapes
     */
    val chip = RoundedCornerShape(8.dp)
    val chipPill = RoundedCornerShape(50) // Fully rounded chip

    /**
     * Badge shapes
     */
    val badge = RoundedCornerShape(4.dp)
    val badgePill = RoundedCornerShape(50) // Fully rounded badge
}

/**
 * Semantic shapes untuk grouping by use case
 */
object GlintSemanticShapes {
    // Interactive elements (clickable)
    val interactive = GlintCustomShapes.buttonMedium

    // Content containers (non-interactive)
    val container = GlintCustomShapes.cardMedium

    // Input fields
    val input = GlintCustomShapes.textFieldOutlined

    // Overlay components
    val overlay = GlintCustomShapes.dialog

    // Status indicators
    val indicator = GlintCustomShapes.badgePill
}
