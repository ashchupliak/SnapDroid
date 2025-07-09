package com.snapdroid.framework.demo

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.snapdroid.framework.BaseVisualTest
import com.snapdroid.framework.VisualTestParameters
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityVisualTest : BaseVisualTest() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // MARK: - Basic Tests

    @Test
    fun testMainActivity_defaultState() {
        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_default_state")
        }
    }

    @Test
    fun testMainActivity_lightMode() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.LIGHT,
            fontScale = VisualTestParameters.FontScale.NORMAL,
            screenDirection = VisualTestParameters.ScreenDirection.LTR,
            deviceOrientation = VisualTestParameters.DeviceOrientation.PORTRAIT,
            deviceSize = VisualTestParameters.DeviceSize.PHONE
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_light_mode", parameters)
        }
    }

    @Test
    fun testMainActivity_darkMode() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.DARK,
            fontScale = VisualTestParameters.FontScale.NORMAL,
            screenDirection = VisualTestParameters.ScreenDirection.LTR,
            deviceOrientation = VisualTestParameters.DeviceOrientation.PORTRAIT,
            deviceSize = VisualTestParameters.DeviceSize.PHONE
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_dark_mode", parameters)
        }
    }

    // MARK: - Font Scale Tests

    @Test
    fun testMainActivity_smallFont() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.LIGHT,
            fontScale = VisualTestParameters.FontScale.SMALL,
            screenDirection = VisualTestParameters.ScreenDirection.LTR,
            deviceOrientation = VisualTestParameters.DeviceOrientation.PORTRAIT,
            deviceSize = VisualTestParameters.DeviceSize.PHONE
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_small_font", parameters)
        }
    }

    @Test
    fun testMainActivity_largeFont() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.LIGHT,
            fontScale = VisualTestParameters.FontScale.LARGE,
            screenDirection = VisualTestParameters.ScreenDirection.LTR,
            deviceOrientation = VisualTestParameters.DeviceOrientation.PORTRAIT,
            deviceSize = VisualTestParameters.DeviceSize.PHONE
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_large_font", parameters)
        }
    }

    @Test
    fun testMainActivity_extraLargeFont() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.LIGHT,
            fontScale = VisualTestParameters.FontScale.EXTRA_LARGE,
            screenDirection = VisualTestParameters.ScreenDirection.LTR,
            deviceOrientation = VisualTestParameters.DeviceOrientation.PORTRAIT,
            deviceSize = VisualTestParameters.DeviceSize.PHONE
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_extra_large_font", parameters)
        }
    }

    @Test
    fun testMainActivity_hugeFont() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.LIGHT,
            fontScale = VisualTestParameters.FontScale.HUGE,
            screenDirection = VisualTestParameters.ScreenDirection.LTR,
            deviceOrientation = VisualTestParameters.DeviceOrientation.PORTRAIT,
            deviceSize = VisualTestParameters.DeviceSize.PHONE
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_huge_font", parameters)
        }
    }

    // MARK: - RTL Layout Tests

    @Test
    fun testMainActivity_rtlLayout() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.LIGHT,
            fontScale = VisualTestParameters.FontScale.NORMAL,
            screenDirection = VisualTestParameters.ScreenDirection.RTL,
            deviceOrientation = VisualTestParameters.DeviceOrientation.PORTRAIT,
            deviceSize = VisualTestParameters.DeviceSize.PHONE
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_rtl_layout", parameters)
        }
    }

    @Test
    fun testMainActivity_rtlDarkMode() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.DARK,
            fontScale = VisualTestParameters.FontScale.NORMAL,
            screenDirection = VisualTestParameters.ScreenDirection.RTL,
            deviceOrientation = VisualTestParameters.DeviceOrientation.PORTRAIT,
            deviceSize = VisualTestParameters.DeviceSize.PHONE
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_rtl_dark_mode", parameters)
        }
    }

    @Test
    fun testMainActivity_rtlLargeFont() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.LIGHT,
            fontScale = VisualTestParameters.FontScale.LARGE,
            screenDirection = VisualTestParameters.ScreenDirection.RTL,
            deviceOrientation = VisualTestParameters.DeviceOrientation.PORTRAIT,
            deviceSize = VisualTestParameters.DeviceSize.PHONE
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_rtl_large_font", parameters)
        }
    }

    // MARK: - Device Size Tests

    @Test
    fun testMainActivity_smallDevice() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.LIGHT,
            fontScale = VisualTestParameters.FontScale.NORMAL,
            screenDirection = VisualTestParameters.ScreenDirection.LTR,
            deviceOrientation = VisualTestParameters.DeviceOrientation.PORTRAIT,
            deviceSize = VisualTestParameters.DeviceSize.SMALL_PHONE
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_small_device", parameters)
        }
    }

    @Test
    fun testMainActivity_largeDevice() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.LIGHT,
            fontScale = VisualTestParameters.FontScale.NORMAL,
            screenDirection = VisualTestParameters.ScreenDirection.LTR,
            deviceOrientation = VisualTestParameters.DeviceOrientation.PORTRAIT,
            deviceSize = VisualTestParameters.DeviceSize.LARGE_PHONE
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_large_device", parameters)
        }
    }

    @Test
    fun testMainActivity_tablet() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.LIGHT,
            fontScale = VisualTestParameters.FontScale.NORMAL,
            screenDirection = VisualTestParameters.ScreenDirection.LTR,
            deviceOrientation = VisualTestParameters.DeviceOrientation.PORTRAIT,
            deviceSize = VisualTestParameters.DeviceSize.TABLET
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_tablet", parameters)
        }
    }

    @Test
    fun testMainActivity_largeTablet() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.LIGHT,
            fontScale = VisualTestParameters.FontScale.NORMAL,
            screenDirection = VisualTestParameters.ScreenDirection.LTR,
            deviceOrientation = VisualTestParameters.DeviceOrientation.PORTRAIT,
            deviceSize = VisualTestParameters.DeviceSize.LARGE_TABLET
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_large_tablet", parameters)
        }
    }

    // MARK: - Orientation Tests

    @Test
    fun testMainActivity_landscape() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.LIGHT,
            fontScale = VisualTestParameters.FontScale.NORMAL,
            screenDirection = VisualTestParameters.ScreenDirection.LTR,
            deviceOrientation = VisualTestParameters.DeviceOrientation.LANDSCAPE,
            deviceSize = VisualTestParameters.DeviceSize.PHONE
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_landscape", parameters)
        }
    }

    @Test
    fun testMainActivity_landscapeDarkMode() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.DARK,
            fontScale = VisualTestParameters.FontScale.NORMAL,
            screenDirection = VisualTestParameters.ScreenDirection.LTR,
            deviceOrientation = VisualTestParameters.DeviceOrientation.LANDSCAPE,
            deviceSize = VisualTestParameters.DeviceSize.PHONE
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_landscape_dark_mode", parameters)
        }
    }

    @Test
    fun testMainActivity_landscapeRTL() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.LIGHT,
            fontScale = VisualTestParameters.FontScale.NORMAL,
            screenDirection = VisualTestParameters.ScreenDirection.RTL,
            deviceOrientation = VisualTestParameters.DeviceOrientation.LANDSCAPE,
            deviceSize = VisualTestParameters.DeviceSize.PHONE
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_landscape_rtl", parameters)
        }
    }

    // MARK: - Combined Parameter Tests

    @Test
    fun testMainActivity_darkModeRTLLargeFont() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.DARK,
            fontScale = VisualTestParameters.FontScale.LARGE,
            screenDirection = VisualTestParameters.ScreenDirection.RTL,
            deviceOrientation = VisualTestParameters.DeviceOrientation.PORTRAIT,
            deviceSize = VisualTestParameters.DeviceSize.PHONE
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_dark_rtl_large_font", parameters)
        }
    }

    @Test
    fun testMainActivity_lightModeRTLSmallFont() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.LIGHT,
            fontScale = VisualTestParameters.FontScale.SMALL,
            screenDirection = VisualTestParameters.ScreenDirection.RTL,
            deviceOrientation = VisualTestParameters.DeviceOrientation.PORTRAIT,
            deviceSize = VisualTestParameters.DeviceSize.PHONE
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_light_rtl_small_font", parameters)
        }
    }

    @Test
    fun testMainActivity_darkModeHugeFont() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.DARK,
            fontScale = VisualTestParameters.FontScale.HUGE,
            screenDirection = VisualTestParameters.ScreenDirection.LTR,
            deviceOrientation = VisualTestParameters.DeviceOrientation.PORTRAIT,
            deviceSize = VisualTestParameters.DeviceSize.LARGE_PHONE
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_dark_huge_font", parameters)
        }
    }

    // MARK: - Stress Tests

    @Test
    fun testMainActivity_extremeConfiguration() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.DARK,
            fontScale = VisualTestParameters.FontScale.HUGE,
            screenDirection = VisualTestParameters.ScreenDirection.RTL,
            deviceOrientation = VisualTestParameters.DeviceOrientation.LANDSCAPE,
            deviceSize = VisualTestParameters.DeviceSize.SMALL_PHONE
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_extreme_configuration", parameters)
        }
    }

    @Test
    fun testMainActivity_tabletExtremeConfiguration() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.DARK,
            fontScale = VisualTestParameters.FontScale.HUGE,
            screenDirection = VisualTestParameters.ScreenDirection.RTL,
            deviceOrientation = VisualTestParameters.DeviceOrientation.LANDSCAPE,
            deviceSize = VisualTestParameters.DeviceSize.LARGE_TABLET
        )

        activityRule.scenario.onActivity { activity ->
            captureScreenshot(activity, "main_activity_tablet_extreme_configuration", parameters)
        }
    }

    // MARK: - Interaction Tests

    @Test
    fun testMainActivity_afterUserInput() {
        activityRule.scenario.onActivity { activity ->
            // Simulate user filling out the form
            activity.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.nameEditText)
                .setText("Jane Smith")
            activity.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.emailEditText)
                .setText("jane.smith@example.com")
            
            // Change switch states
            activity.findViewById<androidx.appcompat.widget.SwitchCompat>(R.id.notificationsSwitch)
                .isChecked = false
            activity.findViewById<androidx.appcompat.widget.SwitchCompat>(R.id.darkModeSwitch)
                .isChecked = true
            activity.findViewById<androidx.appcompat.widget.SwitchCompat>(R.id.biometricsSwitch)
                .isChecked = false

            captureScreenshot(activity, "main_activity_after_user_input")
        }
    }

    @Test
    fun testMainActivity_afterUserInputRTL() {
        val parameters = VisualTestParameters(
            colorScheme = VisualTestParameters.ColorScheme.LIGHT,
            fontScale = VisualTestParameters.FontScale.NORMAL,
            screenDirection = VisualTestParameters.ScreenDirection.RTL,
            deviceOrientation = VisualTestParameters.DeviceOrientation.PORTRAIT,
            deviceSize = VisualTestParameters.DeviceSize.PHONE
        )

        activityRule.scenario.onActivity { activity ->
            // Simulate user filling out the form in RTL
            activity.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.nameEditText)
                .setText("أحمد محمد")
            activity.findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.emailEditText)
                .setText("ahmed.mohamed@example.com")

            captureScreenshot(activity, "main_activity_after_user_input_rtl", parameters)
        }
    }
} 