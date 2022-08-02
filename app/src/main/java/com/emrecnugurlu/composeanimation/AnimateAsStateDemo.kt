package com.emrecnugurlu.composeanimation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimateAsStateDemo() {

    var colorIsBlue by remember {
       mutableStateOf(true)
    }

    val color by animateColorAsState(
        targetValue = if (colorIsBlue) Color.Blue else Color.Red,
        animationSpec = tween(durationMillis = 3000, easing = FastOutSlowInEasing)
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            colorIsBlue = !colorIsBlue
        }) {
            Text(text = "Change Color")
        }
        Spacer(modifier = Modifier.padding(bottom = 20.dp))
        Box(modifier = Modifier
            .size(128.dp)
            .background(color = color))
    }
}