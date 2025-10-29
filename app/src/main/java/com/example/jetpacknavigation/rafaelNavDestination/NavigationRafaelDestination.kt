package com.example.jetpacknavigation.rafaelNavDestination

import androidx.activity.compose.BackHandler
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
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.ramcosta.composedestinations.generated.NavGraphs
import com.ramcosta.composedestinations.generated.destinations.DetailScreenNewDestination
import com.ramcosta.composedestinations.generated.destinations.MainScreenNewDestination
import com.ramcosta.composedestinations.generated.destinations.SplashScreenNewDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay
import java.time.LocalDateTime

@Composable
fun NavigationRafaelDestination() {
    DestinationsNavHost(navGraph = NavGraphs.root)
}

@Destination<RootGraph>(start = true)
@Composable
fun SplashScreenNew(navigator: DestinationsNavigator) {
    BackHandler(true) { /* We want to disable back clicks */ }

    LaunchedEffect(key1 = true) {
        delay(3000L)
        navigator.navigate(MainScreenNewDestination()) {
            popUpTo(SplashScreenNewDestination) {
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

@Destination<RootGraph>
@Composable
fun MainScreenNew(navigator: DestinationsNavigator) {
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
                navigator.navigate(
                    DetailScreenNewDestination(
                        name = text,
                        User (
                            name = "Directly parse model",
                            id = "user_is"
                        )
                    )
                )
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "To Detail Screen")
        }
    }
}

@Destination<RootGraph>
@Composable
fun DetailScreenNew(name: String?, user: User) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hello, $name")
        Text(text = user.name)
    }
}