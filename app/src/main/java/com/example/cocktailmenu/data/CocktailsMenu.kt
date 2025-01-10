package com.example.cocktailmenu.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CocktailsMenu(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable