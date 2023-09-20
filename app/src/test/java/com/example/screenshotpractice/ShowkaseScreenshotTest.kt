package com.example.screenshotpractice

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onRoot
import com.airbnb.android.showkase.models.Showkase
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import com.github.takahirom.roborazzi.DEFAULT_ROBORAZZI_OUTPUT_DIR_PATH
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.ParameterizedRobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

// https://github.com/DroidKaigi/conference-app-2023/pull/217
@RunWith(ParameterizedRobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(qualifiers = RobolectricDeviceQualifiers.MediumTablet)
class ShowkaseScreenshotTest(
    private val showkaseBrowserComponent: ShowkaseBrowserComponent,
) {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<DummyActivity>()

    @Test
    fun previewScreenshot() {
        val filePath =
            DEFAULT_ROBORAZZI_OUTPUT_DIR_PATH + "/" + showkaseBrowserComponent.group + "_" + showkaseBrowserComponent.componentName + ".png"

        composeTestRule.setContent {
            showkaseBrowserComponent.component()
        }
        composeTestRule
            .onRoot()
            .captureRoboImage(
                filePath = filePath,
                roborazziOptions = DefaultRoborazziOptions,
            )
    }

    companion object {

        @ParameterizedRobolectricTestRunner.Parameters
        @JvmStatic
        fun components(): Iterable<Array<Any?>> {
            return Showkase.getMetadata().componentList.map { showkaseBrowserComponent ->
                arrayOf(showkaseBrowserComponent)
            }
        }
    }
}