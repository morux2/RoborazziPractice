package com.example.screenshotpractice

import com.github.takahirom.roborazzi.RoborazziOptions

val DefaultRoborazziOptions =
    RoborazziOptions(
        compareOptions = RoborazziOptions.CompareOptions(changeThreshold = 0f), // Pixel-perfect matching
        recordOptions = RoborazziOptions.RecordOptions(resizeScale = 0.5), // Reduce the size of the PNGs
    )