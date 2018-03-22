package io.ckl.mvvm_pokemon.modules.detail

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import android.os.Bundle
import io.ckl.mvvm_pokemon.model.Pokemon
import io.ckl.mvvm_pokemon.model.PokemonForm
import io.ckl.mvvm_pokemon.utils.constants.IntentConstants
import io.ckl.mvvm_pokemon.utils.repositories.PokemonApiRepository
import io.ckl.mvvm_pokemon.utils.repositories.PokemonRepository

class DetailViewModel: ViewModel() {

    private val pokemonRepository: PokemonRepository = PokemonApiRepository()
    var pokemonName = MediatorLiveData<String>()
    var pokemon = MediatorLiveData<Pokemon>()
    var pokemonForm = MediatorLiveData<PokemonForm>()

    fun onCreate(extras: Bundle?) {
        pokemonName.value = extras?.getString(IntentConstants.POKEMON_NAME)
        val pokemonId = extras?.getInt(IntentConstants.POKEMON_ID) ?: return
        loadPokemon(pokemonId)
    }

    private fun loadPokemon(pokemonId: Int) {
        pokemon.addSource(pokemonRepository.getPokemonById(pokemonId)) {
            pokemon.value = it
            loadPokemonForms(it)
        }
    }

    private fun loadPokemonForms(pokemon: Pokemon?) {
        val formUrl = pokemon?.forms?.firstOrNull()?.relativeUrl
        pokemonForm.addSource(pokemonRepository.getPokemonForm(formUrl)) {
            pokemonForm.value = it
        }
    }
}
