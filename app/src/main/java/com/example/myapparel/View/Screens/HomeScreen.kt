package com.example.myapparel.View.Screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapparel.Model.UiData.HomeScreenIcons
import com.example.myapparel.Model.UiData.HomeScreenIconsClass
import com.example.myapparel.R
import com.example.ui.theme.displayFontFamily
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapparel.Model.UiData.BrowseApparelChoices
import com.example.myapparel.View.ViewModel.HomeScreenViewModel

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHomeScreen(){
    HomeScreen()
}

@Preview
@Composable
fun PreviewLaundryBar() {
    LaundryBar(Modifier)
}

@Preview
@Composable
fun PreviewOpenBrowseIconCard() {
    BrowseIconCard(
        icon = HomeScreenIcons.BrowseApparel,
        isOpen = true
    )
}

@Preview
@Composable
fun PreviewCloseBrowseIconCard() {
    BrowseIconCard(
        icon = HomeScreenIcons.BrowseApparel,
        isOpen = false
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
){
    Column {
        Spacer(modifier = Modifier.height(100.dp))
        HomeScreenContents()
    }
}

@Composable
fun HomeScreenContents(
    homeScreenViewModel: HomeScreenViewModel = viewModel()
){
    val homeScreenUiState by homeScreenViewModel.homeScreenUiState.collectAsState()

    LaundryBar(Modifier)
    BrowseIconCard(
        isOpen = homeScreenUiState.isBrowseCardOpen,
        open = { homeScreenViewModel.openBrowserCard() },
        close = { homeScreenViewModel.closeBrowserCard() },
    )
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
fun BrowseIconCard(
    icon : HomeScreenIconsClass = HomeScreenIcons.BrowseApparel,
    isOpen : Boolean,
    open : () -> Unit = {},
    close : () -> Unit = {},
    modifier: Modifier = Modifier
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
            if (!isOpen) open()
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(10.dp)
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            if (isOpen){
                BrowseApparel(
                    apparel = BrowseApparelChoices.apparelChoices,
                    close = { close() }
                )
            } else {
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
}
