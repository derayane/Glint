package com.derayane.glint.coreui.tokens

import androidx.compose.ui.graphics.Color

/**
 * Glint Design System - Color Tokens
 * 
 * This file contains the complete color palette for the Glint design system,
 * including primitive colors and semantic color mappings for both light and dark themes.
 * 
 * Color System Structure:
 * - Primitive Colors: Base color palette (Text, Neutral, Greyscale, Primary, Secondary)
 * - Semantic Colors: Context-aware colors that adapt to light/dark mode
 * 
 * @since 1.0.0
 * Last Updated: 2026-01-07
 */

// ================================================================================================
// PRIMITIVE COLORS - Base Palette
// ================================================================================================

/**
 * Text primitive colors
 * Used for all text content across the application
 */
object GlintTextColors {
    /** Primary text color - highest emphasis */
    val Primary = Color(0xFF1A1A1A)
    
    /** Secondary text color - medium emphasis */
    val Secondary = Color(0xFF4A4A4A)
    
    /** Tertiary text color - lower emphasis */
    val Tertiary = Color(0xFF757575)
    
    /** Disabled text color */
    val Disabled = Color(0xFFBDBDBD)
    
    /** Inverse text color - for use on dark backgrounds */
    val Inverse = Color(0xFFFFFFFF)
    
    /** Placeholder text color */
    val Placeholder = Color(0xFF9E9E9E)
}

/**
 * Neutral primitive colors
 * Used for backgrounds, surfaces, and dividers
 */
object GlintNeutralColors {
    /** Pure white */
    val White = Color(0xFFFFFFFF)
    
    /** Light background */
    val Background = Color(0xFFFAFAFA)
    
    /** Surface color */
    val Surface = Color(0xFFFFFFFF)
    
    /** Surface variant */
    val SurfaceVariant = Color(0xFFF5F5F5)
    
    /** Border color */
    val Border = Color(0xFFE0E0E0)
    
    /** Divider color */
    val Divider = Color(0xFFEEEEEE)
    
    /** Overlay color */
    val Overlay = Color(0x52000000)
}

/**
 * Greyscale primitive colors
 * Comprehensive grey palette for various UI elements
 */
object GlintGreyscaleColors {
    val Grey50 = Color(0xFFFAFAFA)
    val Grey100 = Color(0xFFF5F5F5)
    val Grey200 = Color(0xFFEEEEEE)
    val Grey300 = Color(0xFFE0E0E0)
    val Grey400 = Color(0xFFBDBDBD)
    val Grey500 = Color(0xFF9E9E9E)
    val Grey600 = Color(0xFF757575)
    val Grey700 = Color(0xFF616161)
    val Grey800 = Color(0xFF424242)
    val Grey900 = Color(0xFF212121)
}

/**
 * Primary color palette - Green
 * Main brand colors used throughout the application
 */
object GlintPrimaryColors {
    val Green50 = Color(0xFFE8F5E9)
    val Green100 = Color(0xFFC8E6C9)
    val Green200 = Color(0xFFA5D6A7)
    val Green300 = Color(0xFF81C784)
    val Green400 = Color(0xFF66BB6A)
    val Green500 = Color(0xFF4CAF50)
    val Green600 = Color(0xFF43A047)
    val Green700 = Color(0xFF388E3C)
    val Green800 = Color(0xFF2E7D32)
    val Green900 = Color(0xFF1B5E20)
    val GreenA100 = Color(0xFFB9F6CA)
    val GreenA200 = Color(0xFF69F0AE)
    val GreenA400 = Color(0xFF00E676)
    val GreenA700 = Color(0xFF00C853)
}

/**
 * Secondary color palette
 * Complementary colors for accents and highlights
 */
