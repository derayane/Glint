package com.derayane.glint.coreui.tokens

import androidx.compose.ui.graphics.Color

/**
 * GlintColors - Design Token untuk Color System
 * 
 * Struktur:
 * 1. Primitive Colors: Warna dasar yang tidak berubah
 * 2. Semantic Colors: Warna dengan konteks penggunaan spesifik
 * 
 * Alasan pemilihan struktur:
 * - Primitive colors memberikan single source of truth untuk warna mentah
 * - Semantic colors memudahkan perubahan tema tanpa mengubah komponen
 * - Memisahkan intent dari implementasi, memudahkan rebrand di masa depan
 */

// ============================================
// PRIMITIVE COLORS - Raw color palette
// ============================================
object GlintPrimitiveColors {
    // Primary Palette - Brand colors
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

    // Secondary Palette - Complementary colors
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

    // Neutral Palette - Grays
    val Gray50 = Color(0xFFFAFAFA)
    val Gray100 = Color(0xFFF5F5F5)
    val Gray200 = Color(0xFFEEEEEE)
    val Gray300 = Color(0xFFE0E0E0)
    val Gray400 = Color(0xFFBDBDBD)
    val Gray500 = Color(0xFF9E9E9E)
    val Gray600 = Color(0xFF757575)
    val Gray700 = Color(0xFF616161)
    val Gray800 = Color(0xFF424242)
    val Gray900 = Color(0xFF212121)

    // Semantic base colors
    val White = Color(0xFFFFFFFF)
    val Black = Color(0xFF000000)

    // System colors
    val Success = Color(0xFF4CAF50)
    val Warning = Color(0xFFFF9800)
    val Error = Color(0xFFF44336)
    val Info = Color(0xFF2196F3)
}

// ============================================
// SEMANTIC COLORS - Contextual colors
// ============================================

/**
 * Semantic Light Color Scheme
 * Digunakan untuk Light Mode dengan konteks yang jelas
 */
object GlintSemanticColorsLight {
    // Primary colors - Untuk aksi utama
    val primary = GlintPrimitiveColors.Blue600
    val onPrimary = GlintPrimitiveColors.White
    val primaryContainer = GlintPrimitiveColors.Blue100
    val onPrimaryContainer = GlintPrimitiveColors.Blue900

    // Secondary colors - Untuk aksi sekunder
    val secondary = GlintPrimitiveColors.Purple600
    val onSecondary = GlintPrimitiveColors.White
    val secondaryContainer = GlintPrimitiveColors.Purple100
    val onSecondaryContainer = GlintPrimitiveColors.Purple900

    // Tertiary colors - Untuk aksi tersier
    val tertiary = GlintPrimitiveColors.Blue400
    val onTertiary = GlintPrimitiveColors.White
    val tertiaryContainer = GlintPrimitiveColors.Blue50
    val onTertiaryContainer = GlintPrimitiveColors.Blue800

    // Error colors - Untuk state error
    val error = GlintPrimitiveColors.Error
    val onError = GlintPrimitiveColors.White
    val errorContainer = Color(0xFFFFDAD6)
    val onErrorContainer = Color(0xFF410002)

    // Background colors - Untuk background utama
    val background = GlintPrimitiveColors.Gray50
    val onBackground = GlintPrimitiveColors.Gray900

    // Surface colors - Untuk kartu dan elevasi
    val surface = GlintPrimitiveColors.White
    val onSurface = GlintPrimitiveColors.Gray900
    val surfaceVariant = GlintPrimitiveColors.Gray100
    val onSurfaceVariant = GlintPrimitiveColors.Gray700

    // Outline - Untuk border
    val outline = GlintPrimitiveColors.Gray400
    val outlineVariant = GlintPrimitiveColors.Gray300

    // Inverse colors - Untuk komponen inverse
    val inverseSurface = GlintPrimitiveColors.Gray800
    val inverseOnSurface = GlintPrimitiveColors.Gray50
    val inversePrimary = GlintPrimitiveColors.Blue300

    // Scrim - Untuk overlay
    val scrim = GlintPrimitiveColors.Black
}

/**
 * Semantic Dark Color Scheme
 * Digunakan untuk Dark Mode dengan konteks yang jelas
 */
object GlintSemanticColorsDark {
    // Primary colors - Untuk aksi utama
    val primary = GlintPrimitiveColors.Blue300
    val onPrimary = GlintPrimitiveColors.Blue900
    val primaryContainer = GlintPrimitiveColors.Blue700
    val onPrimaryContainer = GlintPrimitiveColors.Blue100

    // Secondary colors - Untuk aksi sekunder
    val secondary = GlintPrimitiveColors.Purple300
    val onSecondary = GlintPrimitiveColors.Purple900
    val secondaryContainer = GlintPrimitiveColors.Purple700
    val onSecondaryContainer = GlintPrimitiveColors.Purple100

    // Tertiary colors - Untuk aksi tersier
    val tertiary = GlintPrimitiveColors.Blue200
    val onTertiary = GlintPrimitiveColors.Blue800
    val tertiaryContainer = GlintPrimitiveColors.Blue600
    val onTertiaryContainer = GlintPrimitiveColors.Blue50

    // Error colors - Untuk state error
    val error = Color(0xFFFFB4AB)
    val onError = Color(0xFF690005)
    val errorContainer = Color(0xFF93000A)
    val onErrorContainer = Color(0xFFFFDAD6)

    // Background colors - Untuk background utama
    val background = GlintPrimitiveColors.Gray900
    val onBackground = GlintPrimitiveColors.Gray100

    // Surface colors - Untuk kartu dan elevasi
    val surface = GlintPrimitiveColors.Gray900
    val onSurface = GlintPrimitiveColors.Gray100
    val surfaceVariant = GlintPrimitiveColors.Gray800
    val onSurfaceVariant = GlintPrimitiveColors.Gray400

    // Outline - Untuk border
    val outline = GlintPrimitiveColors.Gray600
    val outlineVariant = GlintPrimitiveColors.Gray700

    // Inverse colors - Untuk komponen inverse
    val inverseSurface = GlintPrimitiveColors.Gray100
    val inverseOnSurface = GlintPrimitiveColors.Gray900
    val inversePrimary = GlintPrimitiveColors.Blue600

    // Scrim - Untuk overlay
    val scrim = GlintPrimitiveColors.Black
}
