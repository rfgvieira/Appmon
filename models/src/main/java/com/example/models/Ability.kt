package com.example.models

import com.google.gson.annotations.SerializedName

class AbilityModel {
    data class Reponse (
        @SerializedName("effect_entries")
        val effectEntries: List<EffectEntry>,
        @SerializedName("names")
        val names: List<Name>
    )

    data class EffectEntry (
        @SerializedName("effect")
        val effect: String,

        @SerializedName("language")
        val language: Generation,

        @SerializedName("short_effect")
        val shortEffect: String
    )

    data class Generation (
        @SerializedName("name")
        val name: String,

        @SerializedName("url")
        val url: String
    )

    data class Name (
        @SerializedName("language")
        val language: Generation,
        @SerializedName("name")
        val name: String
    )

}