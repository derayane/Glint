# 🌟 Glint Design System

**Glint** adalah Android UI Component Library berbasis Material 3 yang dirancang dengan Atomic Design principles dan Design Tokens yang scalable.

## 📐 Arsitektur

Glint menggunakan struktur modular: 

```
Glint/
├── core-ui/           # Design Tokens & Theme Foundation
├── components/        # Reusable UI Components
└── catalog/          # Sample App untuk Preview
```

## 🎨 Design Tokens

### Semantic Color Naming
Kami menggunakan **semantic naming** untuk colors agar mudah dipahami dan di-maintain:

- **Primary**: Warna utama brand (CTA, interactive elements)
- **Secondary**: Warna pendukung untuk variasi visual
- **Tertiary**: Aksen tambahan
- **Error/Warning/Success**: Status colors
- **Surface**: Background layers
- **OnX**: Text/icon color di atas warna X

### Token Structure
```kotlin
GlintColors      // Primitive + Semantic colors
GlintTypography  // Type scale (Display, Headline, Body, Label)
GlintSpacing     // Consistent spacing system
GlintShape       // Corner radius definitions
```

## 🚀 Quick Start

### 1. Clone Repository
```bash
git clone https://github.com/derayane/Glint.git
cd Glint
```

### 2. Buka dengan Android Studio
File > Open > Pilih folder `Glint`

### 3. Run Catalog App
Pilih module `:catalog` dan jalankan pada emulator/device. 

## 📦 Penggunaan di Project Lain

```kotlin
// Di build.gradle.kts (app level)
dependencies {
    implementation(project(":core-ui"))
    implementation(project(":components"))
}
```

```kotlin
// Di MainActivity.kt
@Composable
fun MyApp() {
    GlintTheme {
        // Semua komponen Material 3 otomatis mengikuti Glint styling
        Column {
            GlintButton(
                text = "Primary Button",
                style = GlintButtonStyle.Primary,
                onClick = { }
            )
            
            GlintTextField(
                value = text,
                onValueChange = { text = it },
                label = "Email"
            )
            
            GlintCard {
                Text("Card Content")
            }
        }
    }
}
```

## 🎯 Komponen Tersedia

### GlintButton
Button dengan 3 style variants:
- `Primary`: Filled button (default)
- `Secondary`: Outlined button
- `Ghost`: Text button

### GlintTextField
Customized OutlinedTextField dengan:
- Custom border styling
- Konsisten label typography
- Error state handling

### GlintCard
Elevated card dengan shadow & corner radius sesuai Glint theme. 

## 🏗️ Development Guide

### Menambah Token Baru
1. Edit file di `core-ui/src/main/java/com/derayane/glint/core/tokens/`
2. Update `GlintTheme.kt` jika perlu override Material3

### Membuat Komponen Baru
1. Buat file di `components/src/main/java/com/derayane/glint/components/`
2. Gunakan Design Tokens dari `core-ui`
3. Tambahkan preview di Catalog app

### Testing
```bash
./gradlew :components:testDebugUnitTest
```

## 📝 Philosophy

**Mengapa Semantic Naming?**
- ✅ Mudah dipahami developer baru
- ✅ Tidak bergantung pada warna spesifik (blue, red)
- ✅ Mudah di-theme untuk dark/light mode
- ✅ Scalable untuk design system besar

**Mengapa Modular?**
- ✅ Separation of concerns
- ✅ Reusability tinggi
- ✅ Build time lebih cepat (hanya build module yang berubah)
- ✅ Mudah di-maintain oleh tim besar

## 🤝 Contributing

Silakan buat branch baru untuk setiap feature:
```bash
git checkout -b feature/new-component
```

## 📄 License

[Tambahkan license sesuai kebutuhan]

## 👥 Team

Created by Senior Android Engineers passionate about Design Systems. 

---

**Happy Coding with Glint! ✨**