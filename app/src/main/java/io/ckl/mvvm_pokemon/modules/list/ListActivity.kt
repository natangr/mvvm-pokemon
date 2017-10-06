package io.ckl.mvvm_pokemon.modules.list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import io.ckl.mvvm_pokemon.R
import io.ckl.mvvm_pokemon.model.PokemonMinified
import io.ckl.mvvm_pokemon.utils.adapters.PokemonListAdapter
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity: AppCompatActivity() {

    val adapter = PokemonListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        setupView()
        viewModel.apiResponse.observe(this, Observer<List<PokemonMinified>> {
            onPokemonsLoaded(it)
        })
    }

    private fun setupView() {
        pokemonRecyclerView.layoutManager = LinearLayoutManager(this)
        pokemonRecyclerView.adapter = adapter
    }

    private fun onPokemonsLoaded(pokemons: List<PokemonMinified>?) {
        adapter.pokemons = pokemons ?: listOf()
    }
}
