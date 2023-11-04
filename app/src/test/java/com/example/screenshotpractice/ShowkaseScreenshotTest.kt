package com.example.screenshotpractice

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.airbnb.android.showkase.models.Showkase
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.ParameterizedRobolectricTestRunner
import org.robolectric.annotation.GraphicsMode

// https://github.com/DroidKaigi/conference-app-2023/pull/217
@RunWith(ParameterizedRobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class ShowkaseScreenshotTest(
    private val showkaseBrowserComponent: ShowkaseBrowserComponent,
) {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<DummyActivity>()

    @Test
    fun takeScreenShot() {
        val screenshotName =
            "${showkaseBrowserComponent.group}-${showkaseBrowserComponent.componentName}"

        if (showkaseBrowserComponent.group.contains("Screen")) {
            composeTestRule.captureMultiDevice(
                screenshotName = screenshotName,
                body = showkaseBrowserComponent.component
            )
        }

        if (showkaseBrowserComponent.group.contains("UI")) {
            composeTestRule.captureComponent(
                screenshotName = screenshotName,
                body = showkaseBrowserComponent.component
            )
        }
    }

    companion object {

        @ParameterizedRobolectricTestRunner.Parameters
        @JvmStatic
        fun components(): Iterable<Array<Any?>> {
            return Showkase.getMetadata().componentList.map {
                it.copy(componentName = it.componentName.split(" ")[0])
            }.distinctBy {
                it.componentName
            }.map { showkaseBrowserComponent ->
                arrayOf(showkaseBrowserComponent)
            }
        }
    }
}