object GlintSecondaryColors {
    // Blue accent colors
    object Blue {
        val Blue50 = Color(0xFFE3F2FD)
        val Blue100 = Color(0xFFBBDEFB)
        val Blue200 = Color(0xFF90CAF9)
        val Blue300 = Color(0xFF64B5F6)
        val Blue400 = Color(0xFF42A5F5)
        val Blue500 = Color(0xFF2196F3)
        val Blue600 = Color(0xFF1E88E5)
        val Blue700 = Color(0xFF1976D2)
        val Blue800 = Color(0xFF1565C0)
        val Blue900 = Color(0xFF0D47A1)
    }
    
    // Orange accent colors
    object Orange {
        val Orange50 = Color(0xFFFFF3E0)
        val Orange100 = Color(0xFFFFE0B2)
        val Orange200 = Color(0xFFFFCC80)
        val Orange300 = Color(0xFFFFB74D)
        val Orange400 = Color(0xFFFFA726)
        val Orange500 = Color(0xFFFF9800)
        val Orange600 = Color(0xFFFB8C00)
        val Orange700 = Color(0xFFF57C00)
        val Orange800 = Color(0xFFEF6C00)
        val Orange900 = Color(0xFFE65100)
    }
    
    // Purple accent colors
    object Purple {
        val Purple50 = Color(0xFFF3E5F5)
        val Purple100 = Color(0xFFE1BEE7)
        val Purple200 = Color(0xFFCE93D8)
        val Purple300 = Color(0xFFBA68C8)
        val Purple400 = Color(0xFFAB47BC)
        val Purple500 = Color(0xFF9C27B0)
        val Purple600 = Color(0xFF8E24AA)
        val Purple700 = Color(0xFF7B1FA2)
        val Purple800 = Color(0xFF6A1B9A)
        val Purple900 = Color(0xFF4A148C)
    }
    
    // Teal accent colors
    object Teal {
        val Teal50 = Color(0xFFE0F2F1)
        val Teal100 = Color(0xFFB2DFDB)
        val Teal200 = Color(0xFF80CBC4)
        val Teal300 = Color(0xFF4DB6AC)
        val Teal400 = Color(0xFF26A69A)
        val Teal500 = Color(0xFF009688)
        val Teal600 = Color(0xFF00897B)
        val Teal700 = Color(0xFF00796B)
        val Teal800 = Color(0xFF00695C)
        val Teal900 = Color(0xFF004D40)
    }
}

/**
 * Semantic color palette - Status colors
 * Used for alerts, notifications, and status indicators
 */
object GlintStatusColors {
    // Success colors
    object Success {
        val Light = Color(0xFF81C784)
        val Main = Color(0xFF4CAF50)
        val Dark = Color(0xFF388E3C)
        val Background = Color(0xFFE8F5E9)
        val Border = Color(0xFFC8E6C9)
    }
    
    // Error colors
    object Error {
        val Light = Color(0xFFE57373)
        val Main = Color(0xFFF44336)
        val Dark = Color(0xFFD32F2F)
        val Background = Color(0xFFFFEBEE)
        val Border = Color(0xFFFFCDD2)
    }
    
    // Warning colors
    object Warning {
        val Light = Color(0xFFFFB74D)
        val Main = Color(0xFFFF9800)
        val Dark = Color(0xFFF57C00)
        val Background = Color(0xFFFFF3E0)
        val Border = Color(0xFFFFE0B2)
    }
    
    // Info colors
    object Info {
        val Light = Color(0xFF64B5F6)
        val Main = Color(0xFF2196F3)
        val Dark = Color(0xFF1976D2)
        val Background = Color(0xFFE3F2FD)
        val Border = Color(0xFFBBDEFB)
    }
}

// ================================================================================================
// SEMANTIC COLOR SCHEME - Theme-Aware Colors
// ================================================================================================

/**
 * Semantic color scheme for light mode
 * Maps semantic purposes to specific primitive colors
 */
