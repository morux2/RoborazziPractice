package com.example.screenshotpractice

import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performScrollToNode
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class LongContentActivityTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<LongContentActivity>()

    @Test
    fun captureLongContentActivity() {
        composeTestRule.captureMultiDevice(
            screenshotName = "LongContentActivity",
            body = { LongContentScreen() },
            perform = {
                composeTestRule
                    .onNodeWithTag("lazyColumn")
                    .performScrollToNode(hasText("Hello 30"))

            }
        )
    }
}