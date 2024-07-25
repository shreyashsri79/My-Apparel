package com.example.myapparel.Model.UiData

import android.content.Intent
import androidx.annotation.DrawableRes
import com.example.myapparel.R
import com.example.myapparel.View.AddApparel.AddApparelActivity

data class HomeScreenIconsClass(
 @DrawableRes   val image: Int,
    val name: String,
    val changeTo: String
)

object HomeScreenIcons{
    val homeScreenIcons = listOf(
        HomeScreenIconsClass(R.drawable.closet, "BROWSE\nCLOTHES", "BROWSE"),
        HomeScreenIconsClass(R.drawable.add_clothes, "ADD\nCLOTHES", "ADD"),
    )
}