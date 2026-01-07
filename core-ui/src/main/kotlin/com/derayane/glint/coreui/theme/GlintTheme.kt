package com.derayane.glint.coreui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import com.derayane.glint.coreui.tokens.GlintLightColorScheme
import com.derayane.glint.coreui.tokens.GlintDarkColorScheme

private val LightColorScheme = lightColorScheme(
    primary = GlintLightColorScheme.Primary,
    onPrimary = GlintLightColorScheme.OnPrimary,
    primaryContainer = GlintLightColorScheme.PrimaryContainer,
    onPrimaryContainer = GlintLightColorScheme.OnPrimaryContainer,
    secondary = GlintLightColorScheme.Secondary,
    onSecondary = GlintLightColorScheme.OnSecondary,
    secondaryContainer = GlintLightColorScheme.SecondaryContainer,
    onSecondaryContainer = GlintLightColorScheme.OnSecondaryContainer,
    tertiary = GlintLightColorScheme.Tertiary,
    onTertiary = GlintLightColorScheme.OnTertiary,
    tertiaryContainer = GlintLightColorScheme.TertiaryContainer,
    onTertiaryContainer = GlintLightColorScheme.OnTertiaryContainer,
    error = GlintLightColorScheme.Error,
    onError = GlintLightColorScheme.OnError,
    errorContainer = GlintLightColorScheme.ErrorContainer,
    onErrorContainer = GlintLightColorScheme.OnErrorContainer,
    background = GlintLightColorScheme.Background,
    onBackground = GlintLightColorScheme.OnBackground,
    surface = GlintLightColorScheme.Surface,
    onSurface = GlintLightColorScheme.OnSurface,
    surfaceVariant = GlintLightColorScheme.SurfaceVariant,
    onSurfaceVariant = GlintLightColorScheme.OnSurfaceVariant,
    outline = GlintLightColorScheme.Outline,
    outlineVariant = GlintLightColorScheme.OutlineVariant,
    scrim = GlintLightColorScheme.Scrim,
    inverseSurface = GlintLightColorScheme.InverseSurface,
    inverseOnSurface = GlintLightColorScheme.InverseOnSurface,
    inversePrimary = GlintLightColorScheme.InversePrimary,
    surfaceDim = GlintLightColorScheme.SurfaceDim,
    surfaceBright = GlintLightColorScheme.SurfaceBright,
    surfaceContainerLowest = GlintLightColorScheme.SurfaceContainerLowest,
    surfaceContainerLow = GlintLightColorScheme.SurfaceContainerLow,
    surfaceContainer = GlintLightColorScheme.SurfaceContainer,
    surfaceContainerHigh = GlintLightColorScheme.SurfaceContainerHigh,
    surfaceContainerHighest = GlintLightColorScheme.SurfaceContainerHighest,
)

private val DarkColorScheme = darkColorScheme(
    primary = GlintDarkColorScheme.Primary,
    onPrimary = GlintDarkColorScheme.OnPrimary,
    primaryContainer = GlintDarkColorScheme.PrimaryContainer,
    onPrimaryContainer = GlintDarkColorScheme.OnPrimaryContainer,
    secondary = GlintDarkColorScheme.Secondary,
    onSecondary = GlintDarkColorScheme.OnSecondary,
    secondaryContainer = GlintDarkColorScheme.SecondaryContainer,
    onSecondaryContainer = GlintDarkColorScheme.OnSecondaryContainer,
    tertiary = GlintDarkColorScheme.Tertiary,
    onTertiary = GlintDarkColorScheme.OnTertiary,
    tertiaryContainer = GlintDarkColorScheme.TertiaryContainer,
    onTertiaryContainer = GlintDarkColorScheme.OnTertiaryContainer,
    error = GlintDarkColorScheme.Error,
    onError = GlintDarkColorScheme.OnError,
    errorContainer = GlintDarkColorScheme.ErrorContainer,
    onErrorContainer = GlintDarkColorScheme.OnErrorContainer,
    background = GlintDarkColorScheme.Background,
    onBackground = GlintDarkColorScheme.OnBackground,
    surface = GlintDarkColorScheme.Surface,
    onSurface = GlintDarkColorScheme.OnSurface,
    surfaceVariant = GlintDarkColorScheme.SurfaceVariant,
    onSurfaceVariant = GlintDarkColorScheme.OnSurfaceVariant,
    outline = GlintDarkColorScheme.Outline,
    outlineVariant = GlintDarkColorScheme.OutlineVariant,
    scrim = GlintDarkColorScheme.Scrim,
    inverseSurface = GlintDarkColorScheme.InverseSurface,
    inverseOnSurface = GlintDarkColorScheme.InverseOnSurface,
    inversePrimary = GlintDarkColorScheme.InversePrimary,
    surfaceDim = GlintDarkColorScheme.SurfaceDim,
    surfaceBright = GlintDarkColorScheme.SurfaceBright,
    surfaceContainerLowest = GlintDarkColorScheme.SurfaceContainerLowest,
    surfaceContainerLow = GlintDarkColorScheme.SurfaceContainerLow,
    surfaceContainer = GlintDarkColorScheme.SurfaceContainer,
    surfaceContainerHigh = GlintDarkColorScheme.SurfaceContainerHigh,
    surfaceContainerHighest = GlintDarkColorScheme.SurfaceContainerHighest,
)

@Composable
fun GlintTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = GlintTypography,
        content = content
    )
}
