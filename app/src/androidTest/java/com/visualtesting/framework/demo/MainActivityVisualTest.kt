package com.visualtesting.framework.demo

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.visualtesting.framework.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityVisualTest : BaseVisualTest() {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    override fun setUp() {
        super.setUp()
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun testMainActivityBasicThemes() {
        // Test light theme
        compareScreenshot(
            scenario = scenario,
            name = "main_activity_basic",
            colorScheme = ColorScheme.LIGHT,
            fontScale = FontScale.DEFAULT
        )

        // Test dark theme
        compareScreenshot(
            scenario = scenario,
            name = "main_activity_basic",
            colorScheme = ColorScheme.DARK,
            fontScale = FontScale.DEFAULT
        )
    }

    @Test
    fun testMainActivityFontScales() {
        // Test different font scales with light theme
        compareScreenshot(
            scenario = scenario,
            name = "main_activity_font_scale",
            colorScheme = ColorScheme.LIGHT,
            fontScale = FontScale.DEFAULT
        )

        compareScreenshot(
            scenario = scenario,
            name = "main_activity_font_scale",
            colorScheme = ColorScheme.LIGHT,
            fontScale = FontScale.LARGER
        )

        compareScreenshot(
            scenario = scenario,
            name = "main_activity_font_scale",
            colorScheme = ColorScheme.LIGHT,
            fontScale = FontScale.LARGEST
        )
    }

    @Test
    fun testMainActivityRTLSupport() {
        // Test RTL layout with light theme
        compareScreenshot(
            scenario = scenario,
            name = "main_activity_rtl",
            colorScheme = ColorScheme.LIGHT,
            fontScale = FontScale.DEFAULT,
            screenDirection = ScreenDirection.RTL
        )

        // Test RTL layout with dark theme
        compareScreenshot(
            scenario = scenario,
            name = "main_activity_rtl",
            colorScheme = ColorScheme.DARK,
            fontScale = FontScale.DEFAULT,
            screenDirection = ScreenDirection.RTL
        )

        // Test RTL layout with larger font
        compareScreenshot(
            scenario = scenario,
            name = "main_activity_rtl",
            colorScheme = ColorScheme.LIGHT,
            fontScale = FontScale.LARGER,
            screenDirection = ScreenDirection.RTL
        )
    }

    @Test
    fun testMainActivityDeviceSizes() {
        // Test different device sizes
        compareScreenshot(
            scenario = scenario,
            name = "main_activity_device_size",
            colorScheme = ColorScheme.LIGHT,
            fontScale = FontScale.DEFAULT,
            deviceSize = DeviceSize.PHONE_SMALL
        )

        compareScreenshot(
            scenario = scenario,
            name = "main_activity_device_size",
            colorScheme = ColorScheme.LIGHT,
            fontScale = FontScale.DEFAULT,
            deviceSize = DeviceSize.PHONE_LARGE
        )

        compareScreenshot(
            scenario = scenario,
            name = "main_activity_device_size",
            colorScheme = ColorScheme.LIGHT,
            fontScale = FontScale.DEFAULT,
            deviceSize = DeviceSize.TABLET_SMALL
        )
    }

    @Test
    fun testMainActivityLandscapeOrientation() {
        // Test landscape orientation
        compareScreenshot(
            scenario = scenario,
            name = "main_activity_landscape",
            colorScheme = ColorScheme.LIGHT,
            fontScale = FontScale.DEFAULT,
            deviceOrientation = DeviceOrientation.LANDSCAPE
        )

        // Test landscape with RTL
        compareScreenshot(
            scenario = scenario,
            name = "main_activity_landscape",
            colorScheme = ColorScheme.LIGHT,
            fontScale = FontScale.DEFAULT,
            screenDirection = ScreenDirection.RTL,
            deviceOrientation = DeviceOrientation.LANDSCAPE
        )
    }

    @Test
    fun testMainActivityComprehensiveScenarios() {
        // Test comprehensive scenarios combining multiple parameters
        
        // Scenario 1: Dark theme, larger font, RTL
        compareScreenshot(
            scenario = scenario,
            name = "main_activity_comprehensive",
            colorScheme = ColorScheme.DARK,
            fontScale = FontScale.LARGER,
            screenDirection = ScreenDirection.RTL
        )

        // Scenario 2: Light theme, largest font, phone large
        compareScreenshot(
            scenario = scenario,
            name = "main_activity_comprehensive",
            colorScheme = ColorScheme.LIGHT,
            fontScale = FontScale.LARGEST,
            deviceSize = DeviceSize.PHONE_LARGE
        )

        // Scenario 3: Dark theme, RTL, landscape, tablet
        compareScreenshot(
            scenario = scenario,
            name = "main_activity_comprehensive",
            colorScheme = ColorScheme.DARK,
            fontScale = FontScale.DEFAULT,
            screenDirection = ScreenDirection.RTL,
            deviceOrientation = DeviceOrientation.LANDSCAPE,
            deviceSize = DeviceSize.TABLET_SMALL
        )
    }

    @Test
    fun testMainActivityEdgeCases() {
        // Test edge cases and extreme configurations
        
        // Edge case 1: Smallest device with largest font
        compareScreenshot(
            scenario = scenario,
            name = "main_activity_edge_case",
            colorScheme = ColorScheme.LIGHT,
            fontScale = FontScale.LARGEST,
            deviceSize = DeviceSize.PHONE_SMALL
        )

        // Edge case 2: RTL with largest font on tablet
        compareScreenshot(
            scenario = scenario,
            name = "main_activity_edge_case",
            colorScheme = ColorScheme.DARK,
            fontScale = FontScale.LARGEST,
            screenDirection = ScreenDirection.RTL,
            deviceSize = DeviceSize.TABLET_LARGE
        )
    }
} 