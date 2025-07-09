package com.visualtesting.framework

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.testing.FragmentScenario
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import com.karumi.shot.ScreenshotTest
import org.junit.Before
import java.util.*

/**
 * Base class for visual testing with comprehensive configuration support
 */
abstract class BaseVisualTest : ScreenshotTest {

    protected lateinit var context: Context
    protected lateinit var instrumentationContext: Context

    @Before
    open fun setUp() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }

    /**
     * Takes a screenshot of a Fragment with specified visual test parameters
     */
    fun <F : Fragment> compareScreenshot(
        scenario: FragmentScenario<F>,
        name: String,
        colorScheme: ColorScheme = ColorScheme.LIGHT,
        fontScale: FontScale = FontScale.DEFAULT,
        screenDirection: ScreenDirection = ScreenDirection.LTR,
        deviceOrientation: DeviceOrientation = DeviceOrientation.PORTRAIT,
        deviceSize: DeviceSize = DeviceSize.PHONE_MEDIUM,
        heightInPx: Int? = null,
        widthInPx: Int? = null
    ) {
        var fragment: Fragment? = null
        scenario.onFragment { fragment = it }
        
        // Apply visual test configuration
        applyVisualTestConfiguration(
            fragment!!.requireView(),
            colorScheme,
            fontScale,
            screenDirection,
            deviceOrientation,
            deviceSize
        )
        
        val screenshotName = buildScreenshotName(name, colorScheme, fontScale, screenDirection, deviceOrientation, deviceSize)
        
        // Take screenshot using Shot library
        compareScreenshot(fragment!!, heightInPx, widthInPx, screenshotName)
    }

    /**
     * Takes a screenshot of an Activity with specified visual test parameters
     */
    fun <A : FragmentActivity> compareScreenshot(
        scenario: ActivityScenario<A>,
        name: String,
        colorScheme: ColorScheme = ColorScheme.LIGHT,
        fontScale: FontScale = FontScale.DEFAULT,
        screenDirection: ScreenDirection = ScreenDirection.LTR,
        deviceOrientation: DeviceOrientation = DeviceOrientation.PORTRAIT,
        deviceSize: DeviceSize = DeviceSize.PHONE_MEDIUM,
        heightInPx: Int? = null,
        widthInPx: Int? = null
    ) {
        var activity: Activity? = null
        scenario.onActivity { activity = it }
        
        // Apply visual test configuration
        applyVisualTestConfiguration(
            activity!!.findViewById(android.R.id.content),
            colorScheme,
            fontScale,
            screenDirection,
            deviceOrientation,
            deviceSize
        )
        
        val screenshotName = buildScreenshotName(name, colorScheme, fontScale, screenDirection, deviceOrientation, deviceSize)
        
        // Take screenshot using Shot library
        compareScreenshot(activity!!, heightInPx, widthInPx, screenshotName)
    }

    /**
     * Takes a screenshot of a View with specified visual test parameters
     */
    fun compareScreenshot(
        view: View,
        name: String,
        colorScheme: ColorScheme = ColorScheme.LIGHT,
        fontScale: FontScale = FontScale.DEFAULT,
        screenDirection: ScreenDirection = ScreenDirection.LTR,
        deviceOrientation: DeviceOrientation = DeviceOrientation.PORTRAIT,
        deviceSize: DeviceSize = DeviceSize.PHONE_MEDIUM,
        heightInPx: Int? = null,
        widthInPx: Int? = null
    ) {
        // Apply visual test configuration
        applyVisualTestConfiguration(
            view,
            colorScheme,
            fontScale,
            screenDirection,
            deviceOrientation,
            deviceSize
        )
        
        val screenshotName = buildScreenshotName(name, colorScheme, fontScale, screenDirection, deviceOrientation, deviceSize)
        
        // Take screenshot using Shot library
        compareScreenshot(view, heightInPx, widthInPx, screenshotName)
    }

    /**
     * Applies visual test configuration to a view
     */
    private fun applyVisualTestConfiguration(
        view: View,
        colorScheme: ColorScheme,
        fontScale: FontScale,
        screenDirection: ScreenDirection,
        deviceOrientation: DeviceOrientation,
        deviceSize: DeviceSize
    ) {
        // Apply color scheme (theme)
        applyColorScheme(view, colorScheme)
        
        // Apply font scale
        applyFontScale(view, fontScale)
        
        // Apply screen direction (RTL/LTR)
        applyScreenDirection(view, screenDirection)
        
        // Apply device orientation
        applyDeviceOrientation(view, deviceOrientation)
        
        // Apply device size
        applyDeviceSize(view, deviceSize)
    }

    /**
     * Applies color scheme to the view
     */
    private fun applyColorScheme(view: View, colorScheme: ColorScheme) {
        when (colorScheme) {
            ColorScheme.LIGHT -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    view.context.setTheme(android.R.style.Theme_DeviceDefault_Light)
                }
            }
            ColorScheme.DARK -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    view.context.setTheme(android.R.style.Theme_DeviceDefault)
                }
            }
        }
    }

    /**
     * Applies font scale to the view
     */
    private fun applyFontScale(view: View, fontScale: FontScale) {
        val configuration = Configuration(view.context.resources.configuration)
        configuration.fontScale = fontScale.value
        view.context.resources.updateConfiguration(configuration, view.context.resources.displayMetrics)
    }

    /**
     * Applies screen direction (RTL/LTR) to the view
     */
    private fun applyScreenDirection(view: View, screenDirection: ScreenDirection) {
        val configuration = Configuration(view.context.resources.configuration)
        configuration.layoutDirection = when (screenDirection) {
            ScreenDirection.LTR -> View.LAYOUT_DIRECTION_LTR
            ScreenDirection.RTL -> View.LAYOUT_DIRECTION_RTL
        }
        view.context.resources.updateConfiguration(configuration, view.context.resources.displayMetrics)
        
        // Force RTL if needed
        if (screenDirection == ScreenDirection.RTL) {
            view.layoutDirection = View.LAYOUT_DIRECTION_RTL
        }
    }

    /**
     * Applies device orientation to the view
     */
    private fun applyDeviceOrientation(view: View, deviceOrientation: DeviceOrientation) {
        val configuration = Configuration(view.context.resources.configuration)
        configuration.orientation = when (deviceOrientation) {
            DeviceOrientation.PORTRAIT -> Configuration.ORIENTATION_PORTRAIT
            DeviceOrientation.LANDSCAPE -> Configuration.ORIENTATION_LANDSCAPE
        }
        view.context.resources.updateConfiguration(configuration, view.context.resources.displayMetrics)
    }

    /**
     * Applies device size to the view
     */
    private fun applyDeviceSize(view: View, deviceSize: DeviceSize) {
        val displayMetrics = view.context.resources.displayMetrics
        displayMetrics.widthPixels = (deviceSize.width * deviceSize.density).toInt()
        displayMetrics.heightPixels = (deviceSize.height * deviceSize.density).toInt()
        displayMetrics.density = deviceSize.density
        displayMetrics.densityDpi = (160 * deviceSize.density).toInt()
    }

    /**
     * Builds a screenshot name based on test parameters
     */
    private fun buildScreenshotName(
        name: String,
        colorScheme: ColorScheme,
        fontScale: FontScale,
        screenDirection: ScreenDirection,
        deviceOrientation: DeviceOrientation,
        deviceSize: DeviceSize
    ): String {
        val parts = mutableListOf<String>()
        parts.add(name)
        parts.add(colorScheme.toString())
        
        if (fontScale != FontScale.DEFAULT) {
            parts.add(fontScale.toString())
        }
        
        if (screenDirection != ScreenDirection.LTR) {
            parts.add("${screenDirection}ScreenDirection")
        }
        
        if (deviceOrientation != DeviceOrientation.PORTRAIT) {
            parts.add(deviceOrientation.toString())
        }
        
        if (deviceSize != DeviceSize.PHONE_MEDIUM) {
            parts.add(deviceSize.toString())
        }
        
        return parts.joinToString("_")
    }
} 