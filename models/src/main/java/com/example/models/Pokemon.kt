package com.example.models

import com.google.gson.annotations.SerializedName

class PokemonModel {
    data class Response(
        val abilities: List<Ability>,

        @SerializedName("base_experience")
        val baseExperience: Long,

        val forms: List<Species>,

        @SerializedName("game_indices")
        val gameIndices: List<GameIndex>,

        val height: Long,


        val id: Long,

        @SerializedName("is_default")
        val isDefault: Boolean,

        @SerializedName("location_area_encounters")
        val locationAreaEncounters: String,

        val moves: List<Move>,
        val name: String,
        val order: Long,

        @SerializedName("past_types")
        val pastTypes: List<Any?>,

        val species: Species,
        val sprites: Sprites,
        val stats: List<Stat>,
        val types: List<Type>,
        val weight: Long
    )

    data class Ability(
        val ability: Species,

        @SerializedName("is_hidden")
        val isHidden: Boolean,

        val slot: Long
    )

    data class Species(
        val name: String,
        val url: String
    )

    data class GameIndex(
        @SerializedName("game_index")
        val gameIndex: Long,

        val version: Species
    )

    data class Move(
        val move: Species,

        @SerializedName("version_group_details")
        val versionGroupDetails: List<VersionGroupDetail>
    )

    data class VersionGroupDetail(
        @SerializedName("level_learned_at")
        val levelLearnedAt: Long,

        @SerializedName("move_learn_method")
        val moveLearnMethod: Species,

        @SerializedName( "version_group")
        val versionGroup: Species
    )


    data class Sprites(

        @SerializedName("front_default")
        val frontDefault: String,


        val other: Other? = null,
        val animated: Sprites? = null
    )


    data class Other(
        @SerializedName("official-artwork")
        val officialArtwork: OfficialArtwork
    )

    data class OfficialArtwork(
        @SerializedName("front_default")
        val frontDefault: String
    )

    data class Stat(
        @SerializedName("base_stat")
        val baseStat: Long,

        val effort: Long,
        val stat: Species
    )

    data class Type(
        val slot: Long,
        val type: Species
    )
}
