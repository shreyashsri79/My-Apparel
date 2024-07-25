package com.example.myapparel.View

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.myapparel.Model.UiData.AddApparelChoices
import com.example.myapparel.Model.UiData.BrowseApparelChoices
import com.example.myapparel.Model.UiData.HomeScreenIcons
import com.example.myapparel.View.Screens.AddApparel
import com.example.myapparel.View.Screens.BrowseApparel
import com.example.myapparel.View.Screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ){
                    AppScreen()
                }
            }
        }
    }
}

enum class AllScreens(){
    HomeScreen,
    AddApparelScreen,
    BrowseApparelScreen
}

@Composable
fun AppScreen(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
){
    Scaffold(
        topBar = {

        }
    ) { innerPadding ->
        
        NavHost(
            navController = navController,
            startDestination = AllScreens.HomeScreen.name,
            modifier = Modifier.padding(innerPadding)
            ) {
            composable(route = AllScreens.HomeScreen.name){
                HomeScreen(
                    icons = HomeScreenIcons.homeScreenIcons,
                    onAddClothesClick = { navController.navigate(route = AllScreens.AddApparelScreen.name)},
                    onBrowseClothesClick = { navController.navigate(route = AllScreens.BrowseApparelScreen.name)}
                )
            }
            composable(route = AllScreens.AddApparelScreen.name){
                AddApparel(apparel = AddApparelChoices.apparelChoices)
            }
            composable(route = AllScreens.BrowseApparelScreen.name){
                BrowseApparel(apparel = BrowseApparelChoices.apparelChoices)
            }
        }
    }
}

