package com.derayane.glint.coreui.tokens

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Glint Typography System - Exact Figma JSON naming
 */

// Headline Styles
object GlintHeadlineTypography {
    val extraLarge = TextStyle(
        fontSize = 56.sp,
        lineHeight = 78.sp,
        fontWeight = FontWeight(700)
    )
    
    val large = TextStyle(
        fontSize = 40.sp,
        lineHeight = 44.sp,
        fontWeight = FontWeight(700)
    )
    
    val mediumBold = TextStyle(
        fontSize = 32.sp,
        lineHeight = 38.sp,
        fontWeight = FontWeight(700)
    )
    
    val medium = TextStyle(
        fontSize = 32.sp,
        lineHeight = 38.sp,
        fontWeight = FontWeight(400)
    )
}

// Title Styles
object GlintTitleTypography {
    val largeBold = TextStyle(
        fontSize = 24.sp,
        lineHeight = 36.sp,
        fontWeight = FontWeight(700)
    )
    
    val large = TextStyle(
        fontSize = 24.sp,
        lineHeight = 36.sp,
        fontWeight = FontWeight(600)
    )
    
    val mediumBold = TextStyle(
        fontSize = 18.sp,
        lineHeight = 26.sp,
        fontWeight = FontWeight(700)
    )
    
    val medium = TextStyle(
        fontSize = 18.sp,
        lineHeight = 26.sp,
        fontWeight = FontWeight(600)
    )
    
    val smallBold = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight(700)
    )
    
    val small = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight(600)
    )
}

// Body Styles
object GlintBodyTypography {
    val mediumBold = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(700)
    )
    
    val medium = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(600)
    )
    
    val smallBold = TextStyle(
        fontSize = 12.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight(700)
    )
    
    val small = TextStyle(
        fontSize = 12.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight(600)
    )
}

// Label Styles
object GlintLabelTypography {
    val large = TextStyle(
        fontSize = 12.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight(600)
    )
}

/**
 * Typography token system for Glint Theme
 */
data class GlintTypographyTokens(
    // Headline
    val headlineExtraLarge: TextStyle = GlintHeadlineTypography.extraLarge,
    val headlineLarge: TextStyle = GlintHeadlineTypography.large,
    val headlineMediumBold: TextStyle = GlintHeadlineTypography.mediumBold,
    val headlineMedium: TextStyle = GlintHeadlineTypography.medium,
    
    // Title
    val titleLargeBold: TextStyle = GlintTitleTypography.largeBold,
    val titleLarge: TextStyle = GlintTitleTypography.large,
    val titleMediumBold: TextStyle = GlintTitleTypography.mediumBold,
    val titleMedium: TextStyle = GlintTitleTypography.medium,
    val titleSmallBold: TextStyle = GlintTitleTypography.smallBold,
    val titleSmall: TextStyle = GlintTitleTypography.small,
    
    // Body
    val bodyMediumBold: TextStyle = GlintBodyTypography.mediumBold,
    val bodyMedium: TextStyle = GlintBodyTypography.medium,
    val bodySmallBold: TextStyle = GlintBodyTypography.smallBold,
    val bodySmall: TextStyle = GlintBodyTypography.small,
    
    // Label
    val labelLarge: TextStyle = GlintLabelTypography.large
)