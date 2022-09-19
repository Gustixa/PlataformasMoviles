package com.example.lab_8.dataSource.api

import com.example.lab_8.dataSource.model.AllAssetsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyAPI {

    @GET("/character")
    fun getCharacters() : Call<AllAssetsResponse>

    @GET("/character/{id}")
    fun getCharacterByID(
        @Path("id") id: String
    ): Call<AllAssetsResponse>
}