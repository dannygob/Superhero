package com.example.superhero.data

import com.google.gson.annotations.SerializedName
import androidx.annotation.ColorRes
import com.example.superhero.R


data class SuperheroSearchResponse(
    val results: List<Superhero>
)
data class Superhero(
    val id: String,
    val name: String,
    val image: Image,
    val biography: Biography,
    val work: Work,
    val appearance: Appearance,
    @SerializedName("powerstats") val stats: Stats
)
    @ColorRes
    fun getAlignmentColor() : Int {
        return when (Biography.alignment) {
            "good" -> R.color.alignment_color_good
            "bad" -> R.color.alignment_color_bad
            else -> R.color.alignment_color_neutral
        }
    }
data class Biography(
    @SerializedName("full-name") val realName: String,
    @SerializedName("place-of-birth") val placeOfBirth: String,
    val publisher: String,
    val alignment: String
)
data class Stats(
    var intelligence: Int,
    var strength: Int,
    var speed: Int,
    var durability: Int,
    var power: Int,
    var combat: Int
)

data class Work(
    val occupation: String,
    val base: String
)

data class Appearance (
    val race: String,
    val gender: String,
    @SerializedName("eye-color") val eyeColor: String,
    @SerializedName("hair-color") val hairColor: String,
    val height: List<String>,
    val weight: List<String>,
)

data class Image(
    val url: String
)
