package com.shubhamtripz.shayricompose_hilt.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.shubhamtripz.shayricompose_hilt.api.ShayriAPI
import com.shubhamtripz.shayricompose_hilt.screen.CategoryScreen
import com.shubhamtripz.shayricompose_hilt.screen.DetailScreen
import com.shubhamtripz.shayricompose_hilt.ui.theme.ShayriComposeHiltTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShayriComposeHiltTheme {
               App()
            }
        }
    }
}

@Composable
fun App(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category") {
        composable(route = "category"){
            CategoryScreen {
                navController.navigate("detail/${it}")
            }
        }
        composable(route = "detail/{category}",
            arguments = listOf(
                navArgument("category"){
                    type = NavType.StringType
                }
            )
        ){
            DetailScreen()
        }
    }
}