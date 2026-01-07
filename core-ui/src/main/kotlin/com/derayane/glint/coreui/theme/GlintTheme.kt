package com.derayane.glint.coreui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.derayane.glint.coreui.tokens.*

/**
 * Glint Theme using semantic color tokens
 */

// Light Color Scheme using semantic tokens
private val LightColorScheme = ColorScheme(
    primary = GlintSemanticColorsLight.primary,
    onPrimary = GlintSemanticColorsLight.onPrimary,
    primaryContainer = GlintSemanticColorsLight.primaryContainer,
    onPrimaryContainer = GlintSemanticColorsLight.onPrimaryContainer,
    inversePrimary = GlintSemanticColorsLight.inversePrimary,
    
    secondary = GlintSemanticColorsLight.secondary,
    onSecondary = GlintSemanticColorsLight.onSecondary,
    secondaryContainer = GlintSemanticColorsLight.secondaryContainer,
    onSecondaryContainer = GlintSemanticColorsLight.onSecondaryContainer,
    
    tertiary = GlintSemanticColorsLight.tertiary,
    onTertiary = GlintSemanticColorsLight.onTertiary,
    tertiaryContainer = GlintSemanticColorsLight.tertiaryContainer,
    onTertiaryContainer = GlintSemanticColorsLight.onTertiaryContainer,
    
    background = GlintSemanticColorsLight.background,
    onBackground = GlintSemanticColorsLight.onBackground,
    
    surface = GlintSemanticColorsLight.surface,
    onSurface = GlintSemanticColorsLight.onSurface,
    surfaceVariant = GlintSemanticColorsLight.surfaceVariant,
    onSurfaceVariant = GlintSemanticColorsLight.onSurfaceVariant,
    surfaceTint = GlintSemanticColorsLight.primary,
    inverseSurface = GlintSemanticColorsLight.inverseSurface,
    inverseOnSurface = GlintSemanticColorsLight.inverseOnSurface,
    
    error = GlintSemanticColorsLight.error,
    onError = GlintSemanticColorsLight.onError,
    errorContainer = GlintSemanticColorsLight.errorContainer,
    onErrorContainer = GlintSemanticColorsLight.onErrorContainer,
    
    outline = GlintSemanticColorsLight.outline,
    outlineVariant = GlintSemanticColorsLight.outlineVariant,
    scrim = GlintSemanticColorsLight.scrim,
    
    surfaceBright = GlintNeutralColors.white,
    surfaceDim = GlintNeutralColors.componentBackground,
    surfaceContainer = GlintNeutralColors.componentBackground,
    surfaceContainerHigh = GlintNeutralColors.foreground,
    surfaceContainerHighest = GlintNeutralColors.disabledBackground,
    surfaceContainerLow = GlintNeutralColors.background,
    surfaceContainerLowest = GlintNeutralColors.white
)

// Dark Color Scheme using semantic tokens
private val DarkColorScheme = ColorScheme(
    primary = GlintSemanticColorsDark.primary,
    onPrimary = GlintSemanticColorsDark.onPrimary,
    primaryContainer = GlintSemanticColorsDark.primaryContainer,
    onPrimaryContainer = GlintSemanticColorsDark.onPrimaryContainer,
    inversePrimary = GlintSemanticColorsDark.inversePrimary,
    
    secondary = GlintSemanticColorsDark.secondary,
    onSecondary = GlintSemanticColorsDark.onSecondary,
    secondaryContainer = GlintSemanticColorsDark.secondaryContainer,
    onSecondaryContainer = GlintSemanticColorsDark.onSecondaryContainer,
    
    tertiary = GlintSemanticColorsDark.tertiary,
    onTertiary = GlintSemanticColorsDark.onTertiary,
    tertiaryContainer = GlintSemanticColorsDark.tertiaryContainer,
    onTertiaryContainer = GlintSemanticColorsDark.onTertiaryContainer,
    
    background = GlintSemanticColorsDark.background,
    onBackground = GlintSemanticColorsDark.onBackground,
    
    surface = GlintSemanticColorsDark.surface,
    onSurface = GlintSemanticColorsDark.onSurface,
    surfaceVariant = GlintSemanticColorsDark.surfaceVariant,
    onSurfaceVariant = GlintSemanticColorsDark.onSurfaceVariant,
    surfaceTint = GlintSemanticColorsDark.primary,
    inverseSurface = GlintSemanticColorsDark.inverseSurface,
    inverseOnSurface = GlintSemanticColorsDark.inverseOnSurface,
    
    error = GlintSemanticColorsDark.error,
    onError = GlintSemanticColorsDark.onError,
    errorContainer = GlintSemanticColorsDark.errorContainer,
    onErrorContainer = GlintSemanticColorsDark.onErrorContainer,
    
    outline = GlintSemanticColorsDark.outline,
    outlineVariant = GlintSemanticColorsDark.outlineVariant,
    scrim = GlintSemanticColorsDark.scrim,
    
    surfaceBright = GlintGreyscaleJetBlack.minus30,
    surfaceDim = GlintGreyscaleJetBlack.base,
    surfaceContainer = GlintGreyscaleJetBlack.minus20,
    surfaceContainerHigh = GlintGreyscaleJetBlack.minus30,
    surfaceContainerHighest = GlintGreyscaleJetBlack.minus40,
    surfaceContainerLow = GlintGreyscaleJetBlack.minus10,
    surfaceContainerLowest = GlintGreyscaleJetBlack.base
)

// Spacing tokens
data class GlintSpacing(
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 24.dp,
    val extraLarge: Dp = 32.dp,
    val huge: Dp = 48.dp
)

// Shape tokens
val GlintShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp),
    extraLarge = RoundedCornerShape(24.dp)
)

// Composition locals for Glint tokens
val LocalGlintTypography = staticCompositionLocalOf { GlintTypographyTokens() }
val LocalGlintSpacing = staticCompositionLocalOf { GlintSpacing() }
val LocalGlintShapes = staticCompositionLocalOf { GlintShapes }
val LocalGlintColorScheme = staticCompositionLocalOf { LightColorScheme }

/**
 * GlintTheme object to access theme tokens
 */
object GlintTheme {
    val typography: GlintTypographyTokens
        @Composable
        get() = LocalGlintTypography.current
    
    val spacing: GlintSpacing
        @Composable
        get() = LocalGlintSpacing.current
    
    val shape: Shapes
        @Composable
        get() = LocalGlintShapes.current
    
    val colorScheme: ColorScheme
        @Composable
        get() = LocalGlintColorScheme.current
}

/**
 * GlintTheme composable
 */
@Composable
fun GlintTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    typography: GlintTypographyTokens = GlintTypographyTokens(),
    spacing: GlintSpacing = GlintSpacing(),
    shapes: Shapes = GlintShapes,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    
    CompositionLocalProvider(
        LocalGlintTypography provides typography,
        LocalGlintSpacing provides spacing,
        LocalGlintShapes provides shapes,
        LocalGlintColorScheme provides colorScheme
    ) {
        content()
    }
}