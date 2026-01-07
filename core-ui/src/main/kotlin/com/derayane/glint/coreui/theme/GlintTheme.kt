package com.derayane.glint.coreui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.derayane.glint.coreui.tokens.*

/**
 * GlintTheme - Theme Wrapper untuk Glint Design System
 * 
 * Fungsi:
 * - Override MaterialTheme dengan custom tokens Glint
 * - Menerapkan color scheme, typography, dan shapes custom
 * - Mendukung dark mode otomatis
 * - Mengatur system bar colors sesuai theme
 * 
 * Keuntungan:
 * - Semua Material 3 components otomatis mengikuti styling Glint
 * - Centralized theming - ubah di satu tempat, apply ke semua komponen
 * - Konsistensi terjamin di seluruh aplikasi
 * - Easy maintenance dan rebrand
 */

/**
 * Light Color Scheme menggunakan Glint Semantic Colors
 */
private val GlintLightColorScheme = lightColorScheme(
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
    
    inverseSurface = GlintSemanticColorsLight.inverseSurface,
    inverseOnSurface = GlintSemanticColorsLight.inverseOnSurface,
    inversePrimary = GlintSemanticColorsLight.inversePrimary,
    
    scrim = GlintSemanticColorsLight.scrim,
)

/**
 * Dark Color Scheme menggunakan Glint Semantic Colors
 */
private val GlintDarkColorScheme = darkColorScheme(
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
    
    inverseSurface = GlintSemanticColorsDark.inverseSurface,
    inverseOnSurface = GlintSemanticColorsDark.inverseOnSurface,
    inversePrimary = GlintSemanticColorsDark.inversePrimary,
    
    scrim = GlintSemanticColorsDark.scrim,
)

/**
 * GlintTheme Composable
 * 
 * Main theme wrapper yang harus dibungkus di root aplikasi
 * 
 * @param darkTheme Boolean untuk menggunakan dark theme. Default mengikuti system.
 * @param dynamicColor Boolean untuk menggunakan dynamic color (Android 12+). Default false.
 * @param content Composable content yang akan di-theme
 * 
 * Contoh penggunaan:
 * ```
 * @Composable
 * fun MyApp() {
 *     GlintTheme {
 *         // Your app content here
 *         Surface {
 *             Text("Hello Glint!")
 *         }
 *     }
 * }
 * ```
 */
@Composable
fun GlintTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    // Pilih color scheme berdasarkan theme
    val colorScheme = when {
        darkTheme -> GlintDarkColorScheme
        else -> GlintLightColorScheme
    }

    // Update system bar colors
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    // Apply MaterialTheme dengan custom tokens
    MaterialTheme(
        colorScheme = colorScheme,
        typography = GlintTypography,
        shapes = GlintShapes,
        content = content
    )
}
