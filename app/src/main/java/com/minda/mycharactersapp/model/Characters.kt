package com.minda.mycharactersapp.model


import com.google.gson.annotations.SerializedName

data class Characters(
    @SerializedName("info")
    val info: Info = Info(),
    @SerializedName("results")
    val results: List<Result> = listOf()
)