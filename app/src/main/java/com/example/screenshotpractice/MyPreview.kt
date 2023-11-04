package com.example.screenshotpractice

import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(group = "MyUIPreview", device = Devices.PHONE)
public annotation class MyUIPreview
@Preview(group = "MyTabletUIPreview", device = Devices.TABLET)
public annotation class MyTabletUIPreview

@Preview(group = "MyScreenPreview", device = Devices.PHONE)
@Preview(group = "MyScreenPreview", device = Devices.TABLET)
public annotation class MyScreenPreview