package io.ckl.mvvm_pokemon.modules.detail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.bumptech.glide.Glide
import io.ckl.mvvm_pokemon.R
import io.ckl.mvvm_pokemon.model.Pokemon
import io.ckl.mvvm_pokemon.model.PokemonForm
import io.ckl.mvvm_pokemon.modules.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.view.*

class DetailActivity: BaseActivity() {

    var viewModel: DetailViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        setupView()
        viewModel?.onCreate(intent.extras)
    }

    private fun setupView() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        viewModel?.pokemonName?.observe(this, Observer {
            title = it?.capitalize()
        })
        viewModel?.pokemon?.observe(this, Observer {
            onPokemonLoaded(it)
        })
        viewModel?.pokemonForm?.observe(this, Observer {
            onPokemonFormLoaded(it)
        })
    }

    private fun onPokemonLoaded(pokemon: Pokemon?) {
        progress.visibility = View.GONE
        contentScrollView.visibility = View.VISIBLE
        pokemonIdTextView.text = pokemon?.id?.toString()
    }

    private fun onPokemonFormLoaded(pokemonForm: PokemonForm?) {
        Glide.with(this)
                .load(pokemonForm?.sprites?.frontDefault)
                .into(pokemonImageView)
    }
}