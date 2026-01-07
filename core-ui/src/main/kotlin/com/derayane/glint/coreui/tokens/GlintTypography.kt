package com.derayane.glint.coreui.tokens

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Glint Design System - Typography Tokens
 * Integrated from Figma design tokens using Nunito font family
 */
object GlintTypography {
    
    // Nunito Font Family
    val NunitoFontFamily = FontFamily(
        Font(resId = R.font.nunito_regular, weight = FontWeight.Normal),
        Font(resId = R.font.nunito_semibold, weight = FontWeight.SemiBold),
        Font(resId = R.font.nunito_bold, weight = FontWeight.Bold)
    )
    
    // Font Weights
    object Weight {
        val Regular = FontWeight.W400
        val SemiBold = FontWeight.W600
        val Bold = FontWeight.W700
    }
    
    // Headline Styles
    object Headline {
        val ExtraLarge = TextStyle(
            fontFamily = NunitoFontFamily,
            fontWeight = Weight.Bold,
            fontSize = 56.sp,
            lineHeight = 78.sp
        )
        
        val Large = TextStyle(
            fontFamily = NunitoFontFamily,
            fontWeight = Weight.Bold,
            fontSize = 40.sp,
            lineHeight = 44.sp
        )
        
        val MediumBold = TextStyle(
            fontFamily = NunitoFontFamily,
            fontWeight = Weight.Bold,
            fontSize = 32.sp,
            lineHeight = 38.sp
        )
        
        val Medium = TextStyle(
            fontFamily = NunitoFontFamily,
            fontWeight = Weight.Regular,
            fontSize = 32.sp,
            lineHeight = 38.sp
        )
    }
    
    // Title Styles
    object Title {
        val LargeBold = TextStyle(
            fontFamily = NunitoFontFamily,
            fontWeight = Weight.Bold,
            fontSize = 24.sp,
            lineHeight = 36.sp
        )
        
        val Large = TextStyle(
            fontFamily = NunitoFontFamily,
            fontWeight = Weight.Regular,
            fontSize = 24.sp,
            lineHeight = 36.sp
        )
        
        val MediumBold = TextStyle(
            fontFamily = NunitoFontFamily,
            fontWeight = Weight.Bold,
            fontSize = 18.sp,
            lineHeight = 26.sp
        )
        
        val Medium = TextStyle(
            fontFamily = NunitoFontFamily,
            fontWeight = Weight.Regular,
            fontSize = 18.sp,
            lineHeight = 26.sp
        )
        
        val SmallBold = TextStyle(
            fontFamily = NunitoFontFamily,
            fontWeight = Weight.Bold,
            fontSize = 16.sp,
            lineHeight = 24.sp
        )
        
        val Small = TextStyle(
            fontFamily = NunitoFontFamily,
            fontWeight = Weight.Regular,
            fontSize = 16.sp,
            lineHeight = 24.sp
        )
    }
    
    // Body Styles
    object Body {
        val MediumBold = TextStyle(
            fontFamily = NunitoFontFamily,
            fontWeight = Weight.Bold,
            fontSize = 14.sp,
            lineHeight = 20.sp
        )
        
        val Medium = TextStyle(
            fontFamily = NunitoFontFamily,
            fontWeight = Weight.Regular,
            fontSize = 14.sp,
            lineHeight = 20.sp
        )
        
        val SmallBold = TextStyle(
            fontFamily = NunitoFontFamily,
            fontWeight = Weight.Bold,
            fontSize = 12.sp,
            lineHeight = 18.sp
        )
        
        val Small = TextStyle(
            fontFamily = NunitoFontFamily,
            fontWeight = Weight.Regular,
            fontSize = 12.sp,
            lineHeight = 18.sp
        )
    }
    
    // Label Styles
    object Label {
        val Large = TextStyle(
            fontFamily = NunitoFontFamily,
            fontWeight = Weight.Regular,
            fontSize = 12.sp,
            lineHeight = 18.sp
        )
    }
}
