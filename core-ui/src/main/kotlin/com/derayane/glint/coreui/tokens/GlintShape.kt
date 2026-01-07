package com.derayane.glint.coreui.tokens

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

/**
 * Glint Shape Design Tokens
 * Based on Figma border radius specifications
 * Provides consistent corner radius values across all components
 */
@Immutable
data class GlintShape(
    // No rounding
    val none: Shape = RoundedCornerShape(0.dp),
    
    // Extra small radius - subtle rounding
    val xxs: Shape = RoundedCornerShape(2.dp),
    val xs: Shape = RoundedCornerShape(4.dp),
    
    // Small radius - cards, chips
    val sm: Shape = RoundedCornerShape(8.dp),
    val smPlus: Shape = RoundedCornerShape(10.dp),
    
    // Medium radius - buttons, inputs
    val md: Shape = RoundedCornerShape(12.dp),
    val mdPlus: Shape = RoundedCornerShape(14.dp),
    
    // Large radius - dialogs, bottom sheets
    val lg: Shape = RoundedCornerShape(16.dp),
    val lgPlus: Shape = RoundedCornerShape(20.dp),
    
    // Extra large radius - modals
    val xl: Shape = RoundedCornerShape(24.dp),
    val xlPlus: Shape = RoundedCornerShape(28.dp),
    
    // 2X large radius - special components
    val xxl: Shape = RoundedCornerShape(32.dp),
    val xxlPlus: Shape = RoundedCornerShape(36.dp),
    
    // Full rounding - circular/pill shapes
    val full: Shape = RoundedCornerShape(50)
) {
    companion object {
        /**
         * Component-specific shape presets
         */
        object Component {
            // Button shapes
            val buttonDefault: Shape = RoundedCornerShape(12.dp)
            val buttonSmall: Shape = RoundedCornerShape(8.dp)
            val buttonLarge: Shape = RoundedCornerShape(16.dp)
            val buttonPill: Shape = RoundedCornerShape(50)
            
            // Card shapes
            val card: Shape = RoundedCornerShape(12.dp)
            val cardElevated: Shape = RoundedCornerShape(16.dp)
            
            // Input shapes
            val textField: Shape = RoundedCornerShape(8.dp)
            val textFieldOutlined: Shape = RoundedCornerShape(12.dp)
            
            // Container shapes
            val dialog: Shape = RoundedCornerShape(28.dp)
            val bottomSheet: Shape = RoundedCornerShape(
                topStart = 28.dp,
                topEnd = 28.dp,
                bottomStart = 0.dp,
                bottomEnd = 0.dp
            )
            val snackbar: Shape = RoundedCornerShape(8.dp)
            
            // Chip shapes
            val chip: Shape = RoundedCornerShape(8.dp)
            val chipPill: Shape = RoundedCornerShape(50)
            
            // Badge shapes
            val badge: Shape = RoundedCornerShape(50)
            val badgeSquare: Shape = RoundedCornerShape(4.dp)
            
            // Image shapes
            val imageDefault: Shape = RoundedCornerShape(12.dp)
            val imageAvatar: Shape = RoundedCornerShape(50)
        }
        
        /**
         * Custom shape with specific corner radius
         */
        fun custom(radius: Int): Shape = RoundedCornerShape(radius.dp)
        
        /**
         * Top-only rounded shape
         */
        fun topRounded(radius: Int): Shape = RoundedCornerShape(
            topStart = radius.dp,
            topEnd = radius.dp,
            bottomStart = 0.dp,
            bottomEnd = 0.dp
        )
        
        /**
         * Bottom-only rounded shape
         */
        fun bottomRounded(radius: Int): Shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomStart = radius.dp,
            bottomEnd = radius.dp
        )
    }
}

/**
 * CompositionLocal for providing shapes throughout the app
 */
val LocalGlintShape = staticCompositionLocalOf { GlintShape() }