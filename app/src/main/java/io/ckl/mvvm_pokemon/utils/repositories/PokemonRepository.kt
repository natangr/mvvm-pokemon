package io.ckl.mvvm_pokemon.utils.repositories

import android.arch.lifecycle.LiveData
import io.ckl.mvvm_pokemon.model.Pokemon
import io.ckl.mvvm_pokemon.model.PokemonForm
import io.ckl.mvvm_pokemon.model.PokemonMinified
import io.ckl.mvvm_pokemon.model.ResponseList

interface PokemonRepository {

    fun getPokemonById(pokemonId: Int): LiveData<Pokemon>
    fun getPokemons(): LiveData<ResponseList<PokemonMinified>>
    fun getPokemonForm(formUrl: String?): LiveData<PokemonForm>
}
