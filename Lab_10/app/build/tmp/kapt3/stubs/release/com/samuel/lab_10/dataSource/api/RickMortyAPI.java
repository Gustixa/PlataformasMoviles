package com.samuel.lab_10.dataSource.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\'\u00a8\u0006\t"}, d2 = {"Lcom/samuel/lab_10/dataSource/api/RickMortyAPI;", "", "getCharacter", "Lretrofit2/Call;", "Lcom/samuel/lab_10/dataSource/model/CharacterData;", "id", "", "getCharacters", "Lcom/samuel/lab_10/dataSource/model/CharactersResponse;", "app_release"})
public abstract interface RickMortyAPI {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/api/character")
    public abstract retrofit2.Call<com.samuel.lab_10.dataSource.model.CharactersResponse> getCharacters();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/api/character/{id}")
    public abstract retrofit2.Call<com.samuel.lab_10.dataSource.model.CharacterData> getCharacter(@retrofit2.http.Path(value = "id")
    int id);
}