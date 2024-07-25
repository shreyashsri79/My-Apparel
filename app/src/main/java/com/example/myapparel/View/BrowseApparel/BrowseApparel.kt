package com.example.myapparel.View.BrowseApparel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapparel.Model.UiData.BrowseApparelChoices
import com.example.myapparel.Model.UiData.ApparelChoicesClass

@Preview( showSystemUi = true)
@Composable
fun PreviewAddApparel(){
    BrowseApparel(BrowseApparelChoices.apparelChoices)
}
@Preview
@Composable
fun PreviewCard(){
    ApparelChoicesCard(apparel = BrowseApparelChoices.apparelChoices[0])
}


@Composable
fun BrowseApparel(
    apparel: List<ApparelChoicesClass>
){
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.size(30.dp))
        HeaderCard()
        LazyColumn {
            items(apparel){
                ApparelChoicesCard(apparel = it)
            }
        }
    }
}

@Composable
fun HeaderCard(){
    Card(
    ) {
        Text(
            text = "BROWSE APPAREL",
            fontSize = 30.sp,
            style = MaterialTheme.typography.displayLarge
        )
    }
}

@Composable
fun ApparelChoicesCard( apparel : ApparelChoicesClass){
    Card(modifier = Modifier
        .padding(20.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(apparel.image),
                contentDescription = null
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