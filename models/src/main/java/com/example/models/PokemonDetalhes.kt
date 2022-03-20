package com.example.models

import com.google.gson.annotations.SerializedName

class PokemonDetalhesModel {
    data class Response (
        @SerializedName("abilities")
        val abilities: List<Ability>,

        @SerializedName("base_experience")
        val baseExperience: Long,

        @SerializedName("forms")
        val forms: List<Species>,

        @SerializedName("game_indices")
        val gameIndices: List<GameIndex>,

        @SerializedName("height")
        val height: Long,

        @SerializedName("held_items")
        val heldItems: List<Any?>,

        @SerializedName("id")
        val id: Long,

        @SerializedName("is_default")
        val isDefault: Boolean,

        @SerializedName("moves")
        val moves: List<Move>,

        @SerializedName("name")
        val name: String,

        @SerializedName("order")
        val order: Long,

        @SerializedName("past_types")
        val pastTypes: List<Any?>,

        @SerializedName("species")
        val species: Species,

        @SerializedName("sprites")
        val sprites: Sprites,

        @SerializedName("stats")
        val stats: List<Stat>,

        @SerializedName("types")
        val types: List<Type>,

        @SerializedName("weight")
        val weight: Long
    )

    data class Ability (
        @SerializedName("ability")
        val ability: Species,

        @SerializedName("is_hidden")
        val isHidden: Boolean,

        @SerializedName("slot")
        val slot: Long
    )

    data class Species (
        @SerializedName("name")
        val name: String,

        @SerializedName("url")
        val url: String
    )

    data class GameIndex (
        @SerializedName("game_index")
        val gameIndex: Long,

        @SerializedName("version")
        val version: Species
    )

    data class Move (
        @SerializedName("move")
        val move: Species,

        @SerializedName("version_group_detail")
        val versionGroupDetails: List<VersionGroupDetail>
    )

    data class VersionGroupDetail (
        @SerializedName("level_learned_at")
        val levelLearnedAt: Long,

        @SerializedName("move_learn_method")
        val moveLearnMethod: Species,

        @SerializedName("version_group")
        val versionGroup: Species
    )


    data class Sprites (
        @SerializedName("back_default")
        val backDefault: String,

        @SerializedName("front_default")
        val frontDefault: String,

        @SerializedName("animated")
        val animated: Sprites? = null,

        @SerializedName("other")
        val other: Other? = null,
    )

    data class Other (
        @SerializedName("official-artwork")
        val officialArtwork: OfficialArtwork
    )


    data class OfficialArtwork (
        @SerializedName("front_default")
        val frontDefault: String
    )

    data class Stat (
        @SerializedName("base_stat")
        val baseStat: Long,

        @SerializedName("effort")
        val effort: Long,

        @SerializedName("stat")
        val stat: Species
    )

    data class Type (
        @SerializedName("slot")
        val slot: Long,

        @SerializedName("type")
        val type: Species
    )
}