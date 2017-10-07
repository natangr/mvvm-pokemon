package io.ckl.mvvm_pokemon.modules.list

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.content.Intent
import io.ckl.mvvm_pokemon.model.PokemonMinified
import io.ckl.mvvm_pokemon.modules.detail.DetailActivity
import io.ckl.mvvm_pokemon.utils.constants.IntentConstants
import io.ckl.mvvm_pokemon.utils.repositories.PokemonRepository
import io.ckl.mvvm_pokemon.utils.repositories.PokemonApiRepository

class ListViewModel: ViewModel() {

    private val pokemonRepository: PokemonRepository = PokemonApiRepository()
    var apiResponse = MediatorLiveData<List<PokemonMinified>>()
    var nextPageUrl: String? = null

    init {
        loadPokemons()
    }

    private fun loadPokemons() {
        apiResponse.addSource(pokemonRepository.getPokemons()) {
            nextPageUrl = it?.next
            apiResponse.value = it?.results
        }
    }

    fun onPokemonItemClicked(context: Context, pokemon: PokemonMinified) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(IntentConstants.POKEMON_ID, pokemon.id)
        context.startActivity(intent)
    }
}
