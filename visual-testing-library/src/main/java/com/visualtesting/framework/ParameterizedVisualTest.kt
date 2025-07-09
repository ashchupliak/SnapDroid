package com.visualtesting.framework

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.testing.FragmentScenario
import androidx.test.core.app.ActivityScenario
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import org.junit.runner.RunWith

/**
 * Base class for parameterized visual testing with comprehensive configuration support
 * Uses TestParameterInjector for automatic parameter injection
 */
@RunWith(TestParameterInjector::class)
abstract class ParameterizedVisualTest : BaseVisualTest() {

    /**
     * Takes a screenshot of a Fragment with parameterized visual test parameters
     */
    fun <F : Fragment> compareParameterizedScreenshot(
        scenario: FragmentScenario<F>,
        name: String,
        @TestParameter colorScheme: ColorScheme,
        @TestParameter fontScale: FontScale,
        screenDirection: ScreenDirection = ScreenDirection.LTR,
        deviceOrientation: DeviceOrientation = DeviceOrientation.PORTRAIT,
        deviceSize: DeviceSize = DeviceSize.PHONE_MEDIUM,
        heightInPx: Int? = null,
        widthInPx: Int? = null
    ) {
        compareScreenshot(
            scenario = scenario,
            name = name,
            colorScheme = colorScheme,
            fontScale = fontScale,
            screenDirection = screenDirection,
            deviceOrientation = deviceOrientation,
            deviceSize = deviceSize,
            heightInPx = heightInPx,
            widthInPx = widthInPx
        )
    }

    /**
     * Takes a screenshot of an Activity with parameterized visual test parameters
     */
    fun <A : FragmentActivity> compareParameterizedScreenshot(
        scenario: ActivityScenario<A>,
        name: String,
        @TestParameter colorScheme: ColorScheme,
        @TestParameter fontScale: FontScale,
        screenDirection: ScreenDirection = ScreenDirection.LTR,
        deviceOrientation: DeviceOrientation = DeviceOrientation.PORTRAIT,
        deviceSize: DeviceSize = DeviceSize.PHONE_MEDIUM,
        heightInPx: Int? = null,
        widthInPx: Int? = null
    ) {
        compareScreenshot(
            scenario = scenario,
            name = name,
            colorScheme = colorScheme,
            fontScale = fontScale,
            screenDirection = screenDirection,
            deviceOrientation = deviceOrientation,
            deviceSize = deviceSize,
            heightInPx = heightInPx,
            widthInPx = widthInPx
        )
    }

    /**
     * Takes a screenshot with RTL-specific parameterized testing
     */
    fun <F : Fragment> compareRTLScreenshot(
        scenario: FragmentScenario<F>,
        name: String,
        @TestParameter colorScheme: ColorScheme,
        @TestParameter fontScale: FontScale,
        @TestParameter screenDirection: ScreenDirection,
        deviceOrientation: DeviceOrientation = DeviceOrientation.PORTRAIT,
        deviceSize: DeviceSize = DeviceSize.PHONE_MEDIUM,
        heightInPx: Int? = null,
        widthInPx: Int? = null
    ) {
        compareScreenshot(
            scenario = scenario,
            name = name,
            colorScheme = colorScheme,
            fontScale = fontScale,
            screenDirection = screenDirection,
            deviceOrientation = deviceOrientation,
            deviceSize = deviceSize,
            heightInPx = heightInPx,
            widthInPx = widthInPx
        )
    }

    /**
     * Takes a screenshot with device-specific parameterized testing
     */
    fun <F : Fragment> compareDeviceScreenshot(
        scenario: FragmentScenario<F>,
        name: String,
        @TestParameter colorScheme: ColorScheme,
        @TestParameter fontScale: FontScale,
        @TestParameter deviceSize: DeviceSize,
        screenDirection: ScreenDirection = ScreenDirection.LTR,
        deviceOrientation: DeviceOrientation = DeviceOrientation.PORTRAIT,
        heightInPx: Int? = null,
        widthInPx: Int? = null
    ) {
        compareScreenshot(
            scenario = scenario,
            name = name,
            colorScheme = colorScheme,
            fontScale = fontScale,
            screenDirection = screenDirection,
            deviceOrientation = deviceOrientation,
            deviceSize = deviceSize,
            heightInPx = heightInPx,
            widthInPx = widthInPx
        )
    }

    /**
     * Comprehensive screenshot testing with all parameters
     */
    fun <F : Fragment> compareComprehensiveScreenshot(
        scenario: FragmentScenario<F>,
        name: String,
        @TestParameter colorScheme: ColorScheme,
        @TestParameter fontScale: FontScale,
        @TestParameter screenDirection: ScreenDirection,
        @TestParameter deviceOrientation: DeviceOrientation,
        @TestParameter deviceSize: DeviceSize,
        heightInPx: Int? = null,
        widthInPx: Int? = null
    ) {
        compareScreenshot(
            scenario = scenario,
            name = name,
            colorScheme = colorScheme,
            fontScale = fontScale,
            screenDirection = screenDirection,
            deviceOrientation = deviceOrientation,
            deviceSize = deviceSize,
            heightInPx = heightInPx,
            widthInPx = widthInPx
        )
    }
} 