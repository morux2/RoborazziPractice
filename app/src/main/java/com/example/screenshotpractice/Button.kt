package com.example.screenshotpractice

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyButton() {
    Button(onClick = {}) {
        Text(text = "Hello")
    }
}

@MyUIPreview
@Composable
fun ButtonPreview() {
    MyButton()
}