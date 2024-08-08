package com.example.myapparel.View.Screens

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapparel.Model.UiData.ApparelChoicesClass
import com.example.myapparel.Model.UiData.BrowseApparelChoices

@Preview( showSystemUi = true)
@Composable
fun BrowseApparelPreview(){
    BrowseApparel(BrowseApparelChoices.apparelChoices)
}
@Preview
@Composable
fun PreviewBrowseCard(){
    ApparelChoicesCard(apparel = BrowseApparelChoices.apparelChoices[0])
}


@Composable
fun BrowseApparel(
    apparel: List<ApparelChoicesClass>
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
            .padding(30.dp)
    ) {
        Column(
            modifier = Modifier.padding(top = 30.dp)
        ) {
            BrowseHeaderCard()
            LazyColumn(
                modifier = Modifier.padding( top = 20.dp, bottom = 20.dp)
            ) {
                items(apparel){
                    BrowseApparelChoicesCard(apparel = it)
                }
            }
        }
    }

}

@Composable
fun BrowseHeaderCard(){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            colors = CardColors(
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                disabledContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.primaryContainer,
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
        ) {
            Text(
                text = "BROWSE APPAREL",
                fontSize = 30.sp,
                style = MaterialTheme.typography.displayLarge
            )
        }
    }
}


@Composable
fun BrowseApparelChoicesCard( apparel : ApparelChoicesClass){
    Card(modifier = Modifier
        .padding(20.dp),
        colors = CardColors(
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(apparel.image),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = apparel.name,
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


