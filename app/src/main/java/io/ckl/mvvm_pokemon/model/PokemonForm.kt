package io.ckl.mvvm_pokemon.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class PokemonForm {
    @SerializedName("is_battle_only")
    @Expose
    var isBattleOnly: Boolean? = null
    @SerializedName("sprites")
    @Expose
    var sprites: Sprites? = null
    @SerializedName("version_group")
    @Expose
    var versionGroup: VersionGroup? = null
    @SerializedName("form_order")
    @Expose
    var formOrder: Int? = null
    @SerializedName("is_mega")
    @Expose
    var isMega: Boolean? = null
    @SerializedName("form_names")
    @Expose
    var formNames: List<Any>? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("is_default")
    @Expose
    var isDefault: Boolean? = null
    @SerializedName("names")
    @Expose
    var names: List<Any>? = null
    @SerializedName("form_name")
    @Expose
    var formName: String? = null
    @SerializedName("pokemon")
    @Expose
    var pokemon: PokemonMinified? = null
    @SerializedName("order")
    @Expose
    var order: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
}
