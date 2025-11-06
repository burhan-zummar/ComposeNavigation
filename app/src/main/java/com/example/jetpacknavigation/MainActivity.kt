package com.example.jetpacknavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.jetpacknavigation.navControllerTypeSafe.TypeSafeNavigationScreen
import com.example.jetpacknavigation.rafaelNavDestination.NavigationRafaelDestination

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // using navigation controller
//            Navigation()

            // using rafael destination library
//            NavigationRafaelDestination()

            // using navigation controller + serialization
            TypeSafeNavigationScreen()
        }
    }
}