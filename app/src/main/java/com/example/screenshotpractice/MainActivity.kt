package com.example.screenshotpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

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
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(text = "Hello Android!\nHello Android!\nHello Android!")
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.heart))
        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever
        )
    }
}

@MyScreenPreview
@Composable
fun MainScreenPreview() {
    MainScreen()
}