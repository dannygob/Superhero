package com.example.superhero.data

import com.google.android.material.color.utilities.Variant
import com.google.gson.annotations.SerializedName


data class SuperheroResponse (
    //val response: String,
    val results: List<Superhero>
)

data class Superhero (
    val id: String,
    val name: String,
    val image: Image,
    val biography: Biography,
    @SerializedName("powerstats") val stats : Stats
)

    data class  Biography(
        @SerializedName("full-name") val realName : String,
        @SerializedName("place-of-birth") val placeOfBirth : String,
        val publisher: String,
        val alignment: String

    )
data class Stats (
    var intelligence: String,
    var strength: String,
    var speed: Image,
    var durability: String,
    var power: String,
    var combat: String
)


data class Image (
    val url: String)
