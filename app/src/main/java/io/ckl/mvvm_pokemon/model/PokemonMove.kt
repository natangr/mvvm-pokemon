package io.ckl.mvvm_pokemon.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PokemonMove {

    @SerializedName("move")
    @Expose
    var move: Move? = null
    @SerializedName("version_group_details")
    @Expose
    var versionGroupDetails: List<VersionGroupDetail>? = null

}