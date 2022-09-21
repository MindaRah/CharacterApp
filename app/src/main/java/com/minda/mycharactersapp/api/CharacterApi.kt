package com.minda.mycharactersapp.api

import com.minda.mycharactersapp.model.Characters
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApi {
    @GET("character")
    suspend fun getCharacters(): Response<Characters>



    companion object{
        //https://rickandmortyapi.com/api/character
        const val BASE_URL ="https://rickandmortyapi.com/api/"
    }
}