package com.derayane.glint.coreui.tokens

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * GlintComponents - Component-specific design tokens
 * 
 * Tokens untuk dimensi dan properties yang spesifik untuk setiap komponen.
 * Semua komponen HARUS menggunakan token ini untuk konsistensi.
 * 
 * Keuntungan:
 * - Single source of truth untuk component dimensions
 * - Mudah maintenance dan update global
 * - Konsistensi visual terjamin
 * - Memudahkan A/B testing untuk ukuran optimal
 */
object GlintComponents {
    
    /**
     * Button tokens
     * Digunakan untuk semua variasi button (Primary, Secondary, Ghost)
     */
    object Button {
        // Heights - Tinggi button berdasarkan size
        val heightSmall = 36.dp
        val heightMedium = 48.dp
        val heightLarge = 56.dp
        
        // Border width untuk outlined button
        val borderWidth = 1.dp
        
        // Icon sizes untuk leading/trailing icons
        val iconSizeSmall = 16.dp
        val iconSizeMedium = 20.dp
        val iconSizeLarge = 24.dp
        
        // Minimum touch target (accessibility)
        val minTouchTarget = 48.dp
    }
    
    /**
     * TextField tokens
     * Digunakan untuk text input fields
     */
    object TextField {
        // Heights
        val heightDefault = 56.dp
        val heightDense = 48.dp
        
        // Border widths untuk berbagai state
        val borderWidthDefault = 1.dp
        val borderWidthFocused = 2.dp
        val borderWidthError = 2.dp
        
        // Icon sizes
        val iconSize = 24.dp
        
        // Padding internal
        val paddingHorizontal = 16.dp
        val paddingVertical = 16.dp
    }
    
    /**
     * Card tokens
     * Digunakan untuk card components
     */
    object Card {
        // Elevation levels - tingkat ketinggian card
        val elevationLow = 2.dp
        val elevationMedium = 4.dp
        val elevationHigh = 8.dp
        
        // Pressed/Hovered/Dragged states - perubahan elevation saat interaksi
        val elevationPressedDelta = 2.dp
        val elevationDraggedDelta = 4.dp
        
        // Border width untuk outlined card
        val borderWidth = 1.dp
        
        // Minimum height untuk card
        val minHeight = 80.dp
    }
    
    /**
     * Icon tokens
     * Standard icon sizes untuk consistency
     */
    object Icon {
        val sizeSmall = 16.dp
        val sizeMedium = 24.dp
        val sizeLarge = 32.dp
        val sizeXLarge = 48.dp
    }
    
    /**
     * Elevation system
     * General elevation levels untuk semua surfaces
     */
    object Elevation {
        val level0 = 0.dp   // Flat - no elevation
        val level1 = 1.dp   // Raised - slightly elevated
        val level2 = 2.dp   // Low - cards, buttons
        val level3 = 4.dp   // Medium - dropdowns, menus
        val level4 = 6.dp   // High - dialogs
        val level5 = 8.dp   // Very high - modals, sheets
    }
    
    /**
     * Border radius tokens (complement to GlintShapes)
     * Untuk cases yang butuh manual radius definition
     */
    object BorderRadius {
        val none = 0.dp
        val small = 4.dp
        val medium = 8.dp
        val large = 12.dp
        val xLarge = 16.dp
        val xxLarge = 24.dp
        val full = 9999.dp  // Fully rounded
    }
    
    /**
     * Divider & Border tokens
     */
    object Divider {
        val thickness = 1.dp
        val thicknessBold = 2.dp
    }
}