object GlintLightColorScheme {
    // Surface colors
    val background = GlintNeutralColors.Background
    val surface = GlintNeutralColors.Surface
    val surfaceVariant = GlintNeutralColors.SurfaceVariant
    val surfaceInverse = GlintGreyscaleColors.Grey900
    
    // Primary colors
    val primary = GlintPrimaryColors.Green600
    val onPrimary = GlintNeutralColors.White
    val primaryContainer = GlintPrimaryColors.Green100
    val onPrimaryContainer = GlintPrimaryColors.Green900
    
    // Secondary colors
    val secondary = GlintSecondaryColors.Blue.Blue600
    val onSecondary = GlintNeutralColors.White
    val secondaryContainer = GlintSecondaryColors.Blue.Blue100
    val onSecondaryContainer = GlintSecondaryColors.Blue.Blue900
    
    // Tertiary colors
    val tertiary = GlintSecondaryColors.Teal.Teal600
    val onTertiary = GlintNeutralColors.White
    val tertiaryContainer = GlintSecondaryColors.Teal.Teal100
    val onTertiaryContainer = GlintSecondaryColors.Teal.Teal900
    
    // Text colors
    val textPrimary = GlintTextColors.Primary
    val textSecondary = GlintTextColors.Secondary
    val textTertiary = GlintTextColors.Tertiary
    val textDisabled = GlintTextColors.Disabled
    val textInverse = GlintTextColors.Inverse
    
    // Border and divider colors
    val border = GlintNeutralColors.Border
    val divider = GlintNeutralColors.Divider
    val outline = GlintGreyscaleColors.Grey400
    val outlineVariant = GlintGreyscaleColors.Grey300
    
    // Overlay and shadow colors
    val overlay = GlintNeutralColors.Overlay
    val scrim = Color(0x99000000)
    
    // Status colors
    val success = GlintStatusColors.Success.Main
    val onSuccess = GlintNeutralColors.White
    val successContainer = GlintStatusColors.Success.Background
    val onSuccessContainer = GlintStatusColors.Success.Dark
    
    val error = GlintStatusColors.Error.Main
    val onError = GlintNeutralColors.White
    val errorContainer = GlintStatusColors.Error.Background
    val onErrorContainer = GlintStatusColors.Error.Dark
    
    val warning = GlintStatusColors.Warning.Main
    val onWarning = GlintNeutralColors.White
    val warningContainer = GlintStatusColors.Warning.Background
    val onWarningContainer = GlintStatusColors.Warning.Dark
    
    val info = GlintStatusColors.Info.Main
    val onInfo = GlintNeutralColors.White
    val infoContainer = GlintStatusColors.Info.Background
    val onInfoContainer = GlintStatusColors.Info.Dark
}

/**
 * Semantic color scheme for dark mode
 * Maps semantic purposes to specific primitive colors for dark theme
 */
object GlintDarkColorScheme {
    // Surface colors
    val background = Color(0xFF121212)
    val surface = Color(0xFF1E1E1E)
    val surfaceVariant = Color(0xFF2C2C2C)
    val surfaceInverse = GlintNeutralColors.Surface
    
    // Primary colors
    val primary = GlintPrimaryColors.Green400
    val onPrimary = Color(0xFF003911)
    val primaryContainer = GlintPrimaryColors.Green800
    val onPrimaryContainer = GlintPrimaryColors.Green100
    
    // Secondary colors
    val secondary = GlintSecondaryColors.Blue.Blue400
    val onSecondary = Color(0xFF003258)
    val secondaryContainer = GlintSecondaryColors.Blue.Blue800
    val onSecondaryContainer = GlintSecondaryColors.Blue.Blue100
    
    // Tertiary colors
    val tertiary = GlintSecondaryColors.Teal.Teal400
    val onTertiary = Color(0xFF003731)
    val tertiaryContainer = GlintSecondaryColors.Teal.Teal800
    val onTertiaryContainer = GlintSecondaryColors.Teal.Teal100
    
