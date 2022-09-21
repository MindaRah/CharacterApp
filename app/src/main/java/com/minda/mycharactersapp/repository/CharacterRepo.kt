package com.minda.mycharactersapp.repository

import com.minda.mycharactersapp.api.CharacterApi
import com.minda.mycharactersapp.model.Characters
import retrofit2.Response
import javax.inject.Inject

interface CharactersRepo {
    suspend fun getCharacters():Response<Characters>
}

class CharacterRepositoryImpl @Inject constructor(
    private val characterApi: CharacterApi
): CharactersRepo{
    override suspend fun getCharacters(): Response<Characters> {
        return characterApi.getCharacters()
    }

}