package com.derayane.glint.coreui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.derayane.glint.coreui.tokens.GlintShape
import com.derayane.glint.coreui.tokens.GlintSpacing
import com.derayane.glint.coreui.tokens.GlintTypography
import com.derayane.glint.coreui.tokens.LocalGlintShape
import com.derayane.glint.coreui.tokens.LocalGlintSpacing
import com.derayane.glint.coreui.tokens.LocalGlintTypography

/**
 * Light color scheme for Glint theme
 */
private val LightColorScheme = lightColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFF6750A4),
    onPrimary = androidx.compose.ui.graphics.Color(0xFFFFFFFF),
    primaryContainer = androidx.compose.ui.graphics.Color(0xFFEADDFF),
    onPrimaryContainer = androidx.compose.ui.graphics.Color(0xFF21005D),
    
    secondary = androidx.compose.ui.graphics.Color(0xFF625B71),
    onSecondary = androidx.compose.ui.graphics.Color(0xFFFFFFFF),
    secondaryContainer = androidx.compose.ui.graphics.Color(0xFFE8DEF8),
    onSecondaryContainer = androidx.compose.ui.graphics.Color(0xFF1D192B),
    
    tertiary = androidx.compose.ui.graphics.Color(0xFF7D5260),
    onTertiary = androidx.compose.ui.graphics.Color(0xFFFFFFFF),
    tertiaryContainer = androidx.compose.ui.graphics.Color(0xFFFFD8E4),
    onTertiaryContainer = androidx.compose.ui.graphics.Color(0xFF31111D),
    
    error = androidx.compose.ui.graphics.Color(0xFFB3261E),
    onError = androidx.compose.ui.graphics.Color(0xFFFFFFFF),
    errorContainer = androidx.compose.ui.graphics.Color(0xFFF9DEDC),
    onErrorContainer = androidx.compose.ui.graphics.Color(0xFF410E0B),
    
    background = androidx.compose.ui.graphics.Color(0xFFFFFBFE),
    onBackground = androidx.compose.ui.graphics.Color(0xFF1C1B1F),
    
    surface = androidx.compose.ui.graphics.Color(0xFFFFFBFE),
    onSurface = androidx.compose.ui.graphics.Color(0xFF1C1B1F),
    surfaceVariant = androidx.compose.ui.graphics.Color(0xFFE7E0EC),
    onSurfaceVariant = androidx.compose.ui.graphics.Color(0xFF49454F),
    
    outline = androidx.compose.ui.graphics.Color(0xFF79747E),
    outlineVariant = androidx.compose.ui.graphics.Color(0xFFCAC4D0)
)

/**
 * Dark color scheme for Glint theme
 */
private val DarkColorScheme = darkColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFFD0BCFF),
    onPrimary = androidx.compose.ui.graphics.Color(0xFF381E72),
    primaryContainer = androidx.compose.ui.graphics.Color(0xFF4F378B),
    onPrimaryContainer = androidx.compose.ui.graphics.Color(0xFFEADDFF),
    
    secondary = androidx.compose.ui.graphics.Color(0xFFCCC2DC),
    onSecondary = androidx.compose.ui.graphics.Color(0xFF332D41),
    secondaryContainer = androidx.compose.ui.graphics.Color(0xFF4A4458),
    onSecondaryContainer = androidx.compose.ui.graphics.Color(0xFFE8DEF8),
    
    tertiary = androidx.compose.ui.graphics.Color(0xFFEFB8C8),
    onTertiary = androidx.compose.ui.graphics.Color(0xFF492532),
    tertiaryContainer = androidx.compose.ui.graphics.Color(0xFF633B48),
    onTertiaryContainer = androidx.compose.ui.graphics.Color(0xFFFFD8E4),
    
    error = androidx.compose.ui.graphics.Color(0xFFF2B8B5),
    onError = androidx.compose.ui.graphics.Color(0xFF601410),
    errorContainer = androidx.compose.ui.graphics.Color(0xFF8C1D18),
    onErrorContainer = androidx.compose.ui.graphics.Color(0xFFF9DEDC),
    
    background = androidx.compose.ui.graphics.Color(0xFF1C1B1F),
    onBackground = androidx.compose.ui.graphics.Color(0xFFE6E1E5),
    
    surface = androidx.compose.ui.graphics.Color(0xFF1C1B1F),
    onSurface = androidx.compose.ui.graphics.Color(0xFFE6E1E5),
    surfaceVariant = androidx.compose.ui.graphics.Color(0xFF49454F),
    onSurfaceVariant = androidx.compose.ui.graphics.Color(0xFFCAC4D0),
    
    outline = androidx.compose.ui.graphics.Color(0xFF938F99),
    outlineVariant = androidx.compose.ui.graphics.Color(0xFF49454F)
)

/**
 * Main Glint theme composable
 * Provides all Glint design tokens through CompositionLocals
 * 
 * @param darkTheme Whether to use dark theme colors
 * @param typography Custom typography tokens (optional)
 * @param spacing Custom spacing tokens (optional)
 * @param shape Custom shape tokens (optional)
 * @param content The content to be themed
 */
@Composable
fun GlintTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    typography: GlintTypography = GlintTypography(),
    spacing: GlintSpacing = GlintSpacing(),
    shape: GlintShape = GlintShape(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    
    // Provide Glint design tokens through CompositionLocals
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

/**
 * Object to access Glint design tokens throughout the app
 * Usage: GlintTheme.typography.bodyLarge, GlintTheme.spacing.md, etc.
 */
object GlintTheme {
    /**
     * Retrieves the current [GlintTypography] at the call site's position in the hierarchy.
     */
    val typography: GlintTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalGlintTypography.current
    
    /**
     * Retrieves the current [GlintSpacing] at the call site's position in the hierarchy.
     */
    val spacing: GlintSpacing
        @Composable
        @ReadOnlyComposable
        get() = LocalGlintSpacing.current
    
    /**
     * Retrieves the current [GlintShape] at the call site's position in the hierarchy.
     */
    val shape: GlintShape
        @Composable
        @ReadOnlyComposable
        get() = LocalGlintShape.current
    
    /**
     * Retrieves the current Material3 ColorScheme for colors
     * (Colors remain in MaterialTheme for now)
     */
    val colorScheme: androidx.compose.material3.ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme
}