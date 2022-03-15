package com.example.models

import com.google.gson.annotations.SerializedName

class PokemonModel {
    data class Response (
        @SerializedName("count")
        val count: Long,
        @SerializedName("next")
        val next: String,
        @SerializedName("previous")
        val previous: Any? = null,
        @SerializedName("results")
        val results: List<Result>
    )

    data class Result (
        @SerializedName("name")
        val name: String,
        @SerializedName("url")
        val url: String
    )}
