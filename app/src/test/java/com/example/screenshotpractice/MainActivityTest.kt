package com.example.screenshotpractice

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onRoot
import androidx.test.runner.AndroidJUnit4
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
// Enable Robolectric Native Graphics (RNG)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class MainActivityTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    @Config(qualifiers = RobolectricDeviceQualifiers.Pixel5)
    fun captureMainActivityPixel5() = captureMainActivity()

    @Test
    // https://github.com/takahirom/roborazzi/issues/47
    @Config(qualifiers = RobolectricDeviceQualifiers.MediumTablet)
    fun captureMainActivityMediumTablet() = captureMainActivity()

    private fun captureMainActivity() {
        composeTestRule
            .onRoot()
            .captureRoboImage(
                roborazziOptions = DefaultRoborazziOptions,
            )
    }
}