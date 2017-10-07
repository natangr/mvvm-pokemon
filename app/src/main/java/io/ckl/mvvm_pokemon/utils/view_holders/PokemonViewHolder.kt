package io.ckl.mvvm_pokemon.utils.view_holders

import android.support.v7.widget.RecyclerView
import android.view.View
import io.ckl.mvvm_pokemon.model.PokemonMinified
import io.ckl.mvvm_pokemon.utils.listeners.PokemonListListener
import kotlinx.android.synthetic.main.item_pokemon.view.*

class PokemonViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    var listener: PokemonListListener? = null
    set(value) {
        field = value
        view.setOnClickListener {
            pokemon?.let {
                listener?.onPokemonItemClicked(it)
            }
        }
    }

    var pokemon: PokemonMinified? = null
        set(value) {
            field = value
            view.pokemonNameTextView.text = pokemon?.name
//            view.pokemonNumberTextView.text = pokemon?.id.toString()
//            view.pokemonTypeTextView.text = pokemon?.types?.joinToString(separator = "/", transform = { it.name ?: "" })
        }
}