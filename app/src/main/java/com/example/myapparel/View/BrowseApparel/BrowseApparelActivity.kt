package com.example.myapparel.View.BrowseApparel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.compose.AppTheme
import com.example.myapparel.View.AddApparel.AddApparel
import com.example.myapparel.Model.UiData.BrowseApparelChoices

class BrowseApparelActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ){
                    BrowseApparel(BrowseApparelChoices.apparelChoices)
                }

            }
        }
    }
}
