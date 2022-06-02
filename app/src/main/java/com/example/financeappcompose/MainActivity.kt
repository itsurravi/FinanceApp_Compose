package com.example.financeappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.financeappcompose.ui.screens.HomeScreenUI
import com.example.financeappcompose.ui.screens.SplashScreenUI
import com.example.financeappcompose.ui.theme.BackgroundColor
import com.example.financeappcompose.ui.theme.FinanceAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinanceAppComposeTheme {
                // A surface container using the 'background' color from the theme
//                val navController = rememberNavController()
//                NavHost(navController = navController, startDestination = "SplashScreen") {
//                    composable("SplashScreen") {
//                        Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
//                            SplashScreenUI(navController)
//                        }
//                    }
//                    composable("HomeScreen") {
//                        HomeScreenUI()
//                    }
//                }
                Surface(color = BackgroundColor, modifier = Modifier.fillMaxSize()) {
                    HomeScreenUI()
                }
            }
        }
    }
}