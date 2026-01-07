# Glint - UI Component Library

<div align="center">

**A Modern Android UI Component Library based on Material Design 3**

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.20-blue.svg)](https://kotlinlang.org)
[![Material3](https://img.shields.io/badge/Material%203-1.1.2-green.svg)](https://m3.material.io/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-1.5.4-blue.svg)](https://developer.android.com/jetpack/compose)

</div>

---

## 📖 Overview

Glint adalah UI Component Library untuk Android yang dibangun dengan **Kotlin** dan **Jetpack Compose**, mengikuti prinsip **Material Design 3**. Library ini menyediakan komponen-komponen yang sudah di-styling dengan Design Tokens yang scalable dan customizable.

### 🎯 Key Features

- ✅ **Design Tokens**: Scalable design system dengan Primitive & Semantic colors
- ✅ **Material 3 Based**: Semua komponen mengikuti Material Design 3 guidelines
- ✅ **Modular Architecture**: Struktur modular yang maintainable
- ✅ **Type-Safe**: Full Kotlin implementation dengan type safety
- ✅ **Dark Mode Support**: Built-in support untuk light & dark themes dengan toggle
- ✅ **Preview Catalog**: Sample app untuk preview semua komponen
- ✅ **Comprehensive Documentation**: Complete rules and standards in RULE.md

---

## 🏗️ Information Architecture

### Project Structure

```
Glint/
├── core-ui/              # Design Tokens & Theme System
│   └── src/main/kotlin/com/derayane/glint/coreui/
│       ├── tokens/
│       │   ├── GlintColors.kt       # Color system (Primitive & Semantic)
│       │   ├── GlintTypography.kt   # Typography scale & styles
│       │   ├── GlintSpacing.kt      # Spacing system (4dp grid)
│       │   ├── GlintShape.kt        # Shape definitions & corner radius
│       │   └── GlintComponents.kt   # Component-specific tokens
│       └── theme/
│           └── GlintTheme.kt        # MaterialTheme wrapper & composition locals
│
├── components/           # Reusable UI Components
│   └── src/main/kotlin/com/derayane/glint/components/
│       ├── GlintButton.kt           # Button (Filled, Outlined, Text)
│       ├── GlintTextField.kt        # TextField with custom styling
│       ├── GlintCard.kt             # Card with elevation levels
│       └── GlintToggle.kt           # Toggle/Switch for binary states
│
├── catalog/              # Demo & Testing App
│   └── src/main/kotlin/com/derayane/glint/catalog/
│       └── MainActivity.kt          # Interactive component showcase
│
├── RULE.md               # Coding standards, patterns & conventions
├── DEVELOPMENT_GUIDE.md  # Development workflow & best practices
└── README.md             # This file
```

### Module Dependency Graph

```
catalog → components → core-ui
```

**IMPORTANT**: Strictly follow this dependency hierarchy:
- `core-ui`: No dependencies on other modules (only Material3)
- `components`: Depends ONLY on `core-ui`
- `catalog`: Depends on both `core-ui` and `components`

---

## 🚀 Getting Started

### Prerequisites

- Android Studio Hedgehog | 2023.1.1 or newer
- Minimum SDK: 24
- Target SDK: 34
- Kotlin: 1.9.20
- Gradle: 8.2.0

### Installation

1. Clone repository ini:
```bash
git clone https://github.com/derayane/Glint.git
cd Glint
```

2. Open project di Android Studio

3. Sync project dengan Gradle

4. Run `catalog` module untuk melihat preview komponen

---

## 💡 Usage

### Setup Theme

Wrap aplikasi Anda dengan `GlintTheme` untuk enable design system:

```kotlin
@Composable
fun MyApp() {
    // Basic setup
    GlintTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            // Your app content here
        }
    }
}

// With dark mode toggle
@Composable
fun MyApp() {
    var isDarkMode by remember { mutableStateOf(false) }
    
    GlintTheme(darkTheme = isDarkMode) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            // Add toggle in your UI
            GlintToggle(
                checked = isDarkMode,
                onCheckedChange = { isDarkMode = it }
            )
            
            // Your app content
        }
    }
}

// With system theme
@Composable
fun MyApp() {
    val isDarkMode = isSystemInDarkTheme()
    
    GlintTheme(darkTheme = isDarkMode) {
        // Content automatically follows system theme
    }
}
```

### Accessing Design Tokens

```kotlin
@Composable
fun MyCustomComponent() {
    Box(
        modifier = Modifier
            // Use spacing tokens
            .padding(GlintTheme.spacing.md)
            .background(
                // Use color tokens
                color = GlintTheme.colorScheme.surface,
                // Use shape tokens
                shape = GlintTheme.shape.md
            )
    ) {
        Text(
            text = "Content",
            // Use typography tokens
            style = GlintTheme.typography.bodyMedium,
            color = GlintTheme.colorScheme.onSurface
        )
    }
}
```

### Using Components

#### Complete Example

```kotlin
@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }
    var isError by remember { mutableStateOf(false) }
    
    GlintTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(GlintTheme.spacing.lg),
            verticalArrangement = Arrangement.spacedBy(GlintTheme.spacing.md)
        ) {
            Text(
                text = "Welcome Back",
                style = GlintTheme.typography.headlineLarge
            )
            
            GlintTextField(
                value = email,
                onValueChange = { email = it },
                label = "Email",
                placeholder = "Enter your email",
                isError = isError,
                errorMessage = if (isError) "Invalid email" else null
            )
            
            GlintTextField(
                value = password,
                onValueChange = { password = it },
                label = "Password",
                placeholder = "Enter your password"
            )
            
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(GlintTheme.spacing.sm)
            ) {
                GlintToggle(
                    checked = rememberMe,
                    onCheckedChange = { rememberMe = it },
                    size = GlintToggleSize.Small
                )
                Text(
                    text = "Remember me",
                    style = GlintTheme.typography.bodyMedium
                )
            }
            
            GlintPrimaryButton(
                text = "Login",
                onClick = { /* Handle login */ },
                modifier = Modifier.fillMaxWidth()
            )
            
            GlintTextButton(
                text = "Forgot password?",
                onClick = { /* Handle forgot password */ },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
```

#### Buttons

```kotlin
// Primary Button - Main actions
GlintPrimaryButton(
    text = "Continue",
    onClick = { /* Handle click */ },
    size = GlintButtonSize.Medium
)

// Secondary Button - Alternative actions
GlintSecondaryButton(
    text = "Cancel",
    onClick = { /* Handle click */ }
)

// Text Button - Tertiary actions
GlintTextButton(
    text = "Learn More",
    onClick = { /* Handle click */ }
)

// Disabled state
GlintPrimaryButton(
    text = "Submit",
    onClick = { },
    enabled = false
)

// Different sizes
GlintPrimaryButton(text = "Small", onClick = {}, size = GlintButtonSize.Small)
GlintPrimaryButton(text = "Medium", onClick = {}, size = GlintButtonSize.Medium)
GlintPrimaryButton(text = "Large", onClick = {}, size = GlintButtonSize.Large)
```

#### Text Fields

```kotlin
var text by remember { mutableStateOf("") }

// Basic TextField
GlintTextField(
    value = text,
    onValueChange = { text = it },
    label = "Email",
    placeholder = "Enter your email",
    helperText = "We'll never share your email"
)

// With error state
GlintTextField(
    value = text,
    onValueChange = { text = it },
    label = "Email",
    errorMessage = "Invalid email address",
    isError = true
)

// Multiline TextField
GlintTextField(
    value = text,
    onValueChange = { text = it },
    label = "Description",
    placeholder = "Enter description",
    singleLine = false,
    maxLines = 4
)

// Disabled TextField
GlintTextField(
    value = "Readonly text",
    onValueChange = {},
    label = "Username",
    enabled = false
)
```

#### Cards

```kotlin
// Basic Card
GlintCard {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Card Title", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Card content goes here")
    }
}

// Clickable Card
var clickCount by remember { mutableStateOf(0) }
GlintCard(
    onClick = { clickCount++ },
    elevation = GlintCardElevation.MEDIUM
) {
    Text("Clicked $clickCount times")
}

// Different elevations
GlintCard(elevation = GlintCardElevation.LOW) {
    Text("Low elevation (2dp)")
}

GlintCard(elevation = GlintCardElevation.MEDIUM) {
    Text("Medium elevation (4dp)")
}

GlintCard(elevation = GlintCardElevation.HIGH) {
    Text("High elevation (8dp)")
}
```

#### Toggles

```kotlin
var isEnabled by remember { mutableStateOf(false) }

// Basic Toggle
GlintToggle(
    checked = isEnabled,
    onCheckedChange = { isEnabled = it }
)

// Different sizes
GlintToggle(
    checked = isEnabled,
    onCheckedChange = { isEnabled = it },
    size = GlintToggleSize.Small
)

GlintToggle(
    checked = isEnabled,
    onCheckedChange = { isEnabled = it },
    size = GlintToggleSize.Large
)

// In a settings row
Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
) {
    Column {
        Text("Dark Mode")
        Text("Toggle theme", style = MaterialTheme.typography.bodySmall)
    }
    GlintToggle(
        checked = isDarkMode,
        onCheckedChange = { isDarkMode = it }
    )
}

// Disabled state
GlintToggle(
    checked = true,
    onCheckedChange = {},
    enabled = false
)
```

---

## 🎨 Design System

### Design Token Philosophy

Glint menggunakan **token-based design system** untuk memastikan konsistensi visual dan kemudahan maintenance:

```
Primitive Tokens → Semantic Tokens → Component Usage
```

**Benefits:**
- Single source of truth untuk semua nilai visual
- Easy theming dan rebranding
- Automatic dark mode support
- Type-safe dengan Kotlin
- Compile-time validation

### Color System

#### Primitive Colors (Foundation)

Raw color palette yang menjadi foundation dari design system:

**Primary Colors:**
- **Passion Green**: `#00D873` - Main brand color dengan tints & shades (minus70 - plus70)
- **Irish Green**: `#00D771` - Secondary brand dengan full scale
- **Emerald Green**: `#00B771` - Tertiary brand dengan full scale

**Secondary Colors:**
- **Crimson Red**: `#D83A2F` - Error & destructive actions
- **Pumpkin Orange**: `#FF9E00` - Warning states
- **Butter Yellow**: `#FFEB00` - Caution states
- **Hazel Gold**: `#FFB000` - Success alternative
- **Teal Green**: `#00D4B7` - Info states
- **Ocean Blue**: `#2585D8` - Informational elements

**Neutral Colors:**
- **Greyscale (Jet Black)**: `#000000` base dengan full scale (minus90 - plus0)
- **Text Colors**: Primary (`#323234`), Secondary (`#646467`), Tertiary (`#B1B1B3`)
- **Background Colors**: White, Background, Component Background, Foreground, Disabled

#### Semantic Colors (Context-Aware)

Colors dengan konteks penggunaan spesifik yang map ke Material3 ColorScheme:

**Light Mode:**
- `primary`: Passion Green base - Aksi utama & brand
- `secondary`: Irish Green base - Aksi sekunder
- `tertiary`: Emerald Green base - Aksi tersier
- `error`: Crimson Red - Error states
- `background`: Neutral background - Screen background
- `surface`: White - Card & component surfaces
- `outline`: Foreground - Borders & dividers

**Dark Mode:**
- `primary`: Passion Green minus30 - Accessible on dark backgrounds
- `secondary`: Irish Green minus30 - Secondary actions
- `tertiary`: Emerald Green minus30 - Tertiary actions
- `error`: Crimson Red minus30 - Error states
- `background`: Jet Black minus10 - Dark screen background
- `surface`: Jet Black minus10 - Dark surfaces
- `outline`: Jet Black minus40 - Dark borders

**Why Semantic Naming?**
1. **Flexibility**: Mudah mengubah tema tanpa mengubah komponen
2. **Context**: Memberikan meaning yang jelas untuk setiap warna
3. **Maintainability**: Memisahkan intent dari implementasi
4. **Scalability**: Memudahkan rebrand atau theme variants

#### Usage in Code

```kotlin
// ✅ CORRECT - Use semantic colors
Box(
    modifier = Modifier.background(
        color = GlintTheme.colorScheme.primary
    )
)

// ❌ WRONG - Don't use primitive colors directly
Box(
    modifier = Modifier.background(
        color = GlintPrimaryPassionGreen.base  // WRONG!
    )
)
```

### Typography System

#### Typography Scale

Based on Material3 with custom font weights and line heights:

| Category | Style | Size | Line Height | Weight | Usage |
|----------|-------|------|-------------|--------|-------|
| **Headline** | Extra Large | 56sp | 78sp | Bold (700) | Hero sections, landing pages |
| | Large | 40sp | 44sp | Bold (700) | Major page headers |
| | Medium Bold | 32sp | 38sp | Bold (700) | Section headers |
| | Medium | 32sp | 38sp | Regular (400) | Alternative headers |
| **Title** | Large Bold | 24sp | 36sp | Bold (700) | Card titles, dialog headers |
| | Large | 24sp | 36sp | SemiBold (600) | Standard card titles |
| | Medium Bold | 18sp | 26sp | Bold (700) | Subsection headers |
| | Medium | 18sp | 26sp | SemiBold (600) | List headers |
| | Small Bold | 16sp | 24sp | Bold (700) | Small headers |
| | Small | 16sp | 24sp | SemiBold (600) | Compact headers |
| **Body** | Medium Bold | 14sp | 20sp | Bold (700) | Emphasized body text |
| | Medium | 14sp | 20sp | SemiBold (600) | Standard body text |
| | Small Bold | 12sp | 18sp | Bold (700) | Captions, emphasized |
| | Small | 12sp | 18sp | SemiBold (600) | Captions, metadata |
| **Label** | Large | 12sp | 18sp | SemiBold (600) | Button text, UI labels |

#### Usage in Code

```kotlin
Text(
    text = "Title",
    style = GlintTheme.typography.titleLargeBold
)

Text(
    text = "Body content",
    style = GlintTheme.typography.bodyMedium
)
```

### Spacing System

#### 4dp Grid System

All spacing values follow a 4dp base grid for visual consistency:

| Token | Value | Usage |
|-------|-------|-------|
| `none` | 0dp | No spacing |
| `xxs` | 2dp | Minimal gaps, icon padding |
| `xs` | 4dp | Extra small spacing |
| `sm` | 8dp | Small spacing (1 grid unit) |
| `smPlus` | 12dp | Small+ spacing |
| `md` | 16dp | Medium spacing (2 grid units) |
| `mdPlus` | 20dp | Medium+ spacing |
| `lg` | 24dp | Large spacing (3 grid units) |
| `lgPlus` | 28dp | Large+ spacing |
| `xl` | 32dp | Extra large (4 grid units) |
| `xlPlus` | 36dp | Extra large+ |
| `xxl` | 40dp | 2X large (5 grid units) |
| `xxlPlus` | 48dp | 2X large+ (6 grid units) |
| `xxxl` | 56dp | 3X large (7 grid units) |
| `xxxlPlus` | 64dp | 3X large+ (8 grid units) |
| `xxxxl` | 72dp | 4X large (9 grid units) |
| `xxxxxl` | 80dp | 4X large+ (10 grid units) |

#### Component-Specific Spacing

```kotlin
GlintSpacing.Component {
    buttonHorizontalPadding = 24.dp
    buttonVerticalPadding = 12.dp
    cardPadding = 16.dp
    screenHorizontalPadding = 16.dp
    // ... and more
}
```

### Shape System

#### Corner Radius Scale

Progressive corner radius values for different component types:

| Token | Value | Usage |
|-------|-------|-------|
| `none` | 0dp | Square corners |
| `xxs` | 2dp | Minimal rounding |
| `xs` | 4dp | Badges, small chips |
| `sm` | 8dp | Buttons, chips |
| `smPlus` | 10dp | Button variations |
| `md` | 12dp | Cards, text fields (default) |
| `mdPlus` | 14dp | Card variations |
| `lg` | 16dp | Bottom sheets, elevated cards |
| `lgPlus` | 20dp | Large containers |
| `xl` | 24dp | Dialogs |
| `xlPlus` | 28dp | Modal dialogs |
| `xxl` | 32dp | Special containers |
| `xxlPlus` | 36dp | Extra special elements |
| `full` | 50% | Circular/pill shapes |

#### Component-Specific Shapes

```kotlin
GlintShape.Component {
    buttonDefault = RoundedCornerShape(12.dp)
    buttonPill = RoundedCornerShape(50%)
    card = RoundedCornerShape(12.dp)
    textField = RoundedCornerShape(8.dp)
    // ... and more
}
```

### Component Tokens

#### Component-Specific Design Values

```kotlin
GlintComponents {
    Button {
        heightSmall = 36.dp
        heightMedium = 48.dp
        heightLarge = 56.dp
        borderWidth = 1.dp
    }
    
    TextField {
        heightDefault = 56.dp
        borderWidthFocused = 2.dp
    }
    
    Card {
        elevationLow = 2.dp
        elevationMedium = 4.dp
        elevationHigh = 8.dp
    }
}
```

---

## 📦 Components

### Available Components

#### GlintButton

Customizable button component dengan 3 variasi style dan 3 ukuran:

**Variants:**
- **Filled** (`GlintPrimaryButton`): Solid background untuk aksi utama
- **Outlined** (`GlintSecondaryButton`): Border only untuk aksi sekunder
- **Text** (`GlintTextButton`): Minimal style untuk aksi tersier

**Sizes:**
- **Small**: 36dp height - Compact untuk tight spaces
- **Medium**: 48dp height - Default untuk most use cases
- **Large**: 56dp height - Prominent untuk hero actions

**Features:**
- State management (enabled, disabled, pressed, focused)
- Interactive colors dengan animation
- Fully themeable dengan design tokens
- Accessibility support (min touch target)

```kotlin
GlintPrimaryButton(
    text = "Continue",
    onClick = { /* action */ },
    size = GlintButtonSize.Medium
)

GlintSecondaryButton(
    text = "Cancel",
    onClick = { /* action */ }
)

GlintTextButton(
    text = "Learn More",
    onClick = { /* action */ }
)
```

#### GlintTextField

Custom OutlinedTextField dengan enhanced styling:

**Features:**
- Custom border colors untuk setiap state (normal, focused, error, disabled)
- Helper text support untuk additional context
- Error message display dengan red theming
- Multiline support
- Leading & trailing icon support (via Material3)
- Full keyboard action support

**States:**
- Normal: Default state dengan outline border
- Focused: Blue primary border saat user interaksi
- Error: Red border dengan error message
- Disabled: Grayed out dengan reduced opacity

```kotlin
var text by remember { mutableStateOf("") }

GlintTextField(
    value = text,
    onValueChange = { text = it },
    label = "Email",
    placeholder = "Enter your email",
    helperText = "We'll never share your email"
)

// With error
GlintTextField(
    value = text,
    onValueChange = { text = it },
    label = "Email",
    errorMessage = "Invalid email address",
    isError = true
)

// Multiline
GlintTextField(
    value = text,
    onValueChange = { text = it },
    label = "Description",
    singleLine = false,
    maxLines = 4
)
```

#### GlintCard

Elevated card component untuk content grouping:

**Elevation Levels:**
- **LOW** (2dp): Subtle depth untuk flat surfaces
- **MEDIUM** (4dp): Standard card elevation (default)
- **HIGH** (8dp): Emphasized content dengan strong shadow

**Features:**
- Clickable & non-clickable variants
- Custom padding options
- Integrated theme colors
- Rounded corners dengan shape tokens
- Elevation animation on press
- Composable content slot

```kotlin
// Basic card
GlintCard {
    Text("Card Title")
    Text("Card content")
}

// Clickable card dengan custom elevation
GlintCard(
    onClick = { /* action */ },
    elevation = GlintCardElevation.HIGH
) {
    Column {
        Text("Interactive Card")
        Text("Tap to interact")
    }
}
```

#### GlintToggle (NEW!)

Binary state switch/toggle component:

**Sizes:**
- **Small**: 40x20dp - Compact untuk settings lists
- **Medium**: 52x28dp - Default untuk most use cases
- **Large**: 64x36dp - Prominent untuk important toggles

**Features:**
- Smooth animation untuk state changes
- Full theming dengan semantic colors
- Enabled/disabled states
- Accessibility support (Role.Switch)
- Color animation pada track dan thumb
- Position animation dengan easing

```kotlin
var isDarkMode by remember { mutableStateOf(false) }

GlintToggle(
    checked = isDarkMode,
    onCheckedChange = { isDarkMode = it },
    size = GlintToggleSize.Medium
)

// In a settings row
Row(
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
) {
    Text("Dark Mode")
    GlintToggle(
        checked = isDarkMode,
        onCheckedChange = { isDarkMode = it }
    )
}
```

### Component Design Principles

All components follow these principles:

1. **Token-Based**: No hardcoded values, all use design tokens
2. **Theme-Aware**: Automatically adapt to light/dark mode
3. **State Management**: Handle all interaction states properly
4. **Accessibility**: Meet WCAG guidelines untuk touch targets & contrast
5. **Composability**: Flexible content slots untuk customization
6. **Performance**: Optimized dengan remember & derivedStateOf
7. **Documentation**: Comprehensive KDoc untuk all public APIs

---

## 🛠️ Build & Development

### Build Project

```bash
# Build all modules
./gradlew build

# Build specific module
./gradlew :core-ui:build
./gradlew :components:build
./gradlew :catalog:build
```

### Run Catalog App

```bash
./gradlew :catalog:installDebug
```

atau run dari Android Studio dengan memilih `catalog` configuration.

---

## 📱 Catalog App

Catalog app menyediakan preview interaktif untuk semua komponen dengan dark/light mode toggle.

### Features

- **Theme Toggle**: Switch between dark and light mode at the top
- **All Components**: Preview semua komponen dengan variants
- **Interactive Examples**: Test komponen secara real-time
- **State Demonstrations**: Lihat semua states (enabled, disabled, error, etc.)
- **Responsive**: Test pada berbagai screen sizes

### Component Sections

1. **Theme Control** - Dark/Light mode toggle untuk testing themes
2. **Buttons** - All button variants, sizes, dan states
3. **Text Fields** - Input fields dengan berbagai configurations
4. **Toggles** - Toggle/switch components dengan size variants
5. **Cards** - Card components dengan elevation levels

### Running Catalog

```bash
# Install to device/emulator
./gradlew :catalog:installDebug

# Or from Android Studio
# Select "catalog" configuration → Run
```

The catalog automatically displays:
- Component variants (Primary, Secondary, Text, etc.)
- Size options (Small, Medium, Large)
- State variations (Enabled, Disabled, Error, Focused)
- Interactive examples dengan real functionality
- Dark/light theme comparison

---

## 🤝 Contributing

Contributions are welcome! Please follow these guidelines:

### Before Contributing

1. Read [RULE.md](RULE.md) for coding standards and conventions
2. Read [DEVELOPMENT_GUIDE.md](DEVELOPMENT_GUIDE.md) for development workflow
3. Check existing components for patterns to follow
4. Ensure you understand the design token system

### Contribution Process

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Follow coding standards in RULE.md:
   - Use design tokens (no hardcoded values)
   - Add `Glint` prefix to component names
   - Include KDoc documentation
   - Add light & dark mode previews
   - Handle all component states
4. Test your changes in the catalog app
5. Commit your changes (`git commit -m 'feat(components): add AmazingFeature'`)
6. Push to the branch (`git push origin feature/AmazingFeature`)
7. Open a Pull Request

### Coding Standards

- **Design Tokens**: Use `GlintTheme.colorScheme`, `GlintTheme.spacing`, etc.
- **Naming**: `Glint` prefix for all components
- **Documentation**: KDoc for all public APIs
- **Previews**: Light, dark, variants, and states
- **Testing**: Add to catalog app for visual verification
- **No Hardcoding**: Colors, sizes, spacing must use tokens

See [RULE.md](RULE.md) for complete standards and patterns.

---

## 📚 Documentation

- **[README.md](README.md)** - This file, project overview & usage
- **[RULE.md](RULE.md)** - Coding standards, patterns, conventions (for developers & AI)
- **[DEVELOPMENT_GUIDE.md](DEVELOPMENT_GUIDE.md)** - Development workflow & best practices
- **[LICENSE](LICENSE)** - MIT License

### Quick Links

- **Design System**: See "Design System" section above
- **Component Documentation**: See "Components" section above
- **Usage Examples**: See "Usage" section above
- **Contributing Guide**: See "Contributing" section above
- **AI Assistance**: See RULE.md for AI-specific guidelines

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👥 Team

Developed by derayane as a Material Design 3 UI Component Library for Android.

---

## 🙏 Acknowledgments

- [Material Design 3](https://m3.material.io/)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- Android Developer Community

---

<div align="center">

**Made with ❤️ using Kotlin & Jetpack Compose**

</div>