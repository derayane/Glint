package com.derayane.glint.coreui.tokens

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

/**
 * Glint Design System - Shape Tokens
 * Integrated from Figma design tokens
 */
object GlintShape {
    
    /**
     * Border radius values from Figma
     */
    val None = RoundedCornerShape(0.dp)
    val XSmall = RoundedCornerShape(4.dp)
    val Small = RoundedCornerShape(8.dp)
    val Medium = RoundedCornerShape(16.dp)
    val Large = RoundedCornerShape(24.dp)
    val XLarge = RoundedCornerShape(32.dp)
    val Full = RoundedCornerShape(1000.dp)
    
    /**
     * Semantic shape aliases for common components
     */
    object Semantic {
        // Buttons
        val ButtonSmall = Small
        val ButtonMedium = Medium
        val ButtonLarge = Large
        val ButtonPill = Full
        
        // Cards and containers
        val Card = Medium
        val Container = Small
        val Dialog = Large
        
        // Input fields
        val TextField = Small
        val TextFieldRounded = Medium
        
        // Chips and badges
        val Chip = Full
        val Badge = Full
        
        // Images and avatars
        val Avatar = Full
        val ImageSmall = Small
        val ImageMedium = Medium
        val ImageLarge = Large
    }
}
