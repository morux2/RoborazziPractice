package com.example.screenshotpractice

import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performScrollToNode
import androidx.test.runner.AndroidJUnit4
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class LongContentActivityTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<LongContentActivity>()

    @Test
    @Config(qualifiers = RobolectricDeviceQualifiers.Pixel5)
    fun captureMainActivityPixel5() = captureLongContentActivity()

    @Test
    @Config(qualifiers = RobolectricDeviceQualifiers.MediumTablet)
    fun captureMainActivityMediumTablet() = captureLongContentActivity()

    private fun captureLongContentActivity() {
        composeTestRule
            .onNodeWithTag("lazyColumn")
            .performScrollToNode(hasText("Hello 30"))
            .captureRoboImage(
                roborazziOptions = DefaultRoborazziOptions,
            )
    }
}