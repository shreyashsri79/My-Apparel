package com.example.myapparel.View

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme
import com.example.myapparel.Model.UiData.HomeScreenIcons
import com.example.myapparel.R
import com.example.myapparel.View.Screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme( dynamicColor = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(), // Ensure it covers the full screen
                    color = MaterialTheme.colorScheme.primary // Set the background color to primary
                ){
                    AppScreen()
                }
            }
        }
    }
}

@Composable
fun AppScreen(
    modifier: Modifier = Modifier
){
    Scaffold(
        topBar = {
            AppBar()
        },
        floatingActionButton = {
            AddApparelActionButton(
                onAddClothesClick = {
                    /* Ill add it later */
                }
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->

        HomeScreen(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(){
    TopAppBar(
        title = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "My Apparel",
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Preview
@Composable
fun PreviewAddApparelActionButton(){
    AddApparelActionButton( onAddClothesClick = {})
}

@Composable
fun AddApparelActionButton(
    onAddClothesClick: () -> Unit
){
    SmallFloatingActionButton(
        onClick = { onAddClothesClick() },
    ) {
        Card(
            colors = CardColors(
                contentColor = MaterialTheme.colorScheme.onPrimary,
                disabledContentColor = MaterialTheme.colorScheme.onPrimary,
                disabledContainerColor = MaterialTheme.colorScheme.primary,
                containerColor = MaterialTheme.colorScheme.primary
            ),
        ) {
            Column(
                modifier = Modifier.size(60.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.add_clothes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp),
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                )
            }
        }

    }
}