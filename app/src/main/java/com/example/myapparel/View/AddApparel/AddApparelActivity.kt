package com.example.myapparel.View.AddApparel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.compose.AppTheme
import com.example.myapparel.Model.UiData.AddApparelChoices

class AddApparelActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ){
                    AddApparel(AddApparelChoices.apparelChoices)
                }

            }
        }
    }
}

