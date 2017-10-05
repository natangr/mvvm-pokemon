package io.ckl.mvvm_pokemon.utils.api

import io.ckl.mvvm_pokemon.model.Pokemon
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("pokemon/{pokemonId}")
    fun fetchPokemonById(@Path("pokemonId") pokemonId: Int): Observable<Pokemon>
}