    // Text colors
    val textPrimary = Color(0xFFE0E0E0)
    val textSecondary = Color(0xFFB0B0B0)
    val textTertiary = Color(0xFF909090)
    val textDisabled = Color(0xFF606060)
    val textInverse = GlintTextColors.Primary
    
    // Border and divider colors
    val border = Color(0xFF3A3A3A)
    val divider = Color(0xFF2C2C2C)
    val outline = Color(0xFF5A5A5A)
    val outlineVariant = Color(0xFF424242)
    
    // Overlay and shadow colors
    val overlay = Color(0x99000000)
    val scrim = Color(0xCC000000)
    
    // Status colors
    val success = GlintStatusColors.Success.Light
    val onSuccess = Color(0xFF003911)
    val successContainer = Color(0xFF1B5E20)
    val onSuccessContainer = GlintPrimaryColors.Green100
    
    val error = GlintStatusColors.Error.Light
    val onError = Color(0xFF5F0000)
    val errorContainer = Color(0xFFC62828)
    val onErrorContainer = Color(0xFFFFCDD2)
    
    val warning = GlintStatusColors.Warning.Light
    val onWarning = Color(0xFF4E2A00)
    val warningContainer = Color(0xFFE65100)
    val onWarningContainer = Color(0xFFFFE0B2)
    
    val info = GlintStatusColors.Info.Light
    val onInfo = Color(0xFF003258)
    val infoContainer = Color(0xFF1565C0)
    val onInfoContainer = Color(0xFFBBDEFB)
}

// ================================================================================================
// UTILITY FUNCTIONS
// ================================================================================================

/**
 * Utility function to get color with alpha/opacity
 * 
 * @param color The base color
 * @param alpha Alpha value between 0.0 (transparent) and 1.0 (opaque)
 * @return Color with applied alpha
 */
fun Color.withAlpha(alpha: Float): Color = this.copy(alpha = alpha.coerceIn(0f, 1f))

/**
 * Extension property to check if a color is considered "light"
 * Useful for determining appropriate text color on a background
 * 
 * @return true if the color is light, false otherwise
 */
val Color.isLight: Boolean
    get() {
        val luminance = (0.299 * red + 0.587 * green + 0.114 * blue)
        return luminance > 0.5
    }

/**
 * Get appropriate text color (light or dark) for a given background color
 * 
 * @param background The background color
 * @return Appropriate text color for readability
 */
fun getTextColorForBackground(background: Color): Color {
    return if (background.isLight) {
        GlintTextColors.Primary
    } else {
        GlintTextColors.Inverse
    }
}

// ================================================================================================
// DOCUMENTATION
// ================================================================================================

/**
 * Color Usage Guidelines:
 * 
 * 1. PRIMITIVE COLORS:
 *    - Use primitive colors directly when you need a specific shade
 *    - Example: GlintPrimaryColors.Green500 for a specific green
 * 
 * 2. SEMANTIC COLORS:
 *    - Prefer semantic colors for theme-aware components
 *    - Example: Use colorScheme.primary instead of GlintPrimaryColors.Green600
 * 
 * 3. STATUS COLORS:
 *    - Use status colors for alerts, notifications, and feedback
 *    - Example: GlintStatusColors.Success.Main for success messages
 * 
 * 4. TEXT COLORS:
 *    - Use appropriate text color hierarchy for content
 *    - Primary: Headlines, important text
 *    - Secondary: Body text, secondary information
 *    - Tertiary: Captions, helper text
 *    - Disabled: Inactive elements
 * 
 * 5. ACCESSIBILITY:
 *    - Ensure sufficient contrast ratios (WCAG AA: 4.5:1 for normal text)
 *    - Use semantic colors that automatically adapt to theme
 *    - Test colors in both light and dark modes
 * 
 * 6. CONSISTENCY:
 *    - Stick to the defined palette
 *    - Don't create custom colors unless absolutely necessary
 *    - Document any additions to this file
 */
