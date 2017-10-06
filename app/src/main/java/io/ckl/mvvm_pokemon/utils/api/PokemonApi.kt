package io.ckl.mvvm_pokemon.utils.api

import io.ckl.mvvm_pokemon.model.Pokemon
import io.ckl.mvvm_pokemon.model.PokemonMinified
import io.ckl.mvvm_pokemon.model.ResponseList
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("pokemon/{pokemonId}")
    fun fetchPokemonById(@Path("pokemonId") pokemonId: Int): Observable<Pokemon>

    @GET("pokemon")
    fun fetchPokemons(): Observable<ResponseList<PokemonMinified>>
}