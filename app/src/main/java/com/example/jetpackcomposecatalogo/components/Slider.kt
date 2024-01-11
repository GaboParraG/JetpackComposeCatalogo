package com.example.jetpackcomposecatalogo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

@Composable
fun MySlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderposition by rememberSaveable {
            mutableStateOf(0f)
        }
        var completeValue by rememberSaveable {
            mutableStateOf("0f")
        }
        Slider(
            value = sliderposition,
            onValueChange = { sliderposition = it },
            onValueChangeFinished = { completeValue = sliderposition.toString() },
            valueRange = 0f..10f,
            steps = 9)
        Text(text = sliderposition.toString())
    }
}