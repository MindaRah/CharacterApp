package com.minda.mycharactersapp.util

import com.minda.mycharactersapp.model.Characters

sealed class UIState{
    object LOADING: UIState()
    data class SUCCESS(val response: Characters): UIState()
    data class ERROR(val error: Exception): UIState()
}