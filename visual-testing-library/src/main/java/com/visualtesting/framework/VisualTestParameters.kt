package com.visualtesting.framework

/**
 * Enum for color scheme variations in visual tests
 */
enum class ColorScheme(val value: String) {
    LIGHT("light"),
    DARK("dark");

    override fun toString(): String = value
}

/**
 * Enum for font scale variations in visual tests
 */
enum class FontScale(val value: Float, val suffix: String) {
    DEFAULT(1.0f, "default"),
    LARGER(1.3f, "larger"),
    LARGEST(1.5f, "largest");

    override fun toString(): String = "${suffix}FontScale"
}

/**
 * Enum for screen direction variations in visual tests
 */
enum class ScreenDirection(val value: Boolean) {
    LTR(false),
    RTL(true);

    override fun toString(): String = when(this) {
        LTR -> "ltr"
        RTL -> "rtl"
    }
}

/**
 * Enum for device orientation variations in visual tests
 */
enum class DeviceOrientation(val value: String) {
    PORTRAIT("portrait"),
    LANDSCAPE("landscape");

    override fun toString(): String = value
}

/**
 * Enum for device size variations in visual tests
 */
enum class DeviceSize(val width: Int, val height: Int, val density: Float, val name: String) {
    PHONE_SMALL(320, 568, 2.0f, "phone_small"),
    PHONE_MEDIUM(360, 640, 3.0f, "phone_medium"),
    PHONE_LARGE(411, 823, 2.625f, "phone_large"),
    TABLET_SMALL(600, 960, 2.0f, "tablet_small"),
    TABLET_LARGE(800, 1280, 2.0f, "tablet_large");

    override fun toString(): String = name
} 