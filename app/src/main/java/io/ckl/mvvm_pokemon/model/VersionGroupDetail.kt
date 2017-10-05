package io.ckl.mvvm_pokemon.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class VersionGroupDetail {

    @SerializedName("level_learned_at")
    @Expose
    var levelLearnedAt: Int? = null
    @SerializedName("version_group")
    @Expose
    var versionGroup: VersionGroup? = null
    @SerializedName("move_learn_method")
    @Expose
    var moveLearnMethod: MoveLearnMethod? = null

}
