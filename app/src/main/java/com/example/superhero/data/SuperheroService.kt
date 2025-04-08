package com.example.superhero.data

import retrofit2.http.GET
import retrofit2.http.Path

interface SuperheroService {
    @GET("search/{name}")
    suspend fun findSuperheroesByName(@Path("name") query: String): SuperheroResponse

    @GET("{superhero-id}")
    suspend fun findSuperheroById(@Path("superhero-id") id: String): Superhero
}