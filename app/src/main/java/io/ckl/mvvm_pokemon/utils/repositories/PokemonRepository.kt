package io.ckl.mvvm_pokemon.utils.repositories

import android.arch.lifecycle.LiveData
import io.ckl.mvvm_pokemon.model.Pokemon

interface PokemonRepository {

    fun getPokemonById(pokemonId: Int): LiveData<Pokemon>
}
