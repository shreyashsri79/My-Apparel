package com.example.myapparel.View.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
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
import com.example.myapparel.Model.UiData.HomeScreenIcons
import com.example.myapparel.Model.UiData.HomeScreenIconsClass
import com.example.myapparel.R
import com.example.ui.theme.displayFontFamily

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

@Composable
fun HomeScreen(
    icons: List<HomeScreenIconsClass>,
    onBrowseClothesClick : () -> Unit = {},
    onAddClothesClick : () -> Unit = {}
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LaundryBar(Modifier)

        LazyColumn {
            items(icons){
                IconCard(
                    icon = it,
                    onAddClothesClick = onAddClothesClick,
                    onBrowseClothesClick = onBrowseClothesClick
                )
            }
        }
    }
}

@Composable
fun LaundryBar( modifier: Modifier){
    Card(
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
            Image(
                painter = painterResource(id = R.drawable.basketlogo),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp),
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        onClick = {
            if (icon.changeTo.compareTo("ADD") == 0){
                onAddClothesClick()
            }
            else if (icon.changeTo.compareTo("BROWSE") == 0){
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
            Image(
                painter = painterResource(icon.image),
                contentDescription = null,
                modifier = Modifier
                    .size(195.dp)
            )
            Text(
                text = icon.name,
                style = MaterialTheme.typography.displaySmall,
                textAlign = TextAlign.Center
            )
        }
    }
}