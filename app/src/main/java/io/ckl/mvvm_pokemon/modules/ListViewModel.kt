package io.ckl.mvvm_pokemon.modules

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import io.ckl.mvvm_pokemon.model.Pokemon
import io.ckl.mvvm_pokemon.utils.repositories.PokemonRepository
import io.ckl.mvvm_pokemon.utils.repositories.PokemonRepositoryImpl

class ListViewModel: ViewModel() {

    private var pokemonRepository: PokemonRepository = PokemonRepositoryImpl()
    var apiResponse = MediatorLiveData<Pokemon>()

    init {
        loadPokemon(1)
    }

    fun loadPokemon(pokemonId: Int): LiveData<Pokemon> {
        apiResponse.addSource(pokemonRepository.getPokemonById(pokemonId)) {
            apiResponse.setValue(it) }
        return apiResponse
    }
}
