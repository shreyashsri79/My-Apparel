package com.example.myapparel.Model.ClothesClass.Torso.Shirt

import com.example.myapparel.Model.ClothesClass.Colors
import com.example.myapparel.Model.ClothesClass.Torso.Torso
import com.example.myapparel.Model.ClothesClass.Torso.TorsoType


abstract class Shirt(
    color: Colors,
    inLaundry : Boolean,
    type: TorsoType = TorsoType.SHIRT,
    val shirtType : ShirtType
): Torso( color, inLaundry, type)

class HalfShirt(
    color: Colors,
    inLaundry : Boolean,
    shirtType : ShirtType
): Shirt( color, inLaundry, shirtType = ShirtType.Half)

class FullShirt(
    color: Colors,
    inLaundry : Boolean,
    shirtType : ShirtType
): Shirt( color, inLaundry, shirtType = ShirtType.Full)