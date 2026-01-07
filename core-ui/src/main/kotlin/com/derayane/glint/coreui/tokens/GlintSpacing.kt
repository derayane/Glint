package com.derayane.glint.coreui.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Glint Spacing Design Tokens
 * Based on Figma spacing system from 2px to 80px
 * Following 4px base grid system for consistent spacing
 */
@Immutable
data class GlintSpacing(
    val none: Dp = 0.dp,
    
    // Extra small spacing
    val xxs: Dp = 2.dp,
    val xs: Dp = 4.dp,
    
    // Small spacing
    val sm: Dp = 8.dp,
    val smPlus: Dp = 12.dp,
    
    // Medium spacing
    val md: Dp = 16.dp,
    val mdPlus: Dp = 20.dp,
    
    // Large spacing
    val lg: Dp = 24.dp,
    val lgPlus: Dp = 28.dp,
    
    // Extra large spacing
    val xl: Dp = 32.dp,
    val xlPlus: Dp = 36.dp,
    
    // 2X large spacing
    val xxl: Dp = 40.dp,
    val xxlPlus: Dp = 48.dp,
    
    // 3X large spacing
    val xxxl: Dp = 56.dp,
    val xxxlPlus: Dp = 64.dp,
    
    // 4X large spacing
    val xxxxl: Dp = 72.dp,
    val xxxxxl: Dp = 80.dp
) {
    companion object {
        /**
 * Get spacing value by multiplier
         * @param multiplier The multiplier based on 4dp grid (e.g., 1 = 4dp, 2 = 8dp)
         */
        fun fromMultiplier(multiplier: Int): Dp = (multiplier * 4).dp
        
        /**
         * Common component-specific spacing values
         */
        object Component {
            val buttonHorizontalPadding: Dp = 24.dp
            val buttonVerticalPadding: Dp = 12.dp
            val buttonIconSpacing: Dp = 8.dp
            
            val cardPadding: Dp = 16.dp
            val cardElevation: Dp = 4.dp
            
            val listItemPadding: Dp = 16.dp
            val listItemVerticalPadding: Dp = 12.dp
            
            val screenHorizontalPadding: Dp = 16.dp
            val screenVerticalPadding: Dp = 16.dp
            
            val iconSize: Dp = 24.dp
            val iconSizeSmall: Dp = 16.dp
            val iconSizeLarge: Dp = 32.dp
        }
    }
}

/**
 * CompositionLocal for providing spacing throughout the app
 */
val LocalGlintSpacing = staticCompositionLocalOf { GlintSpacing() }