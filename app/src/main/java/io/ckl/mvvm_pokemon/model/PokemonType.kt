package io.ckl.mvvm_pokemon.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PokemonType {

    @SerializedName("slot")
    @Expose
    var slot: Int? = null
    @SerializedName("type")
    @Expose
    var type: Type? = null

}
