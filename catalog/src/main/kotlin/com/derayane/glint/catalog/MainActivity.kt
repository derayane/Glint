package com.derayane.glint.catalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.derayane.glint.components.*
import com.derayane.glint.coreui.theme.GlintTheme
import com.derayane.glint.coreui.tokens.GlintSpacing

/**
 * MainActivity - Catalog App untuk preview komponen Glint
 * 
 * Menampilkan semua komponen Glint dalam satu layar scrollable
 * untuk memudahkan developer melihat dan testing komponen
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlintTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CatalogScreen()
                }
            }
        }
    }
}

@Composable
fun CatalogScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(GlintSpacing.lg),
        verticalArrangement = Arrangement.spacedBy(GlintSpacing.xl)
    ) {
        // Header
        Text(
            text = "Glint Design System Catalog",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        
        Text(
            text = "Explore all available components",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Divider(modifier = Modifier.padding(vertical = GlintSpacing.sm))
        
        // Button Section
        ComponentSection(title = "Buttons") {
            ButtonsPreview()
        }
        
        Divider()
        
        // TextField Section
        ComponentSection(title = "Text Fields") {
            TextFieldsPreview()
        }
        
        Divider()
        
        // Card Section
        ComponentSection(title = "Cards") {
            CardsPreview()
        }
        
        // Footer
        Spacer(modifier = Modifier.height(GlintSpacing.xxl))
        Text(
            text = "Glint v1.0.0 - Material Design 3",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun ComponentSection(
    title: String,
    content: @Composable () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(GlintSpacing.md)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
        content()
    }
}

@Composable
fun ButtonsPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(GlintSpacing.md)
    ) {
        // Button variants
        Text(
            text = "Button Variants",
            style = MaterialTheme.typography.titleMedium
        )
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(GlintSpacing.sm)
        ) {
            GlintButtonPrimary(
                text = "Primary",
                onClick = {},
                modifier = Modifier.weight(1f)
            )
            GlintButtonSecondary(
                text = "Secondary",
                onClick = {},
                modifier = Modifier.weight(1f)
            )
            GlintButtonGhost(
                text = "Ghost",
                onClick = {},
                modifier = Modifier.weight(1f)
            )
        }
        
        // Button sizes
        Text(
            text = "Button Sizes",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = GlintSpacing.md)
        )
        
        Column(
            verticalArrangement = Arrangement.spacedBy(GlintSpacing.sm)
        ) {
            GlintButtonPrimary(
                text = "Small Button",
                onClick = {},
                size = GlintButtonSize.SMALL,
                modifier = Modifier.fillMaxWidth()
            )
            GlintButtonPrimary(
                text = "Medium Button",
                onClick = {},
                size = GlintButtonSize.MEDIUM,
                modifier = Modifier.fillMaxWidth()
            )
            GlintButtonPrimary(
                text = "Large Button",
                onClick = {},
                size = GlintButtonSize.LARGE,
                modifier = Modifier.fillMaxWidth()
            )
        }
        
        // Button states
        Text(
            text = "Button States",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = GlintSpacing.md)
        )
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(GlintSpacing.sm)
        ) {
            GlintButtonPrimary(
                text = "Enabled",
                onClick = {},
                enabled = true,
                modifier = Modifier.weight(1f)
            )
            GlintButtonPrimary(
                text = "Disabled",
                onClick = {},
                enabled = false,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun TextFieldsPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(GlintSpacing.md)
    ) {
        // Basic TextField
        Text(
            text = "Basic TextField",
            style = MaterialTheme.typography.titleMedium
        )
        
        var textField1 by remember { mutableStateOf("") }
        GlintTextField(
            value = textField1,
            onValueChange = { textField1 = it },
            label = "Email",
            placeholder = "Enter your email",
            helperText = "We'll never share your email"
        )
        
        // TextField with error
        Text(
            text = "TextField with Error",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = GlintSpacing.md)
        )
        
        var textField2 by remember { mutableStateOf("invalid-email") }
        GlintTextField(
            value = textField2,
            onValueChange = { textField2 = it },
            label = "Email",
            errorMessage = "Please enter a valid email address",
            isError = true
        )
        
        // Multiline TextField
        Text(
            text = "Multiline TextField",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = GlintSpacing.md)
        )
        
        var textField3 by remember { mutableStateOf("") }
        GlintTextField(
            value = textField3,
            onValueChange = { textField3 = it },
            label = "Description",
            placeholder = "Enter description",
            helperText = "Maximum 500 characters",
            singleLine = false,
            maxLines = 4
        )
        
        // Disabled TextField
        Text(
            text = "Disabled TextField",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = GlintSpacing.md)
        )
        
        GlintTextField(
            value = "Disabled field",
            onValueChange = {},
            label = "Username",
            enabled = false
        )
    }
}

@Composable
fun CardsPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(GlintSpacing.md)
    ) {
        // Basic Card
        Text(
            text = "Basic Card",
            style = MaterialTheme.typography.titleMedium
        )
        
        GlintCard(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Simple Card",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "This is a basic card with some content inside.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        
        // Clickable Card
        Text(
            text = "Clickable Card",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = GlintSpacing.md)
        )
        
        var clickCount by remember { mutableStateOf(0) }
        GlintCard(
            modifier = Modifier.fillMaxWidth(),
            onClick = { clickCount++ }
        ) {
            Text(
                text = "Interactive Card",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "Clicked $clickCount times. Tap to increment!",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        
        // Card Elevations
        Text(
            text = "Card Elevations",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = GlintSpacing.md)
        )
        
        GlintCard(
            modifier = Modifier.fillMaxWidth(),
            elevation = GlintCardElevation.LOW
        ) {
            Text(text = "Low Elevation", style = MaterialTheme.typography.titleMedium)
            Text(
                text = "2dp elevation for subtle depth",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        
        GlintCard(
            modifier = Modifier.fillMaxWidth(),
            elevation = GlintCardElevation.MEDIUM
        ) {
            Text(text = "Medium Elevation", style = MaterialTheme.typography.titleMedium)
            Text(
                text = "4dp elevation for standard cards",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        
        GlintCard(
            modifier = Modifier.fillMaxWidth(),
            elevation = GlintCardElevation.HIGH
        ) {
            Text(text = "High Elevation", style = MaterialTheme.typography.titleMedium)
            Text(
                text = "8dp elevation for emphasized content",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        
        // Complex Card
        Text(
            text = "Complex Card with Components",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = GlintSpacing.md)
        )
        
        GlintCard(
            modifier = Modifier.fillMaxWidth(),
            elevation = GlintCardElevation.MEDIUM
        ) {
            Text(
                text = "Product Information",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "Glint Design System",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "A comprehensive UI component library for Android based on Material Design 3. Built with Kotlin and Jetpack Compose.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 4.dp)
            )
            
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                GlintButtonPrimary(
                    text = "View Details",
                    onClick = {},
                    modifier = Modifier.weight(1f)
                )
                GlintButtonSecondary(
                    text = "Share",
                    onClick = {},
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}
