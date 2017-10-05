package io.ckl.mvvm_pokemon.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Ability {

    @SerializedName("is_hidden")
    @Expose
    var isHidden: Boolean? = null
    @SerializedName("slot")
    @Expose
    var slot: Int? = null
    @SerializedName("ability")
    @Expose
    var ability: PokemonAbility? = null

}
