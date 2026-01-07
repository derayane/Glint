package com.derayane.glint.coreui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import com.derayane.glint.coreui.tokens.*

/**
 * Light color scheme using Glint semantic color tokens
 */
private val LightColorScheme = lightColorScheme(
    primary = GlintSemanticColorsLight.primary,
    onPrimary = GlintSemanticColorsLight.onPrimary,
    primaryContainer = GlintSemanticColorsLight.primaryContainer,
    onPrimaryContainer = GlintSemanticColorsLight.onPrimaryContainer,
    secondary = GlintSemanticColorsLight.secondary,
    onSecondary = GlintSemanticColorsLight.onSecondary,
    secondaryContainer = GlintSemanticColorsLight.secondaryContainer,
    onSecondaryContainer = GlintSemanticColorsLight.onSecondaryContainer,
    tertiary = GlintSemanticColorsLight.tertiary,
    onTertiary = GlintSemanticColorsLight.onTertiary,
    tertiaryContainer = GlintSemanticColorsLight.tertiaryContainer,
    onTertiaryContainer = GlintSemanticColorsLight.onTertiaryContainer,
    error = GlintSemanticColorsLight.error,
    onError = GlintSemanticColorsLight.onError,
    errorContainer = GlintSemanticColorsLight.errorContainer,
    onErrorContainer = GlintSemanticColorsLight.onErrorContainer,
    background = GlintSemanticColorsLight.background,
    onBackground = GlintSemanticColorsLight.onBackground,
    surface = GlintSemanticColorsLight.surface,
    onSurface = GlintSemanticColorsLight.onSurface,
    surfaceVariant = GlintSemanticColorsLight.surfaceVariant,
    onSurfaceVariant = GlintSemanticColorsLight.onSurfaceVariant,
    outline = GlintSemanticColorsLight.outline,
    outlineVariant = GlintSemanticColorsLight.outlineVariant,
    scrim = GlintSemanticColorsLight.scrim,
    inverseSurface = GlintSemanticColorsLight.inverseSurface,
    inverseOnSurface = GlintSemanticColorsLight.inverseOnSurface,
    inversePrimary = GlintSemanticColorsLight.inversePrimary
)

/**
 * Dark color scheme using Glint semantic color tokens
 */
private val DarkColorScheme = darkColorScheme(
    primary = GlintSemanticColorsDark.primary,
    onPrimary = GlintSemanticColorsDark.onPrimary,
    primaryContainer = GlintSemanticColorsDark.primaryContainer,
    onPrimaryContainer = GlintSemanticColorsDark.onPrimaryContainer,
    secondary = GlintSemanticColorsDark.secondary,
    onSecondary = GlintSemanticColorsDark.onSecondary,
    secondaryContainer = GlintSemanticColorsDark.secondaryContainer,
    onSecondaryContainer = GlintSemanticColorsDark.onSecondaryContainer,
    tertiary = GlintSemanticColorsDark.tertiary,
    onTertiary = GlintSemanticColorsDark.onTertiary,
    tertiaryContainer = GlintSemanticColorsDark.tertiaryContainer,
    onTertiaryContainer = GlintSemanticColorsDark.onTertiaryContainer,
    error = GlintSemanticColorsDark.error,
    onError = GlintSemanticColorsDark.onError,
    errorContainer = GlintSemanticColorsDark.errorContainer,
    onErrorContainer = GlintSemanticColorsDark.onErrorContainer,
    background = GlintSemanticColorsDark.background,
    onBackground = GlintSemanticColorsDark.onBackground,
    surface = GlintSemanticColorsDark.surface,
    onSurface = GlintSemanticColorsDark.onSurface,
    surfaceVariant = GlintSemanticColorsDark.surfaceVariant,
    onSurfaceVariant = GlintSemanticColorsDark.onSurfaceVariant,
    outline = GlintSemanticColorsDark.outline,
    outlineVariant = GlintSemanticColorsDark.outlineVariant,
    scrim = GlintSemanticColorsDark.scrim,
    inverseSurface = GlintSemanticColorsDark.inverseSurface,
    inverseOnSurface = GlintSemanticColorsDark.inverseOnSurface,
    inversePrimary = GlintSemanticColorsDark.inversePrimary
)

/**
 * Default Glint typography tokens
 */
private val DefaultTypography = GlintTypographyTokens()

/**
 * Default Glint spacing tokens
 */
private val DefaultSpacing = GlintSpacing()

/**
 * Default Glint shape tokens
 */
private val DefaultShape = GlintShape()

/**
 * CompositionLocal for Glint Typography
 */
private val LocalGlintTypography = staticCompositionLocalOf { DefaultTypography }

/**
 * GlintTheme provides access to the Glint Design System tokens
 */
object GlintTheme {
    /**
     * Access the current color scheme from Material Theme
     */
    val colorScheme: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme

    /**
     * Access the current typography tokens
     */
    val typography: GlintTypographyTokens
        @Composable
        @ReadOnlyComposable
        get() = LocalGlintTypography.current

    /**
     * Access the current spacing tokens
     */
    val spacing: GlintSpacing
        @Composable
        @ReadOnlyComposable
        get() = LocalGlintSpacing.current

    /**
     * Access the current shape tokens
     */
    val shape: GlintShape
        @Composable
        @ReadOnlyComposable
        get() = LocalGlintShape.current
}

/**
 * Main Glint theme composable
 */
@Composable
fun GlintTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    typography: GlintTypographyTokens = DefaultTypography,
    spacing: GlintSpacing = DefaultSpacing,
    shape: GlintShape = DefaultShape,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    CompositionLocalProvider(
        LocalGlintTypography provides typography,
        LocalGlintSpacing provides spacing,
        LocalGlintShape provides shape
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}
