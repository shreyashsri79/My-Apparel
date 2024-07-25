package com.example.myapparel.Model.ClothesClass.Torso


import com.example.myapparel.Model.ClothesClass.Colors
import com.example.myapparel.Model.ClothesClass.MainClothClass


abstract class Torso(
    color: Colors,
    inLaundry : Boolean,
    val torsoType: TorsoType
): MainClothClass( color, inLaundry)


