package io.ckl.mvvm_pokemon.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Pokemon {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("base_experience")
    @Expose
    var baseExperience: Int? = null
    @SerializedName("height")
    @Expose
    var height: Int? = null
    @SerializedName("is_default")
    @Expose
    var isDefault: Boolean? = null
    @SerializedName("order")
    @Expose
    var order: Int? = null
    @SerializedName("weight")
    @Expose
    var weight: Int? = null
    @SerializedName("abilities")
    @Expose
    var abilities: List<Ability>? = null
    @SerializedName("forms")
    @Expose
    var forms: List<PokemonForm>? = null
    @SerializedName("game_indices")
    @Expose
    var gameIndices: List<GameIndex>? = null
//    @SerializedName("held_items")
//    @Expose
//    var heldItems: List<Any>? = null
//    @SerializedName("location_area_encounters")
//    @Expose
//    var locationAreaEncounters: List<Any>? = null
    @SerializedName("moves")
    @Expose
    var moves: List<Move>? = null
    @SerializedName("species")
    @Expose
    var species: Species? = null
    @SerializedName("stats")
    @Expose
    var stats: List<Stat>? = null
    @SerializedName("types")
    @Expose
    var types: List<Type>? = null

}
