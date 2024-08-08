package com.example.myapparel.View.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat.Action
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapparel.Model.UiData.AddApparelChoices
import com.example.myapparel.Model.UiData.BrowseApparelChoices
import com.example.myapparel.Model.UiData.HomeScreenIcons
import com.example.myapparel.Model.UiData.HomeScreenIconsClass
import com.example.myapparel.R
import com.example.myapparel.View.AllScreens
import com.example.ui.theme.displayFontFamily
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHomeScreen(){
    HomeScreen(HomeScreenIcons.homeScreenIcons)
}

@Preview
@Composable
fun PreviewLaundryBar() {
    LaundryBar(Modifier)
}

@Preview
@Composable
fun PreviewIconCard() {
    IconCard(HomeScreenIcons.homeScreenIcons[0])
}

enum class HomeScreenScreens(){
    HomeScreenContents,
    BrowseApparelScreen
}

@Composable
fun HomeScreen(
    icons: List<HomeScreenIconsClass>,
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
){
    Column {
        Spacer(modifier = Modifier.height(100.dp))
        LaundryBar(modifier = modifier)
        NavHost(
            navController = navController,
            startDestination = HomeScreenScreens.HomeScreenContents.name,
            modifier = Modifier
        ) {
            composable(route = HomeScreenScreens.BrowseApparelScreen.name){
                BrowseApparel(apparel = BrowseApparelChoices.apparelChoices)
            }
            composable(route = HomeScreenScreens.HomeScreenContents.name){
                HomeScreenContents(
                    icons = icons,
                    onBrowseClothesClick = { navController.navigate(route = HomeScreenScreens.BrowseApparelScreen.name) }
                )
            }
        }
    }
}

@Composable
fun HomeScreenContents(
    icons: List<HomeScreenIconsClass>,
    onBrowseClothesClick : () -> Unit = {},
    onAddClothesClick : () -> Unit = {},
){
    LazyColumn() {
        items(icons){
            IconCard(
                icon = it,
                onAddClothesClick = onAddClothesClick,
                onBrowseClothesClick = onBrowseClothesClick
            )
        }
    }
}

@Composable
fun LaundryBar( modifier: Modifier){
    Card(
        colors = CardColors(
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.primaryContainer,
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .padding(30.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.basketlogo),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp),
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Column(
                modifier = Modifier
                    .padding(start = 20.dp),
            ) {
                Text(
                    text = "0",
                    fontSize = 32.sp,
                    fontFamily = displayFontFamily
                )
                Text(
                    text = stringResource(R.string.clothes_in_laundry),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun IconCard(
    icon : HomeScreenIconsClass,
    onBrowseClothesClick : () -> Unit = {},
    onAddClothesClick : () -> Unit = {}
    ){
    Card(
        colors = CardColors(
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.primaryContainer,
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        onClick = {
            if (icon.changeTo == AllScreens.BrowseApparelScreen){
                onBrowseClothesClick()
            }
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(icon.image),
                contentDescription = null,
                modifier = Modifier
                    .size(195.dp),
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}
