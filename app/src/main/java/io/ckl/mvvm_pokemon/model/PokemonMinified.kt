package io.ckl.mvvm_pokemon.model

import android.util.Log
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PokemonMinified {

    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null

    val id: Int?
    get() {
        url?.let {
            if (it.startsWith("https://pokeapi.co/api/v2/")) {
                val id = it.split("/").last { !it.isEmpty() }
                try {
                    return id.toInt()
                } catch (exception: NumberFormatException) {
                    Log.e("PokemonMinified", exception.localizedMessage, exception)
                    return null
                }
            }
        }
        return null
    }
}
