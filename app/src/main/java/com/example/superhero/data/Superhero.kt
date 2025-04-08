package com.example.superhero.data

class SuperheroResponse (
    val response: String,
    val results: List<Superhero>
) {

}

class Superhero (
    val id: String,
    val name: String,
    val image: Image
) {

}

data class Image (val url: String)
