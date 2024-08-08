package com.example.myapparel.Model.UiData

import androidx.annotation.DrawableRes
import com.example.myapparel.R
import com.example.myapparel.View.AllScreens

data class HomeScreenIconsClass(
 @DrawableRes   val image: Int,
    val name: String,
    val changeTo: AllScreens
)

object HomeScreenIcons{
    val homeScreenIcons = listOf(
        HomeScreenIconsClass(R.drawable.closet, "BROWSE\nCLOTHES", AllScreens.BrowseApparelScreen),
    )
}