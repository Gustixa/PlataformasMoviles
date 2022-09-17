package com.example.lab_8.dataSource.api

import com.example.lab_8.dataSource.model.AllAssetsResponse
import retrofit2.Call
import retrofit2.http.GET

class RickAndMortyAPI {

    @GET("/api/character")
    fun getCharacter():Call<AllAssetsResponse>
}