package io.ckl.mvvm_pokemon.modules

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.ckl.mvvm_pokemon.R
import io.ckl.mvvm_pokemon.model.Pokemon

class ListActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        setupView()
        // Handle changes emitted by LiveData
        viewModel.apiResponse.observe(this, Observer<Pokemon> {
            onPokemonChanged(it)
        })
    }

    private fun setupView() {
        // TODO: implement
    }

    private fun onPokemonChanged(pokemon: Pokemon?) {
        Log.d("View", "Pokemon ${pokemon?.name}")
    }
}
