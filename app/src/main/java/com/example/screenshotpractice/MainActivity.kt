package com.example.screenshotpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Surface(
        modifier = Modifier.fillMaxSize().padding(top = 1.dp),
        color = Color.Gray,
        shape = RoundedCornerShape(4.dp)
    ) {
        Text(
            text = "Hello Android!\nHello Android!\nHello Android!",
            color = Color.Black
        )
    }
}

@Preview(name = "MainScreenPreview", group = "MainScreen", showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}