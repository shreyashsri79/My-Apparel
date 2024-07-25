package com.example.myapparel.Model.ClothesClass

abstract class MainClothClass(
    val color: Colors,
    var inLaundry : Boolean,
)

enum class Colors{
    BLACK,WHITE,VIBRANT,DARK
}
