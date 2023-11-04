package com.example.screenshotpractice

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onRoot
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.github.takahirom.roborazzi.DEFAULT_ROBORAZZI_OUTPUT_DIR_PATH
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.RoborazziOptions
import com.github.takahirom.roborazzi.captureRoboImage
import org.robolectric.RuntimeEnvironment

// https://github.com/android/nowinandroid/pull/876/files#diff-4d54482e44efb1225f70ed9435e0c5da894e62592a8058f607ef7d3e22ba9e6d

val DefaultRoborazziOptions =
    RoborazziOptions(
        compareOptions = RoborazziOptions.CompareOptions(changeThreshold = 0f), // Pixel-perfect matching
        recordOptions = RoborazziOptions.RecordOptions(resizeScale = 0.5), // Reduce the size of the PNGs
    )

fun <A : ComponentActivity> AndroidComposeTestRule<ActivityScenarioRule<A>, A>.captureComponent(
    screenshotName: String,
    body: @Composable () -> Unit,
    roborazziOptions: RoborazziOptions = DefaultRoborazziOptions,
) {
    val device = if (screenshotName.contains("Tablet")) {
        "tablet" to RobolectricDeviceQualifiers.MediumTablet
    }else {
        "phone" to RobolectricDeviceQualifiers.Pixel6
    }

    // Set qualifiers from specs
    RuntimeEnvironment.setQualifiers(device.second)

    this.activity.setContent {
        CompositionLocalProvider(
            LocalInspectionMode provides true,
        ) {
            body()
        }
    }

    this.onRoot().captureRoboImage(
        "$DEFAULT_ROBORAZZI_OUTPUT_DIR_PATH/$screenshotName-${device.first}.png"
    )
}

fun <A : ComponentActivity> AndroidComposeTestRule<ActivityScenarioRule<A>, A>.captureMultiDevice(
    screenshotName: String,
    body: @Composable () -> Unit,
    perform: () -> Unit = {},
    roborazziOptions: RoborazziOptions = DefaultRoborazziOptions,
) {
    listOf(
        "phone" to RobolectricDeviceQualifiers.Pixel6,
        "tablet" to RobolectricDeviceQualifiers.MediumTablet
    ).forEach { device ->
        // Set qualifiers from specs
        RuntimeEnvironment.setQualifiers(device.second)

        this.activity.setContent {
            CompositionLocalProvider(
                LocalInspectionMode provides true,
            ) {
                body()
            }
        }

        perform()

        this.onRoot().captureRoboImage(
            "$DEFAULT_ROBORAZZI_OUTPUT_DIR_PATH/$screenshotName-${device.first}.png",
            roborazziOptions = roborazziOptions,
        )
    }
}