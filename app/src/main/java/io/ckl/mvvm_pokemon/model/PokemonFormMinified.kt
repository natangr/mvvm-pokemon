package io.ckl.mvvm_pokemon.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.ckl.mvvm_pokemon.utils.constants.ApiConstants

class PokemonFormMinified {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null

    val relativeUrl: String?
        get() {
            url?.let {
                return it.removePrefix(ApiConstants.BASE_URL)
            }
            return null
        }
}
