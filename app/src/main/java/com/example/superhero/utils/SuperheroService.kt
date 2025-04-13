package com.example.superhero.utils

import com.example.superhero.data.Superhero
import com.example.superhero.data.SuperheroResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperheroService {
    @GET("search/{name}")
    suspend fun findSuperheroesByName(@Path("name") query: String): SuperheroResponse

    @GET("{superhero-id}")
    suspend fun findSuperheroById(@Path("superhero-id") id: String): Superhero

    companion object{

        fun getInstance(): SuperheroService {
            val retrofit = Retrofit.Builder()
             .baseUrl("https://superheroapi.com/api/7252591128153666/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

                return retrofit.create(SuperheroService::class.java)


        }
}


}