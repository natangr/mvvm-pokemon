package io.ckl.mvvm_pokemon.modules.list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.ListView
import io.ckl.mvvm_pokemon.R
import io.ckl.mvvm_pokemon.model.PokemonMinified
import io.ckl.mvvm_pokemon.utils.adapters.PokemonListAdapter
import io.ckl.mvvm_pokemon.utils.listeners.PokemonListListener
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity: AppCompatActivity(), PokemonListListener {

    val adapter = PokemonListAdapter(this)
    var viewModel: ListViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        setupView()
    }

    private fun setupView() {
        pokemonRecyclerView.layoutManager = LinearLayoutManager(this)
        pokemonRecyclerView.adapter = adapter

        viewModel?.apiResponse?.observe(this, Observer<List<PokemonMinified>> {
            onPokemonsLoaded(it)
        })
    }

    private fun onPokemonsLoaded(pokemons: List<PokemonMinified>?) {
        adapter.pokemons = pokemons ?: listOf()
    }

    override fun onPokemonItemClicked(pokemon: PokemonMinified) {
        viewModel?.onPokemonItemClicked(this, pokemon)
    }
}
