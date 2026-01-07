# Glint Development Guide

## 📚 Table of Contents

1. [Architecture Overview](#architecture-overview)
2. [Design System](#design-system)
3. [Adding New Components](#adding-new-components)
4. [Modifying Design Tokens](#modifying-design-tokens)
5. [Testing Components](#testing-components)
6. [Build & Deployment](#build--deployment)

---

## Architecture Overview

### Module Structure

```
Glint/
├── core-ui/       # Design system tokens & theme
├── components/    # UI component implementations  
└── catalog/       # Sample app for testing
```

### Dependency Flow

```
catalog → components → core-ui
```

- **core-ui**: No external dependencies (only Material3)
- **components**: Depends on core-ui
- **catalog**: Depends on both core-ui and components

---

## Design System

### Color System Philosophy

**Primitive Colors** (`GlintPrimitiveColors`)
- Raw color values (Blue50-Blue900, etc.)
- Single source of truth
- Never used directly in components

**Semantic Colors** (`GlintSemanticColorsLight/Dark`)
- Context-aware naming (primary, error, surface, etc.)
- Used by all components
- Maps to Material3 ColorScheme

**Why this structure?**
```kotlin
// ❌ Bad - Hard to change theme
Button(colors = ButtonDefaults.buttonColors(
    containerColor = Color(0xFF2196F3)
))

// ✅ Good - Theme-aware
Button(colors = ButtonDefaults.buttonColors(
    containerColor = MaterialTheme.colorScheme.primary
))
```

### Typography Scale

Based on Material3 with custom tweaks:

| Style | Size | Usage |
|-------|------|-------|
| Display Large | 57sp | Hero sections |
| Headline Large | 32sp | Major sections |
| Title Large | 22sp | Card titles |
| Body Large | 16sp | Content text |
| Label Large | 14sp | Button text |

### Spacing System

8dp grid system:
- Base unit: 8dp
- All values are multiples of 4dp
- Semantic aliases for common use cases

### Shape System

Corner radius progression:
- Extra Small: 4dp (badges)
- Small: 8dp (buttons, chips)
- Medium: 12dp (cards, default)
- Large: 16dp (dialogs)
- Extra Large: 28dp (special elements)

---

## Adding New Components

### Step-by-Step Guide

#### 1. Create Component File

```bash
cd components/src/main/kotlin/com/derayane/glint/components/
touch GlintYourComponent.kt
```

#### 2. Component Template

```kotlin
package com.derayane.glint.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.derayane.glint.coreui.theme.GlintTheme

/**
 * GlintYourComponent - Brief description
 * 
 * @param modifier Modifier for customization
 * @param ...other parameters
 */
@Composable
fun GlintYourComponent(
    modifier: Modifier = Modifier,
    // ... other parameters
) {
    // Use MaterialTheme for theming
    // Use design tokens from core-ui
    
    // Implementation
}

// ============================================
// PREVIEWS
// ============================================

@Preview(name = "YourComponent - Light", showBackground = true)
@Composable
private fun PreviewGlintYourComponent() {
    GlintTheme {
        GlintYourComponent()
    }
}

@Preview(name = "YourComponent - Dark", showBackground = true)
@Composable
private fun PreviewGlintYourComponentDark() {
    GlintTheme(darkTheme = true) {
        GlintYourComponent()
    }
}
```

#### 3. Use Design Tokens

```kotlin
import com.derayane.glint.coreui.tokens.*

@Composable
fun GlintYourComponent() {
    Box(
        modifier = Modifier
            .padding(GlintSpacing.lg)  // ✅ Use spacing tokens
            .background(
                color = MaterialTheme.colorScheme.surface,  // ✅ Use theme colors
                shape = MaterialTheme.shapes.medium  // ✅ Use shape tokens
            )
    ) {
        Text(
            text = "Content",
            style = MaterialTheme.typography.bodyLarge  // ✅ Use typography tokens
        )
    }
}
```

#### 4. Add to Catalog

Edit `catalog/src/main/kotlin/.../MainActivity.kt`:

```kotlin
@Composable
fun CatalogScreen() {
    Column {
        // ... existing sections
        
        ComponentSection(title = "Your Component") {
            YourComponentPreview()
        }
    }
}

@Composable
fun YourComponentPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(GlintSpacing.md)
    ) {
        GlintYourComponent()
        // Add variants, states, etc.
    }
}
```

---

## Modifying Design Tokens

### Changing Colors

Edit `core-ui/src/main/kotlin/.../tokens/GlintColors.kt`:

```kotlin
// 1. Update primitive colors if needed
object GlintPrimitiveColors {
    val Blue600 = Color(0xFF1E88E5)  // Change this
}

// 2. Semantic colors automatically update
object GlintSemanticColorsLight {
    val primary = GlintPrimitiveColors.Blue600  // Uses new value
}
```

**All components automatically update!** 🎉

### Adding New Spacing

Edit `core-ui/src/main/kotlin/.../tokens/GlintSpacing.kt`:

```kotlin
object GlintSpacing {
    // Add new spacing value
    val custom: Dp = 20.dp
}

// Use in semantic naming
object GlintSemanticSpacing {
    val myUseCase: Dp = GlintSpacing.custom
}
```

### Modifying Typography

Edit `core-ui/src/main/kotlin/.../tokens/GlintTypography.kt`:

```kotlin
val GlintTypography = Typography(
    bodyLarge = TextStyle(
        fontSize = 18.sp,  // Changed from 16sp
        // ... other properties
    )
)
```

---

## Testing Components

### Preview in Android Studio

1. Open component file
2. Click "Split" or "Design" view
3. See interactive previews
4. Toggle dark mode

### Run Catalog App

```bash
# Install to connected device/emulator
./gradlew :catalog:installDebug

# Or from Android Studio
# Select "catalog" configuration → Run
```

### Manual Testing Checklist

- [ ] Light theme appearance
- [ ] Dark theme appearance
- [ ] Different screen sizes
- [ ] Enabled/disabled states
- [ ] Focus states
- [ ] Error states
- [ ] RTL layout (if applicable)
- [ ] Accessibility (screen reader)

---

## Build & Deployment

### Building Modules

```bash
# Build all modules
./gradlew build

# Build specific module
./gradlew :core-ui:build
./gradlew :components:build
./gradlew :catalog:build
```

### Publishing (Future)

To publish as library:

1. Add publishing configuration to `build.gradle.kts`
2. Configure Maven Central or private repository
3. Version management in `libs.versions.toml`

```kotlin
// In module build.gradle.kts
publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.derayane.glint"
            artifactId = "core-ui"  // or "components"
            version = "1.0.0"
            
            from(components["release"])
        }
    }
}
```

---

## Best Practices

### DO ✅

- Use MaterialTheme for all theming
- Use design tokens from core-ui
- Add preview functions for all composables
- Document component parameters
- Handle all states (enabled, disabled, error, etc.)
- Support dark mode
- Follow Material Design 3 guidelines

### DON'T ❌

- Hard-code colors, sizes, or spacing
- Use primitive colors directly in components
- Skip preview functions
- Ignore dark mode
- Break modular dependency chain
- Use non-Material3 components without good reason

---

## Common Tasks

### Adding a New Color

1. Add to `GlintPrimitiveColors` if it's a raw color
2. Add semantic mapping in `GlintSemanticColorsLight/Dark`
3. Use via `MaterialTheme.colorScheme.yourColor`

### Changing Component Default Size

1. Locate component file
2. Find internal size calculation function
3. Update default values
4. Test in catalog app

### Supporting New Theme Variant

1. Create new color scheme in `GlintColors.kt`
2. Add logic in `GlintTheme.kt` to apply it
3. Test all components with new theme

---

## Troubleshooting

### Components not picking up theme

**Solution**: Ensure component is wrapped in `GlintTheme`:

```kotlin
GlintTheme {
    YourComponent()  // Now themed!
}
```

### Build errors after adding dependency

**Solution**: Sync Gradle and clean build:

```bash
./gradlew clean build
```

### Preview not showing

**Solution**: 
1. Check `@Preview` annotation is present
2. Ensure function is wrapped in `GlintTheme`
3. Rebuild project

---

## Contributing

1. Follow existing code style
2. Add comprehensive previews
3. Document all public APIs
4. Test in catalog app
5. Ensure dark mode support
6. Update this guide if needed

---

## Resources

- [Material Design 3](https://m3.material.io/)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Kotlin Style Guide](https://developer.android.com/kotlin/style-guide)

---

**Happy coding with Glint! 🚀**
