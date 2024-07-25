package com.example.myapparel.Model.UiData

import androidx.annotation.DrawableRes
import com.example.myapparel.R

data class ApparelChoicesClass(
@DrawableRes    val image: Int,
    val name: String
)

object AddApparelChoices{
    val apparelChoices = listOf(
        ApparelChoicesClass(R.drawable.shirt, "Add\nTorso"),
        ApparelChoicesClass(R.drawable.shorts, "Add\nLegs"),
        ApparelChoicesClass(R.drawable.shoes, "Add\nShoes"),
        ApparelChoicesClass(R.drawable.wristwatch, "Add\nAcces\nsories"),
        ApparelChoicesClass(R.drawable.kurta, "Add\nEthenic\nWears"),
        ApparelChoicesClass(R.drawable.coats, "Add\nFormal\nWears"),
    )
}