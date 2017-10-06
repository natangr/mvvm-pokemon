package io.ckl.mvvm_pokemon.utils.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import io.ckl.mvvm_pokemon.model.Pokemon
import io.ckl.mvvm_pokemon.model.PokemonMinified
import io.ckl.mvvm_pokemon.model.ResponseList
import io.ckl.mvvm_pokemon.utils.api.PokemonApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PokemonRepositoryImpl: PokemonRepository {

    val BASE_URL = "http://pokeapi.co/api/v2/"
    private var pokemonApi: PokemonApi

    init {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        pokemonApi = retrofit.create(PokemonApi::class.java)
    }

    override fun getPokemonById(pokemonId: Int): LiveData<Pokemon> {
        val liveData = MutableLiveData<Pokemon>()
        pokemonApi.fetchPokemonById(pokemonId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    liveData.value = it
                }, {
                    Log.e("RetrofitError", it.localizedMessage, it)
                })
        return liveData
    }

    override fun getPokemons(): LiveData<ResponseList<PokemonMinified>> {
        val liveData = MutableLiveData<ResponseList<PokemonMinified>>()
        pokemonApi.fetchPokemons()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    liveData.value = it
                }, {
                    Log.e("RetrofitError", it.localizedMessage, it)
                })
        return liveData
    }
}

