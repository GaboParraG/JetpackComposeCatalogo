package com.example.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyComponents()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyComponents() {

    var myText by rememberSaveable {
        mutableStateOf("")
    }
   /* Text(
        text = "Hola Gambito",
        color = Color.Red,
        fontSize = 30.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = FontFamily.Cursive
    )*/

   /* TextField(
        value = myText,
        onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }
        },
        label = { Text(text = "Di algo Gambito") })*/

    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        modifier = Modifier.padding(30.dp),
        label = { Text(text = "Di algo Gambito") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        ))

}

@Composable
fun MyState() {
    //rememberSaveable : Permite mantener la fata cuando la actividad se destruye y se vuelve a crear
    //var counter = rememberSaveable { mutableStateOf(0) }
    //by nos permite ahorranos el .value
    var counter by rememberSaveable { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")

        }
        Text(text = "Se a pulsado $counter veces")

    }

}

@Composable
fun MyExample() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(color = Color.Blue)
            )
            Spacer(
                modifier = Modifier
                    .width(0.dp)
                    .height(5.dp)
                    .background(color = Color.White)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(color = Color.Red)
            ) {
                ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                    val (boxWhite, boxGray, boxMagenta, boxBlack, boxYellow) = createRefs()

                    Box(modifier = Modifier
                        .size(55.dp)
                        .background(Color.White)
                        .constrainAs(boxWhite) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                        })
                    Box(modifier = Modifier
                        .size(55.dp)
                        .background(Color.Gray)
                        .constrainAs(boxGray) {
                            bottom.linkTo(boxWhite.top)
                            end.linkTo(boxWhite.start)
                        })
                    Box(modifier = Modifier
                        .size(55.dp)
                        .background(Color.Magenta)
                        .constrainAs(boxMagenta) {
                            bottom.linkTo(boxWhite.top)
                            start.linkTo(boxWhite.end)
                        })
                    Box(modifier = Modifier
                        .size(55.dp)
                        .background(Color.Black)
                        .constrainAs(boxBlack) {
                            top.linkTo(boxWhite.bottom)
                            end.linkTo(boxWhite.start)
                        })
                    Box(modifier = Modifier
                        .size(55.dp)
                        .background(Color.Yellow)
                        .constrainAs(boxYellow) {
                            top.linkTo(boxWhite.bottom)
                            start.linkTo(boxWhite.end)
                        })
                }
            }
            Spacer(
                modifier = Modifier
                    .width(0.dp)
                    .height(5.dp)
                    .background(color = Color.White)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(color = Color.Magenta)
            ) {
                Row {
                    Box(
                        modifier = Modifier
                            .size(125.dp)
                            .background(Color.Yellow)
                    )
                    Spacer(
                        modifier = Modifier
                            .width(5.dp)
                            .height(0.dp)
                            .background(color = Color.Blue)
                    )
                    Box(
                        modifier = Modifier
                            .size(125.dp)
                            .background(Color.Red)
                    )
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeCatalogoTheme {
        MyComponents()
    }
}