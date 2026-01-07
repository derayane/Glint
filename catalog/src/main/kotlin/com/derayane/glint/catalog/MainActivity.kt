package com.derayane.glint.catalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.derayane.glint.components.*
import com.derayane.glint.coreui.theme.GlintTheme
import com.derayane.glint.coreui.tokens.GlintSpacing

/**
 * MainActivity - Catalog App untuk preview komponen Glint
 * 
 * Menampilkan semua komponen Glint dalam satu layar scrollable
 * untuk memudahkan developer melihat dan testing komponen.
 * Includes dark/light mode toggle for testing themes.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkMode by remember { mutableStateOf(false) }
            
            GlintTheme(darkTheme = isDarkMode) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CatalogScreen(
                        isDarkMode = isDarkMode,
                        onThemeToggle = { isDarkMode = it }
                    )
                }
            }
        }
    }
}

@Composable
fun CatalogScreen(
    isDarkMode: Boolean,
    onThemeToggle: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(GlintSpacing.lg),
        verticalArrangement = Arrangement.spacedBy(GlintSpacing.xl)
    ) {
        // Theme Toggle at the top
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
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
            }
        }
        
        // Dark/Light Mode Toggle Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(GlintSpacing.md),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = if (isDarkMode) "Dark Mode" else "Light Mode",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Toggle to switch theme",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                GlintToggle(
                    checked = isDarkMode,
                    onCheckedChange = onThemeToggle,
                    size = GlintToggleSize.Large
                )
            }
        }
        
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
        
        // Toggle Section
        ComponentSection(title = "Toggles") {
            TogglePreview()
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
            GlintPrimaryButton(
                text = "Primary",
                onClick = {},
                modifier = Modifier.weight(1f)
            )
            GlintSecondaryButton(
                text = "Secondary",
                onClick = {},
                modifier = Modifier.weight(1f)
            )
            GlintTextButton(
                text = "Text",
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
            GlintPrimaryButton(
                text = "Small Button",
                onClick = {},
                size = GlintButtonSize.Small,
                modifier = Modifier.fillMaxWidth()
            )
            GlintPrimaryButton(
                text = "Medium Button",
                onClick = {},
                size = GlintButtonSize.Medium,
                modifier = Modifier.fillMaxWidth()
            )
            GlintPrimaryButton(
                text = "Large Button",
                onClick = {},
                size = GlintButtonSize.Large,
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
            GlintPrimaryButton(
                text = "Enabled",
                onClick = {},
                enabled = true,
                modifier = Modifier.weight(1f)
            )
            GlintPrimaryButton(
                text = "Disabled",
                onClick = {},
                enabled = false,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun TogglePreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(GlintSpacing.md)
    ) {
        // Toggle variants
        Text(
            text = "Toggle States",
            style = MaterialTheme.typography.titleMedium
        )
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(GlintSpacing.lg),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(GlintSpacing.sm)
            ) {
                Text("Off", style = MaterialTheme.typography.bodySmall)
                var toggleOff by remember { mutableStateOf(false) }
                GlintToggle(
                    checked = toggleOff,
                    onCheckedChange = { toggleOff = it }
                )
            }
            
            Column(
                verticalArrangement = Arrangement.spacedBy(GlintSpacing.sm)
            ) {
                Text("On", style = MaterialTheme.typography.bodySmall)
                var toggleOn by remember { mutableStateOf(true) }
                GlintToggle(
                    checked = toggleOn,
                    onCheckedChange = { toggleOn = it }
                )
            }
            
            Column(
                verticalArrangement = Arrangement.spacedBy(GlintSpacing.sm)
            ) {
                Text("Disabled", style = MaterialTheme.typography.bodySmall)
                GlintToggle(
                    checked = false,
                    onCheckedChange = {},
                    enabled = false
                )
            }
        }
        
        // Toggle sizes
        Text(
            text = "Toggle Sizes",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = GlintSpacing.md)
        )
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(GlintSpacing.lg),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(GlintSpacing.sm),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Small", style = MaterialTheme.typography.bodySmall)
                var toggleSmall by remember { mutableStateOf(true) }
                GlintToggle(
                    checked = toggleSmall,
                    onCheckedChange = { toggleSmall = it },
                    size = GlintToggleSize.Small
                )
            }
            
            Column(
                verticalArrangement = Arrangement.spacedBy(GlintSpacing.sm),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Medium", style = MaterialTheme.typography.bodySmall)
                var toggleMedium by remember { mutableStateOf(true) }
                GlintToggle(
                    checked = toggleMedium,
                    onCheckedChange = { toggleMedium = it },
                    size = GlintToggleSize.Medium
                )
            }
            
            Column(
                verticalArrangement = Arrangement.spacedBy(GlintSpacing.sm),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Large", style = MaterialTheme.typography.bodySmall)
                var toggleLarge by remember { mutableStateOf(true) }
                GlintToggle(
                    checked = toggleLarge,
                    onCheckedChange = { toggleLarge = it },
                    size = GlintToggleSize.Large
                )
            }
        }
        
        // Interactive example
        Text(
            text = "Interactive Example",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = GlintSpacing.md)
        )
        
        var featureEnabled by remember { mutableStateOf(false) }
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(GlintSpacing.md),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Enable Notifications",
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = if (featureEnabled) "You will receive notifications" else "Notifications are disabled",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                GlintToggle(
                    checked = featureEnabled,
                    onCheckedChange = { featureEnabled = it }
                )
            }
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
                GlintPrimaryButton(
                    text = "View Details",
                    onClick = {},
                    modifier = Modifier.weight(1f)
                )
                GlintSecondaryButton(
                    text = "Share",
                    onClick = {},
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}
