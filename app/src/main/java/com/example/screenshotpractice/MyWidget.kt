package com.example.screenshotpractice

import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable

@Composable
fun MyWidget(
    windowWidthSize: WindowWidthSizeClass
) {
    if (windowWidthSize < WindowWidthSizeClass.Medium) {
        Text(text = "phone")
    } else {
        Text(text = "tablet")
    }
}

@MyUIPreview
@Composable
fun MyWidgetPreview() {
    MyWidget(windowWidthSize = WindowWidthSizeClass.Compact)
}

@MyTabletUIPreview
@Composable
fun MyWidgetTabletPreview() {
    MyWidget(WindowWidthSizeClass.Expanded)
}