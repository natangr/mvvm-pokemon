package io.ckl.mvvm_pokemon.utils.listeners

import io.ckl.mvvm_pokemon.model.PokemonMinified

interface PokemonListListener {

    fun onPokemonItemClicked(pokemon: PokemonMinified)
}