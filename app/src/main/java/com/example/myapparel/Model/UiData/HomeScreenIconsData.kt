package com.example.myapparel.Model.UiData

import androidx.annotation.DrawableRes
import com.example.myapparel.R

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