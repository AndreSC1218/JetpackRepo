package com.kotlincoders.jetpackrepo.screens.welcome

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun WelcomeScreen(
    onHome:()->Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(

        ) {
            Text(text = "welcome to my app")
            Button(onClick = { onHome() }) {
                Text(text = "go to home :D")
            }
        }
    }
}