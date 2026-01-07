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
- ✅ **Dark Mode Support**: Built-in support untuk light & dark themes
- ✅ **Preview Catalog**: Sample app untuk preview semua komponen

---

## 🏗️ Project Structure

```
Glint/
├── core-ui/              # Design Tokens & Theme
│   └── src/main/kotlin/com/derayane/glint/coreui/
│       ├── tokens/
│       │   ├── GlintColors.kt      # Color system (Primitive & Semantic)
│       │   ├── GlintTypography.kt  # Typography scale
│       │   ├── GlintSpacing.kt     # Spacing system
│       │   └── GlintShape.kt       # Shape definitions
│       └── theme/
│           └── GlintTheme.kt       # MaterialTheme wrapper
│
├── components/           # UI Components
│   └── src/main/kotlin/com/derayane/glint/components/
│       ├── GlintButton.kt          # Button (Primary, Secondary, Ghost)
│       ├── GlintTextField.kt       # TextField with custom styling
│       └── GlintCard.kt            # Card with elevation levels
│
└── catalog/              # Sample app untuk preview
    └── src/main/kotlin/com/derayane/glint/catalog/
        └── MainActivity.kt         # Catalog screen
```

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

Wrap aplikasi Anda dengan `GlintTheme`:

```kotlin
@Composable
fun MyApp() {
    GlintTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            // Your app content here
        }
    }
}
```

### Using Components

#### Buttons

```kotlin
// Primary Button
GlintButtonPrimary(
    text = "Click Me",
    onClick = { /* Handle click */ }
)

// Secondary Button
GlintButtonSecondary(
    text = "Cancel",
    onClick = { /* Handle click */ }
)

// Ghost Button
GlintButtonGhost(
    text = "Learn More",
    onClick = { /* Handle click */ }
)
```

#### Text Fields

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
```

#### Cards

```kotlin
// Basic Card
GlintCard {
    Text("Card Title", style = MaterialTheme.typography.titleLarge)
    Text("Card content goes here")
}

// Clickable Card
GlintCard(
    onClick = { /* Handle click */ },
    elevation = GlintCardElevation.MEDIUM
) {
    Text("Interactive Card")
}
```

---

## 🎨 Design System

### Color System

Glint menggunakan **Primitive Colors** dan **Semantic Colors**:

#### Primitive Colors
Raw color palette yang menjadi foundation:
- **Blue Palette**: Primary brand colors (Blue50 - Blue900)
- **Purple Palette**: Secondary colors (Purple50 - Purple900)
- **Gray Palette**: Neutral colors (Gray50 - Gray900)
- **System Colors**: Success, Warning, Error, Info

#### Semantic Colors
Colors dengan konteks penggunaan spesifik:
- **Primary**: Untuk aksi utama
- **Secondary**: Untuk aksi sekunder
- **Tertiary**: Untuk aksi tersier
- **Error**: Untuk state error
- **Background/Surface**: Untuk containers
- **Outline**: Untuk borders

**Alasan Semantic Naming:**
- Memudahkan perubahan tema tanpa mengubah komponen
- Memberikan konteks yang jelas untuk setiap warna
- Memisahkan intent dari implementasi
- Memudahkan rebrand di masa depan

### Typography

Custom scale menggunakan Material3 Typography:
- **Display**: Hero text & large impactful text (57sp - 36sp)
- **Headline**: Section headers (32sp - 24sp)
- **Title**: Card & dialog titles (22sp - 14sp)
- **Body**: Content & paragraph text (16sp - 12sp)
- **Label**: Button text & UI labels (14sp - 11sp)

### Spacing

8dp grid system untuk konsistensi:
- `xxs`: 2dp - Sangat kecil
- `xs`: 4dp - Extra small
- `sm`: 8dp - Small (1 unit)
- `md`: 12dp - Medium
- `lg`: 16dp - Large (2 unit)
- `xl`: 24dp - Extra large
- `xxl`: 32dp - Extra extra large
- `xxxl`: 48dp - Extra extra extra large
- `huge`: 64dp - Huge

### Shapes

Corner radius definitions:
- `extraSmall`: 4dp - Badges, small chips
- `small`: 8dp - Buttons, chips
- `medium`: 12dp - Cards, text fields (default)
- `large`: 16dp - Bottom sheets, dialogs
- `extraLarge`: 28dp - Special elements

---

## 📦 Components

### GlintButton

3 variasi button state:
- **Primary**: Filled button untuk aksi utama
- **Secondary**: Outlined button untuk aksi sekunder
- **Ghost**: Text button untuk aksi tersier

3 ukuran tersedia:
- **SMALL**: 36dp height
- **MEDIUM**: 48dp height (default)
- **LARGE**: 56dp height

### GlintTextField

Custom OutlinedTextField dengan:
- Custom border colors untuk setiap state
- Support untuk helper text & error message
- Multiline support
- Icon support (leading & trailing)

### GlintCard

Custom ElevatedCard dengan:
- 3 level elevation (LOW, MEDIUM, HIGH)
- Clickable & non-clickable variants
- Custom padding options
- Integrated dengan theme colors

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

Catalog app menyediakan preview interaktif untuk semua komponen. Jalankan module `:catalog` untuk melihat:
- Semua variasi button (Primary, Secondary, Ghost)
- Berbagai state text field (Normal, Error, Disabled)
- Card dengan berbagai elevation
- Interactive components

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

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