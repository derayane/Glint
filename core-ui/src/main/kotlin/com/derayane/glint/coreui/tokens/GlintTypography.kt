package com.derayane.glint.coreui.tokens

import androidx.compose.ui.text. TextStyle
import androidx.compose. ui.text.font.FontFamily
import androidx.compose.ui. text.font.FontWeight
import androidx.compose.ui.unit. sp

/**
 * Glint Design System - Typography Tokens
 * Integrated from Figma design tokens
 * 
 * Currently uses system default font
 * TODO: Add Nunito font files to use custom font
 */

object GlintFontWeight {
    val Regular = FontWeight.W400
    val SemiBold = FontWeight. W600
    val Bold = FontWeight.W700
}

object GlintTypography {
    
    // Headline Styles
    object Headline {
        val ExtraLarge = TextStyle(
            fontFamily = FontFamily. Default,  // System font
            fontWeight = GlintFontWeight.Bold,
            fontSize = 56.sp,
            lineHeight = 78.sp,
            letterSpacing = 0.sp
        )
        
        val Large = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = GlintFontWeight.Bold,
            fontSize = 40.sp,
            lineHeight = 44.sp,
            letterSpacing = 0.sp
        )
        
        val MediumBold = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = GlintFontWeight.Bold,
            fontSize = 32.sp,
            lineHeight = 38.sp,
            letterSpacing = 0.sp
        )
        
        val Medium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = GlintFontWeight.Regular,
            fontSize = 32.sp,
            lineHeight = 38.sp,
            letterSpacing = 0.sp
        )
    }
    
    // Title Styles
    object Title {
        val LargeBold = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = GlintFontWeight. Bold,
            fontSize = 24.sp,
            lineHeight = 36.sp,
            letterSpacing = 0.sp
        )
        
        val Large = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = GlintFontWeight.SemiBold,
            fontSize = 24.sp,
            lineHeight = 36.sp,
            letterSpacing = 0.sp
        )
        
        val MediumBold = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = GlintFontWeight.Bold,
            fontSize = 18.sp,
            lineHeight = 26.sp,
            letterSpacing = 0.sp
        )
        
        val Medium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = GlintFontWeight.SemiBold,
            fontSize = 18.sp,
            lineHeight = 26.sp,
            letterSpacing = 0.sp
        )
        
        val SmallBold = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = GlintFontWeight.Bold,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.sp
        )
        
        val Small = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = GlintFontWeight.SemiBold,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.sp
        )
    }
    
    // Body Styles
    object Body {
        val MediumBold = TextStyle(
            fontFamily = FontFamily. Default,
            fontWeight = GlintFontWeight.Bold,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.sp
        )
        
        val Medium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = GlintFontWeight. SemiBold,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.sp
        )
        
        val SmallBold = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = GlintFontWeight. Bold,
            fontSize = 12.sp,
            lineHeight = 18.sp,
            letterSpacing = 0.sp
        )
        
        val Small = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = GlintFontWeight.SemiBold,
            fontSize = 12.sp,
            lineHeight = 18.sp,
            letterSpacing = 0.sp
        )
    }
    
    // Label Styles
    object Label {
        val Large = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = GlintFontWeight.SemiBold,
            fontSize = 12.sp,
            lineHeight = 18.sp,
            letterSpacing = 0.sp
        )
    }
}
