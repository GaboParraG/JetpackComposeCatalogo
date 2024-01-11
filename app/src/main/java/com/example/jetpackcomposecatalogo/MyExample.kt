package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

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