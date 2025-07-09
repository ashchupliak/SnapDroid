# Android Visual Testing Framework with RTL Support

A comprehensive Android visual testing framework that provides automated screenshot testing with support for multiple themes, font scales, RTL layouts, device sizes, and orientations.

## Features

### 🎨 **Theme Support**
- Light theme testing
- Dark theme testing
- Automatic theme switching

### 📱 **Font Scale Support**
- Default font scale (1.0x)
- Larger font scale (1.3x)
- Largest font scale (1.5x)

### 🌐 **RTL Layout Support**
- Left-to-Right (LTR) layout testing
- Right-to-Left (RTL) layout testing
- Automatic layout direction switching

### 📏 **Device Size Support**
- Phone Small (320x568)
- Phone Medium (360x640)
- Phone Large (411x823)
- Tablet Small (600x960)
- Tablet Large (800x1280)

### 🔄 **Orientation Support**
- Portrait orientation
- Landscape orientation

### 🛠️ **Testing Capabilities**
- Fragment screenshot testing
- Activity screenshot testing
- View screenshot testing
- Parameterized testing with TestParameterInjector
- Comprehensive test scenarios

## Architecture

The framework consists of two main modules:

1. **visual-testing-library** - Core framework library
2. **app** - Demo application showcasing the framework

### Core Components

#### `BaseVisualTest`
Base class for visual testing with comprehensive configuration support.

#### `ParameterizedVisualTest`
Parameterized testing class using TestParameterInjector for automatic parameter injection.

#### `VisualTestParameters`
Enums for different test parameters:
- `ColorScheme`
- `FontScale`
- `ScreenDirection`
- `DeviceOrientation`
- `DeviceSize`

## Installation

### Prerequisites
- Android Studio Arctic Fox (2020.3.1) or later
- Android SDK 21 or higher
- Gradle 7.0 or higher

### Setup

1. Clone the repository:
```bash
git clone https://github.com/your-username/android-visual-testing-framework.git
```

2. Open the project in Android Studio

3. Build the project:
```bash
./gradlew build
```

## Usage

### Basic Usage

Create a test class extending `BaseVisualTest`:

```kotlin
class MyActivityVisualTest : BaseVisualTest() {
    
    @Test
    fun testActivityScreenshot() {
        val scenario = ActivityScenario.launch(MyActivity::class.java)
        
        compareScreenshot(
            scenario = scenario,
            name = "my_activity_basic",
            colorScheme = ColorScheme.LIGHT,
            fontScale = FontScale.DEFAULT
        )
    }
}
```

### Parameterized Testing

Create a test class extending `ParameterizedVisualTest`:

```kotlin
@RunWith(TestParameterInjector::class)
class MyParameterizedVisualTest : ParameterizedVisualTest() {
    
    @Test
    fun testWithParameters(
        @TestParameter colorScheme: ColorScheme,
        @TestParameter fontScale: FontScale
    ) {
        val scenario = ActivityScenario.launch(MyActivity::class.java)
        
        compareParameterizedScreenshot(
            scenario = scenario,
            name = "my_activity_parameterized",
            colorScheme = colorScheme,
            fontScale = fontScale
        )
    }
}
```

### RTL Testing

Test RTL layout support:

```kotlin
@Test
fun testRTLLayout() {
    val scenario = ActivityScenario.launch(MyActivity::class.java)
    
    compareScreenshot(
        scenario = scenario,
        name = "my_activity_rtl",
        colorScheme = ColorScheme.LIGHT,
        fontScale = FontScale.DEFAULT,
        screenDirection = ScreenDirection.RTL
    )
}
```

### Comprehensive Testing

Test multiple parameters together:

```kotlin
@Test
fun testComprehensiveScenario() {
    val scenario = ActivityScenario.launch(MyActivity::class.java)
    
    compareScreenshot(
        scenario = scenario,
        name = "my_activity_comprehensive",
        colorScheme = ColorScheme.DARK,
        fontScale = FontScale.LARGER,
        screenDirection = ScreenDirection.RTL,
        deviceOrientation = DeviceOrientation.LANDSCAPE,
        deviceSize = DeviceSize.TABLET_SMALL
    )
}
```

## Running Tests

### Execute Visual Tests

```bash
./gradlew executeScreenshotTests
```

### Verify Screenshots

```bash
./gradlew verifyScreenshots
```

### Record New Screenshots

```bash
./gradlew recordScreenshots
```

## Screenshot Organization

Screenshots are organized in the following structure:

```
app/screenshots/debug/
├── MainActivityVisualTest_testMainActivityBasicThemes_main_activity_basic_light.png
├── MainActivityVisualTest_testMainActivityBasicThemes_main_activity_basic_dark.png
├── MainActivityVisualTest_testMainActivityRTLSupport_main_activity_rtl_light_rtlScreenDirection.png
├── MainActivityVisualTest_testMainActivityRTLSupport_main_activity_rtl_dark_rtlScreenDirection.png
└── ...
```

## Configuration

### Gradle Configuration

The framework uses the Shot library for screenshot testing. Add the following to your `build.gradle`:

```gradle
plugins {
    id 'shot'
}

dependencies {
    androidTestImplementation 'com.karumi:shot:6.1.0'
    androidTestImplementation 'com.karumi:shot-android:6.1.0'
    androidTestImplementation 'com.google.testing.junit.testparameterinjector:test-parameter-injector:1.5'
}
```

### Android Manifest Configuration

Ensure RTL support is enabled in your `AndroidManifest.xml`:

```xml
<application
    android:supportsRtl="true"
    ... >
</application>
```

## Advanced Features

### Custom Screenshot Naming

The framework automatically generates screenshot names based on test parameters:

```
{test_name}_{color_scheme}_{font_scale}_{screen_direction}_{device_orientation}_{device_size}
```

### Test Parameter Combinations

The framework supports testing various parameter combinations:

- **Basic**: ColorScheme + FontScale
- **RTL**: ColorScheme + FontScale + ScreenDirection
- **Device**: ColorScheme + FontScale + DeviceSize
- **Comprehensive**: All parameters

## Best Practices

1. **Test Naming**: Use descriptive test names that indicate the scenario being tested
2. **Parameter Coverage**: Test both LTR and RTL layouts for international support
3. **Font Scale Testing**: Always test with at least default and larger font scales
4. **Device Coverage**: Test on different device sizes for responsive design
5. **Theme Testing**: Test both light and dark themes

## Demo Application

The framework includes a demo application showcasing:

- Material Design components
- RTL layout support
- Theme switching
- Font scale adaptation
- Responsive design

Run the demo app to see the framework in action:

```bash
./gradlew app:installDebug
```

## Troubleshooting

### Common Issues

1. **Screenshot Mismatch**: Ensure consistent test environment and device configuration
2. **RTL Layout Issues**: Check that `android:supportsRtl="true"` is set in manifest
3. **Font Scale Problems**: Verify that layouts handle different font scales appropriately
4. **Theme Issues**: Ensure proper theme configuration in styles.xml

### Debug Tips

1. Use specific device emulators for consistent results
2. Record screenshots initially to establish baseline
3. Use descriptive test names for easier debugging
4. Check Shot library logs for detailed error information

## Contributing

1. Fork the repository
2. Create a feature branch
3. Add tests for new functionality
4. Ensure all tests pass
5. Submit a pull request

## License

MIT License - see LICENSE file for details

## Support

For issues and questions:
- Create an issue on GitHub
- Check the documentation
- Review the demo application for examples

---

**Happy Visual Testing! 📸** 