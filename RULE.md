# Glint Design System - Rules & Standards

This document defines the coding standards, patterns, and conventions for the Glint Design System. It serves as a guide for developers and AI assistants to maintain consistency and quality across the codebase.

## 📋 Table of Contents

1. [Project Architecture](#project-architecture)
2. [Code Style Guidelines](#code-style-guidelines)
3. [Component Development Standards](#component-development-standards)
4. [Design Token Usage](#design-token-usage)
5. [Testing Standards](#testing-standards)
6. [Documentation Standards](#documentation-standards)
7. [Git Commit Standards](#git-commit-standards)

---

## Project Architecture

### Module Structure

The project follows a strict modular architecture:

```
Glint/
├── core-ui/       # Design tokens, theme system (no UI components)
├── components/    # Reusable UI components (depends on core-ui)
└── catalog/       # Demo app (depends on core-ui and components)
```

### Dependency Rules

**CRITICAL**: Follow the dependency hierarchy strictly:

- `core-ui` → **NO dependencies** on other modules (only Material3)
- `components` → Depends ONLY on `core-ui`
- `catalog` → Depends on both `core-ui` and `components`

❌ **NEVER**:
- Import components into core-ui
- Create circular dependencies
- Import catalog code into other modules

---

## Code Style Guidelines

### Kotlin Conventions

#### File Organization

```kotlin
// 1. Package declaration
package com.derayane.glint.components

// 2. Imports (grouped and sorted)
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.derayane.glint.coreui.theme.GlintTheme
import com.derayane.glint.coreui.tokens.*

// 3. Component enums/data classes
enum class ComponentSize { Small, Medium, Large }

// 4. Main composable functions
@Composable
fun ComponentName() { }

// 5. Helper/internal functions
@Composable
private fun ComponentHelper() { }

// 6. Preview functions (at the end)
@Preview
@Composable
private fun PreviewComponent() { }
```

#### Naming Conventions

- **Components**: `Glint` prefix + PascalCase → `GlintButton`, `GlintCard`, `GlintToggle`
- **Composables**: PascalCase → `CatalogScreen`, `ButtonsPreview`
- **Variables**: camelCase → `isDarkMode`, `buttonSize`, `textFieldValue`
- **Constants**: SCREAMING_SNAKE_CASE → `DEFAULT_ELEVATION`, `MAX_LENGTH`
- **Enums**: PascalCase for name, PascalCase for values → `GlintButtonSize.Small`
- **Token Objects**: `Glint` prefix + descriptor → `GlintSemanticColorsLight`, `GlintSpacing`

#### Function Parameter Order

Standard parameter order for all composables:

```kotlin
@Composable
fun GlintComponent(
    // 1. Required content/data parameters
    text: String,
    value: String,
    
    // 2. Event handlers
    onClick: () -> Unit,
    onValueChange: (String) -> Unit,
    
    // 3. Modifier (always with default)
    modifier: Modifier = Modifier,
    
    // 4. Styling/behavior parameters (with defaults)
    enabled: Boolean = true,
    size: ComponentSize = ComponentSize.Medium,
    variant: ComponentVariant = ComponentVariant.Default,
    
    // 5. Optional content slots
    leadingIcon: @Composable (() -> Unit)? = null,
    
    // 6. Advanced/rarely used parameters
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
)
```

---

## Component Development Standards

### Component Checklist

When creating a new component, ensure:

- [ ] Component name starts with `Glint` prefix
- [ ] Uses design tokens from `core-ui` (NO hardcoded values)
- [ ] Wrapped in `GlintTheme` in previews
- [ ] Has light mode preview
- [ ] Has dark mode preview
- [ ] Handles all states (enabled, disabled, focused, pressed, error)
- [ ] Has KDoc documentation
- [ ] Added to catalog app
- [ ] Follows Material Design 3 guidelines
- [ ] No direct color/size values (use theme)

### Component Template

```kotlin
package com.derayane.glint.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.derayane.glint.coreui.theme.GlintTheme

/**
 * GlintComponentName - Brief description of what this component does
 *
 * This component follows Material Design 3 guidelines and uses Glint design tokens.
 *
 * @param modifier Modifier to be applied to the component
 * @param enabled Whether the component is enabled and can be interacted with
 * @param size Size variant of the component
 *
 * @sample PreviewGlintComponentName
 */
@Composable
fun GlintComponentName(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: ComponentSize = ComponentSize.Medium
) {
    // Use GlintTheme.colorScheme for colors
    // Use GlintTheme.spacing for spacing
    // Use GlintTheme.typography for text styles
    // Use GlintTheme.shape for shapes
    
    // Implementation here
}

// ============================================
// PREVIEWS
// ============================================

@Preview(name = "ComponentName - Light", showBackground = true)
@Composable
private fun PreviewGlintComponentName() {
    GlintTheme {
        GlintComponentName()
    }
}

@Preview(name = "ComponentName - Dark", showBackground = true)
@Composable
private fun PreviewGlintComponentNameDark() {
    GlintTheme(darkTheme = true) {
        GlintComponentName()
    }
}

@Preview(name = "ComponentName - All Variants", showBackground = true)
@Composable
private fun PreviewGlintComponentNameVariants() {
    GlintTheme {
        Column(verticalArrangement = Arrangement.spacedBy(GlintTheme.spacing.md)) {
            GlintComponentName(size = ComponentSize.Small)
            GlintComponentName(size = ComponentSize.Medium)
            GlintComponentName(size = ComponentSize.Large)
            GlintComponentName(enabled = false)
        }
    }
}
```

### Component Variants Pattern

Use enums for variants:

```kotlin
enum class GlintButtonVariant {
    Filled,      // Primary filled button
    Outlined,    // Secondary outlined button
    Text         // Tertiary text button
}

enum class GlintButtonSize {
    Small,       // Compact size for tight spaces
    Medium,      // Default size for most use cases
    Large        // Prominent size for hero actions
}
```

---

## Design Token Usage

### The Golden Rule

**NEVER hardcode visual properties. ALWAYS use design tokens.**

### ❌ WRONG - Hardcoded Values

```kotlin
Box(
    modifier = Modifier
        .padding(16.dp)  // ❌ Hardcoded
        .background(Color(0xFF00D873))  // ❌ Hardcoded
) {
    Text(
        text = "Hello",
        fontSize = 14.sp,  // ❌ Hardcoded
        fontWeight = FontWeight.Bold  // ❌ Hardcoded
    )
}
```

### ✅ CORRECT - Using Tokens

```kotlin
Box(
    modifier = Modifier
        .padding(GlintTheme.spacing.md)  // ✅ Spacing token
        .background(
            color = GlintTheme.colorScheme.primary,  // ✅ Semantic color
            shape = GlintTheme.shape.md  // ✅ Shape token
        )
) {
    Text(
        text = "Hello",
        style = GlintTheme.typography.bodyMediumBold  // ✅ Typography token
    )
}
```

### Color Usage Rules

1. **Use Semantic Colors** from `MaterialTheme.colorScheme`:
   - `primary`, `secondary`, `tertiary` - for brand colors
   - `error` - for error states
   - `surface`, `background` - for containers
   - `onPrimary`, `onSurface`, etc. - for text on colored backgrounds

2. **Access via Theme**:
   ```kotlin
   // ✅ Correct
   color = GlintTheme.colorScheme.primary
   color = MaterialTheme.colorScheme.primary
   
   // ❌ Wrong - Don't use primitive colors directly
   color = GlintPrimaryPassionGreen.base
   ```

3. **Primitive Colors** are ONLY for:
   - Defining semantic colors in `GlintColors.kt`
   - Special effects that need exact color values
   - Never in components

### Spacing Usage Rules

```kotlin
// ✅ Predefined spacing tokens
padding(GlintTheme.spacing.md)
gap = GlintTheme.spacing.lg
size = GlintTheme.spacing.xl

// ✅ Component-specific spacing
padding(GlintSpacing.Component.cardPadding)

// ❌ Never hardcode
padding(16.dp)  // WRONG
```

### Typography Usage Rules

```kotlin
// ✅ Use typography tokens
Text(
    text = "Title",
    style = GlintTheme.typography.titleLargeBold
)

// ✅ Or Material3 equivalents
Text(
    text = "Body",
    style = MaterialTheme.typography.bodyLarge
)

// ❌ Never hardcode
Text(
    text = "Wrong",
    fontSize = 24.sp,
    fontWeight = FontWeight.Bold
)
```

---

## Testing Standards

### Preview Coverage

Every component must have:

1. **Basic Preview** - Default state in light mode
2. **Dark Mode Preview** - Default state in dark mode
3. **Variants Preview** - All size/style variants
4. **States Preview** - Enabled, disabled, error, focused states

### Interactive Testing in Catalog

All components must be added to the catalog app with:
- All variants displayed
- Interactive examples where applicable
- State demonstrations
- Usage examples

---

## Documentation Standards

### KDoc Requirements

Every public composable must have KDoc:

```kotlin
/**
 * GlintButton - A customizable button component following Material Design 3
 *
 * The button supports three variants (Filled, Outlined, Text) and three sizes 
 * (Small, Medium, Large). It uses Glint design tokens for consistent theming 
 * across light and dark modes.
 *
 * Usage:
 * ```
 * GlintButton(
 *     text = "Click Me",
 *     onClick = { /* action */ },
 *     variant = GlintButtonVariant.Filled,
 *     size = GlintButtonSize.Medium
 * )
 * ```
 *
 * @param text The text label to display on the button
 * @param onClick Callback invoked when the button is clicked
 * @param modifier Modifier to be applied to the button
 * @param enabled Whether the button is enabled and clickable
 * @param variant Style variant of the button (Filled, Outlined, or Text)
 * @param size Size variant of the button (Small, Medium, or Large)
 *
 * @see GlintButtonVariant for available button styles
 * @see GlintButtonSize for available sizes
 */
@Composable
fun GlintButton(...)
```

### Comment Guidelines

- Use KDoc for public APIs
- Use inline comments sparingly, only when code intent is unclear
- Prefer self-documenting code over comments
- Add comments for:
  - Complex state management logic
  - Workarounds for platform issues
  - Performance optimizations
  - Non-obvious business rules

---

## Git Commit Standards

### Commit Message Format

```
<type>(<scope>): <subject>

<body>

<footer>
```

### Types

- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation changes
- `style`: Code style changes (formatting, no logic change)
- `refactor`: Code refactoring
- `perf`: Performance improvements
- `test`: Adding or updating tests
- `chore`: Build process, tooling changes

### Examples

```bash
feat(components): add GlintToggle component for theme switching

- Created GlintToggle composable with on/off states
- Added size variants (Small, Medium, Large)
- Integrated with GlintTheme for consistent styling
- Added previews for light and dark modes

Closes #123
```

```bash
docs(readme): update design token documentation

- Added comprehensive color system explanation
- Updated component usage examples
- Fixed typos in installation section
```

```bash
fix(button): correct pressed state color in dark mode

The button was using incorrect color for pressed state in dark mode.
Changed from primaryContainer to primary variant.
```

---

## Best Practices Summary

### DO ✅

- Use `GlintTheme.colorScheme` for all colors
- Use `GlintTheme.spacing` for all spacing
- Use `GlintTheme.typography` for all text styles
- Use `GlintTheme.shape` for all shapes
- Add `Glint` prefix to all component names
- Provide default values for optional parameters
- Add comprehensive previews (light, dark, variants, states)
- Document public APIs with KDoc
- Handle all component states (enabled, disabled, error, focused)
- Follow Material Design 3 guidelines
- Keep components pure and reusable
- Use enums for variants and sizes
- Add new components to catalog app

### DON'T ❌

- Hardcode colors, spacing, sizes, or typography
- Use primitive colors directly in components (except in token definitions)
- Skip dark mode support
- Create components without previews
- Mix business logic into UI components
- Create circular module dependencies
- Import catalog code into other modules
- Use magic numbers without named constants
- Skip documentation for public APIs
- Ignore Material Design 3 guidelines
- Create stateful components without good reason

---

## Quick Reference

### Accessing Theme Values

```kotlin
// Colors
GlintTheme.colorScheme.primary
MaterialTheme.colorScheme.surface

// Spacing
GlintTheme.spacing.md
GlintTheme.spacing.xl

// Typography
GlintTheme.typography.titleLargeBold
MaterialTheme.typography.bodyLarge

// Shapes
GlintTheme.shape.sm
MaterialTheme.shapes.medium
```

### Common Patterns

```kotlin
// Standard component structure
@Composable
fun GlintComponent(
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Box(
        modifier = modifier
            .padding(GlintTheme.spacing.md)
            .background(
                color = GlintTheme.colorScheme.surface,
                shape = GlintTheme.shape.md
            )
    ) {
        Text(
            text = "Content",
            style = GlintTheme.typography.bodyMedium,
            color = GlintTheme.colorScheme.onSurface
        )
    }
}
```

---

## For AI Assistants

When helping with Glint development:

1. **ALWAYS** check existing components for patterns before creating new ones
2. **ALWAYS** use design tokens, never hardcode values
3. **ALWAYS** add both light and dark mode previews
4. **ALWAYS** follow the naming conventions (Glint prefix)
5. **ALWAYS** respect the module dependency hierarchy
6. **ALWAYS** add new components to the catalog app
7. **ALWAYS** provide KDoc documentation
8. **NEVER** use primitive colors directly in components
9. **NEVER** skip state handling (enabled, disabled, focused, error)
10. **NEVER** break the modular architecture

### Verification Checklist

Before considering a component complete, verify:

- [ ] Uses design tokens exclusively (no hardcoded values)
- [ ] Has `Glint` prefix in name
- [ ] Has KDoc documentation
- [ ] Has light mode preview
- [ ] Has dark mode preview
- [ ] Has variant previews
- [ ] Handles all states
- [ ] Added to catalog app
- [ ] Follows parameter order convention
- [ ] Respects module dependencies
- [ ] Follows Material Design 3 guidelines

---

**Last Updated**: 2026-01-07  
**Version**: 1.0.0
