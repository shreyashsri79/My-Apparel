package com.example.myapparel.Model.UiData

import androidx.annotation.DrawableRes
import com.example.myapparel.R

data class HomeScreenIconsClass(
 @DrawableRes   val image: Int,
    val name: String,
)

object HomeScreenIcons{
    val BrowseApparel = HomeScreenIconsClass(R.drawable.closet, "BROWSE\nCLOTHES",)
}