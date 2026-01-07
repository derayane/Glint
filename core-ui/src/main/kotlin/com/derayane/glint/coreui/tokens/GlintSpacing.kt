package com.derayane.glint.coreui.tokens

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Glint Design System - Spacing Tokens
 * Integrated from Figma design tokens
 */
object GlintSpacing {
    
    /**
     * Spacing scale from Figma (2-80px)
     */
    val XXXSmall: Dp = 2.dp
    val XXSmall: Dp = 4.dp
    val XSmall: Dp = 8.dp
    val Small: Dp = 12.dp
    val Medium: Dp = 16.dp
    val Large: Dp = 24.dp
    val XLarge: Dp = 32.dp
    val XXLarge: Dp = 40.dp
    val XXXLarge: Dp = 48.dp
    val Huge: Dp = 56.dp
    val XHuge: Dp = 64.dp
    val XXHuge: Dp = 72.dp
    val XXXHuge: Dp = 80.dp
    
    /**
     * Semantic spacing aliases for common use cases
     */
    object Semantic {
        // Component internal spacing
        val ComponentPaddingSmall = XSmall
        val ComponentPaddingMedium = Medium
        val ComponentPaddingLarge = Large
        
        // Gap between elements
        val GapTiny = XXSmall
        val GapSmall = XSmall
        val GapMedium = Medium
        val GapLarge = Large
        val GapXLarge = XLarge
        
        // Section spacing
        val SectionSpacingSmall = Large
        val SectionSpacingMedium = XLarge
        val SectionSpacingLarge = XXXLarge
        
        // Screen margins
        val ScreenMarginSmall = Medium
        val ScreenMarginMedium = Large
        val ScreenMarginLarge = XLarge
    }
}
