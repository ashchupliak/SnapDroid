# 📱 SnapDroid - Android Visual Testing Made Simple

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)](https://github.com/ashchupliak/SnapDroid)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Android](https://img.shields.io/badge/Android-5.0%2B-green)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-purple)](https://kotlinlang.org)

> 🚀 A powerful Android visual testing library that makes screenshot testing a breeze! Built with ❤️ for Android developers who care about pixel-perfect UIs.

## ✨ What is SnapDroid?

SnapDroid is your go-to solution for comprehensive Android visual testing. Whether you're building apps for global markets with RTL support, testing across multiple themes, or ensuring your UI looks perfect on every device - SnapDroid has got you covered! 

### 🎯 Key Features

- 🌍 **RTL Support**: Full right-to-left language testing
- 🎨 **Multiple Themes**: Light, dark, and custom theme testing
- 📏 **Font Scaling**: Test with different font sizes and accessibility options
- 📱 **Device Variations**: From phones to tablets, all screen sizes covered
- 🔄 **Orientation Testing**: Portrait and landscape modes
- ⚡ **Easy Integration**: Simple setup with Gradle
- 🔧 **Parameterized Testing**: Run hundreds of test combinations effortlessly

## 🚀 Quick Start

### Installation

Add to your `build.gradle` (Module: app):

```gradle
dependencies {
    implementation project(':visual-testing-library')
    
    // For testing
    androidTestImplementation 'com.karumi:shot-android:6.1.0'
    androidTestImplementation 'com.google.testparameterinjector:test-parameter-injector:1.13'
}
```

### 📸 Your First Snapshot Test

```kotlin
class MyActivityTest : ParameterizedVisualTest() {
    
    @Test
    fun testMyActivity_AllVariations() {
        val activity = MyActivity()
        
        // Test with different configurations
        compareScreenshot(activity, "my_activity")
    }
    
    @Test
    fun testMyActivity_RTL() {
        val activity = MyActivity()
        
        // Test RTL layout
        compareScreenshot(
            activity, 
            "my_activity_rtl",
            ScreenDirection.RTL
        )
    }
}
```

## 🛠️ Advanced Usage

### Custom Test Configurations

```kotlin
// Test with specific parameters
@Test
fun testLoginScreen_DarkTheme_LargeFont() {
    val activity = LoginActivity()
    
    compareScreenshot(
        activity,
        "login_dark_large",
        colorScheme = ColorScheme.DARK,
        fontScale = FontScale.LARGER
    )
}

// Test across multiple devices
@Test
fun testDashboard_AllDevices() {
    val activity = DashboardActivity()
    
    DeviceSize.values().forEach { device ->
        compareScreenshot(
            activity,
            "dashboard_${device.name.lowercase()}",
            deviceSize = device
        )
    }
}
```

### 🎨 Available Parameters

| Parameter | Options | Description |
|-----------|---------|-------------|
| `ColorScheme` | `LIGHT`, `DARK` | Theme variations |
| `FontScale` | `DEFAULT`, `LARGER`, `LARGEST` | Font size testing |
| `ScreenDirection` | `LTR`, `RTL` | Language direction |
| `DeviceOrientation` | `PORTRAIT`, `LANDSCAPE` | Screen orientation |
| `DeviceSize` | `PHONE_SMALL` to `TABLET_LARGE` | Device variations |

## 📊 Test Results

SnapDroid generates detailed screenshot comparisons and stores them in:
```
/screenshots/
├── debug/
│   ├── my_activity_light_ltr_phone.png
│   ├── my_activity_dark_rtl_tablet.png
│   └── ...
```

## 🔧 Configuration

### Custom Base Test Class

```kotlin
abstract class MyBaseVisualTest : BaseVisualTest() {
    
    override fun setUp() {
        super.setUp()
        // Your custom setup
    }
    
    override fun getDefaultWaitTime(): Long = 2000L
    
    override fun getDefaultTolerance(): Double = 0.01
}
```

### 📱 Demo App

The project includes a comprehensive demo app showcasing:
- ✅ Material Design components
- ✅ Form elements with validation
- ✅ RTL-aware layouts
- ✅ Theme switching
- ✅ Accessibility features

Run the demo:
```bash
./gradlew app:installDebug
```

## 🧪 Running Tests

```bash
# Run all visual tests
./gradlew app:connectedAndroidTest

# Run specific test class
./gradlew app:connectedAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=com.snapdroid.MainActivityTest

# Generate screenshots
./gradlew app:executeScreenshotTests
```

## 🤝 Contributing

We love contributions! 💝 

1. 🍴 Fork the repository
2. 🌟 Create your feature branch (`git checkout -b feature/amazing-feature`)
3. 💾 Commit your changes (`git commit -m 'Add some amazing feature'`)
4. 📤 Push to the branch (`git push origin feature/amazing-feature`)
5. 🔄 Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- 📸 [Karumi Shot](https://github.com/Karumi/Shot) - The amazing screenshot testing library
- 🔧 [TestParameterInjector](https://github.com/google/TestParameterInjector) - For parameterized testing
- 🎨 [Material Design](https://material.io/) - For beautiful UI components

## 📞 Support

Having issues? 🐛 Found a bug? 💡 Have a feature request?

- 📋 [Open an issue](https://github.com/ashchupliak/SnapDroid/issues)
- 💬 [Start a discussion](https://github.com/ashchupliak/SnapDroid/discussions)
- 📧 Contact: [your-email@example.com](mailto:your-email@example.com)

---

<p align="center">
  Made with ❤️ for the Android community<br>
  <em>Happy Testing! 🎉</em>
</p> 