package io.ckl.mvvm_pokemon.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Sprites {

    @SerializedName("front_default")
    @Expose
    val frontDefault: String? = null
    @SerializedName("back_default")
    @Expose
    val backDefault: String? = null
    @SerializedName("front_shiny")
    @Expose
    val frontShiny: String? = null
    @SerializedName("back_shiny")
    @Expose
    val backShiny: String? = null
}
