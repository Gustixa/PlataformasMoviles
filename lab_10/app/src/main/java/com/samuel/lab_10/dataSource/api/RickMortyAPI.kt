package com.samuel.lab_10.dataSource.api

import com.samuel.lab_10.dataSource.model.CharactersResponse
import com.samuel.lab_10.dataSource.model.CharacterData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RickMortyAPI {
    @GET("/api/character")
    fun getCharacters(): Call<CharactersResponse>

    @GET("/api/character/{id}")
    fun getCharacter(
        @Path("id") id : Int
    ): Call<CharacterData>
}