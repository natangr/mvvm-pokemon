package io.ckl.mvvm_pokemon.modules.list

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import io.ckl.mvvm_pokemon.model.PokemonMinified
import io.ckl.mvvm_pokemon.utils.repositories.PokemonRepository
import io.ckl.mvvm_pokemon.utils.repositories.PokemonRepositoryImpl

class ListViewModel: ViewModel() {

    private var pokemonRepository: PokemonRepository = PokemonRepositoryImpl()
    var apiResponse = MediatorLiveData<List<PokemonMinified>>()
    var nextPageUrl: String? = null

    init {
        loadPokemons()
    }

    private fun loadPokemons() {
        apiResponse.addSource(pokemonRepository.getPokemons()) {
            nextPageUrl = it?.next
            apiResponse.setValue(it?.results)
        }
    }
}
