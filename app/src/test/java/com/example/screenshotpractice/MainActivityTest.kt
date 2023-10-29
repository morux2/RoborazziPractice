package com.example.screenshotpractice

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
// Enable Robolectric Native Graphics (RNG)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class MainActivityTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun captureMainActivity() {
        composeTestRule.captureMultiDevice(
            screenshotName = "MainActivity",
            body = { MainScreen() }
        )
    }
}