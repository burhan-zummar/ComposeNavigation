package com.example.jetpacknavigation.navControllerTypeSafe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable

@Composable
fun TypeSafeNavigationScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenA
    ) {
        composable<ScreenA> {
            LaunchedEffect(key1 = true) {
                delay(3000L)
                navController.navigate(ScreenB) {
                    popUpTo(ScreenA) {
                        inclusive = true
                    }
                }
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "Splash Screen", fontSize = 40.sp)
            }
        }
        composable<ScreenB> {
            var text by remember { mutableStateOf("") }
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 50.dp)
            ) {
                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                        navController.navigate(
                            ScreenC(
                            inputText = text
                        ))
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(text = "To Detail Screen")
                }
            }
        }
        composable<ScreenC> {
            val args = it.toRoute<ScreenC>()
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "Hello, ${args.inputText}")
            }
        }
    }
}

@Serializable
object ScreenA

@Serializable
object ScreenB

@Serializable
data class ScreenC(
    val inputText: String
)

