package com.example.screenshotpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

class LongContentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LongContentScreen()
        }
    }
}

@Composable
fun LongContentScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("lazyColumn"),
    ) {
        items(30) {
            Text(
                "Hello ${it + 1}",
                fontSize = 36.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LongContentScreenPreview() {
    LongContentScreen()
}