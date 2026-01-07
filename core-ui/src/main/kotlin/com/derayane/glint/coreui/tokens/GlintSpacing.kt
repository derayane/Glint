package com.derayane.glint.coreui.tokens

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * GlintSpacing - Design Token untuk Spacing System
 * 
 * Menggunakan 8dp grid system sebagai base unit untuk konsistensi:
 * - Semua spacing merupakan kelipatan dari 4dp
 * - Memberikan rhythm dan balance yang konsisten
 * - Memudahkan alignment dalam layout kompleks
 * 
 * Alasan pemilihan:
 * - 8dp grid adalah standar industri yang proven
 * - Mudah di-scale untuk berbagai screen sizes
 * - Memberikan spacing yang visual balance
 */
object GlintSpacing {
    /**
     * None - 0dp
     * Digunakan ketika tidak ada spacing
     */
    val none: Dp = 0.dp

    /**
     * Extra Extra Small - 2dp
     * Digunakan untuk spacing sangat kecil, seperti internal padding icon
     */
    val xxs: Dp = 2.dp

    /**
     * Extra Small - 4dp
     * Digunakan untuk spacing sangat kecil antara elemen terkait erat
     */
    val xs: Dp = 4.dp

    /**
     * Small - 8dp (1 unit)
     * Spacing dasar, digunakan untuk padding internal komponen kecil
     */
    val sm: Dp = 8.dp

    /**
     * Medium - 12dp (1.5 unit)
     * Digunakan untuk spacing sedang antara elemen
     */
    val md: Dp = 12.dp

    /**
     * Large - 16dp (2 unit)
     * Standard spacing untuk padding dan margin komponen
     */
    val lg: Dp = 16.dp

    /**
     * Extra Large - 24dp (3 unit)
     * Digunakan untuk spacing besar antara section
     */
    val xl: Dp = 24.dp

    /**
     * Extra Extra Large - 32dp (4 unit)
     * Digunakan untuk spacing sangat besar, seperti antar major sections
     */
    val xxl: Dp = 32.dp

    /**
     * Extra Extra Extra Large - 48dp (6 unit)
     * Digunakan untuk spacing maximum, seperti padding container utama
     */
    val xxxl: Dp = 48.dp

    /**
     * Huge - 64dp (8 unit)
     * Digunakan untuk spacing hero section atau spacing special
     */
    val huge: Dp = 64.dp
}

/**
 * Semantic spacing values untuk use case spesifik
 * Memberikan naming yang lebih contextual
 */
object GlintSemanticSpacing {
    /**
     * Component Internal Padding
     */
    val componentPaddingSmall: Dp = GlintSpacing.sm
    val componentPaddingMedium: Dp = GlintSpacing.md
    val componentPaddingLarge: Dp = GlintSpacing.lg

    /**
     * Content Spacing - spacing antara content elements
     */
    val contentSpacingTight: Dp = GlintSpacing.xs
    val contentSpacingNormal: Dp = GlintSpacing.sm
    val contentSpacingRelaxed: Dp = GlintSpacing.md
    val contentSpacingLoose: Dp = GlintSpacing.lg

    /**
     * Layout Spacing - spacing untuk layout containers
     */
    val layoutMarginHorizontal: Dp = GlintSpacing.lg
    val layoutMarginVertical: Dp = GlintSpacing.lg
    val layoutGutterSmall: Dp = GlintSpacing.md
    val layoutGutterMedium: Dp = GlintSpacing.lg
    val layoutGutterLarge: Dp = GlintSpacing.xl

    /**
     * Screen Padding - padding untuk full screen
     */
    val screenPaddingHorizontal: Dp = GlintSpacing.lg
    val screenPaddingVertical: Dp = GlintSpacing.lg
    val screenPaddingTop: Dp = GlintSpacing.xl
    val screenPaddingBottom: Dp = GlintSpacing.xl

    /**
     * Card Spacing
     */
    val cardPadding: Dp = GlintSpacing.lg
    val cardContentSpacing: Dp = GlintSpacing.md
    val cardGutter: Dp = GlintSpacing.md

    /**
     * Button Spacing
     */
    val buttonPaddingHorizontal: Dp = GlintSpacing.lg
    val buttonPaddingVertical: Dp = GlintSpacing.md
    val buttonIconSpacing: Dp = GlintSpacing.sm

    /**
     * TextField Spacing
     */
    val textFieldPaddingHorizontal: Dp = GlintSpacing.lg
    val textFieldPaddingVertical: Dp = GlintSpacing.md
    val textFieldHelperTextSpacing: Dp = GlintSpacing.xs
}
