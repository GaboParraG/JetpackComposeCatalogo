package com.example.jetpackcomposecatalogo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyComponents() {

    var myText by rememberSaveable {
        mutableStateOf("")
    }

    //enable maneja un estado para el botom
    var enabled by rememberSaveable {
        mutableStateOf(true)
    }

    var selectText by remember {
        mutableStateOf("")
    }
    var expanded by remember { mutableStateOf(false) }
    val desserts = listOf("Chocolate", "Cafe", "Tinto", "Jugo")

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

    /*OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        modifier = Modifier.padding(30.dp),
        label = { Text(text = "Di algo Gambito") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        ))*/
    /* Column (modifier = Modifier.fillMaxSize()){
         Button(
             onClick = { enabled = false},
             enabled = enabled,
             colors = ButtonDefaults.buttonColors(
                 contentColor = Color.Blue,
                 containerColor = Color.Magenta
             ),
             modifier = Modifier.padding(20.dp),
             border = BorderStroke(1.dp,Color.Green)

         ) {
             Text(text = "Hola Gambito")

         }

         OutlinedButton(
             onClick = { enabled = false},
             enabled = enabled,
             colors = ButtonDefaults.buttonColors(
                 contentColor = Color.Green,
                 containerColor = Color.Transparent
             ),
             modifier = Modifier.padding(20.dp)

         ) {
             Text(text = "Hola Gambito")

         }

     }*/
    /*Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejemplo",
        modifier = Modifier.clip(CircleShape).border(5.dp, Color.Red, CircleShape)
    )*/
    /* CircularProgressIndicator(
         modifier = Modifier.padding(top = 25.dp),
         Color.Red,
         strokeWidth = 2.dp
     )
     LinearProgressIndicator(
         modifier = Modifier.padding(top = 25.dp),
         Color.Red,
         trackColor = Color.Gray
     )*/

    /* BadgedBox ( // (1)
             badge = { // (2)
                 Badge( containerColor = Color.Blue) { // (3)
                     Text(
                         text = "10", color = Color.Red
                     )
                 }
             }, modifier = Modifier.padding(16.dp)) {
         Icon(imageVector = Icons.Default.Star, contentDescription = "")
     }
     Divider(color = Color.Cyan, modifier = Modifier.fillMaxWidth().padding(top = 16.dp))*/

    Column(modifier = Modifier.padding(20.dp)) {

        OutlinedTextField(
            value = selectText,
            onValueChange = { selectText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.padding(20.dp)
        ) {
            desserts.forEach { desserts ->
                DropdownMenuItem(
                    text = { Text(text = desserts) },
                    onClick = {
                        expanded = false
                        selectText = desserts
                    })
            }

        }

    }

}