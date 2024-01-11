package com.example.jetpackcomposecatalogo.dialogs

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun MyDialogs() {
    var show by remember {
        mutableStateOf(false)
    }
    Button(onClick = { show = true }) {
        Text(text = "Mostrar dialogo")
    }
    if (show) {
        AlertDialog(
            onDismissRequest = { show = false},
            confirmButton = {
                TextButton(onClick = { }) {
                    Text(text = "Confirmacion")
                }
            },
            dismissButton = {
                TextButton(onClick = {show = false }) {
                    Text(text = "Dismiss")
                }
            },
            title = { Text(text = "Titulo") },
            text = { Text(text = "Soy Gambito") })
    }
}