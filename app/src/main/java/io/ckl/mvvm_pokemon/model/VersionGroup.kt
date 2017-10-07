package io.ckl.mvvm_pokemon.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class VersionGroup {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null

}
