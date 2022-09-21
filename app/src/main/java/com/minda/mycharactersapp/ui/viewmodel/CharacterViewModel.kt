package com.minda.mycharactersapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.minda.mycharactersapp.repository.CharactersRepo
import com.minda.mycharactersapp.util.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class CharacterViewModel @Inject constructor(private val characterRepo: CharactersRepo): ViewModel() {

    private val _character: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val characters: LiveData<UIState> get() = _character

    fun getCharacter() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = characterRepo.getCharacters()
                if(response.isSuccessful){
                    response.body()?.let {
                        _character.postValue(UIState.SUCCESS(it))
                    } ?: throw Exception("Data null")
                } else {
                    throw Exception(response.errorBody().toString())
                }
            }catch (e: Exception){
                withContext(Dispatchers.Main){
                    _character.postValue(UIState.ERROR(e))
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}