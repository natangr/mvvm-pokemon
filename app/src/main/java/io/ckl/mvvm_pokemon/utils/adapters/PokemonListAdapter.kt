package io.ckl.mvvm_pokemon.utils.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.ckl.mvvm_pokemon.R
import io.ckl.mvvm_pokemon.model.PokemonMinified
import io.ckl.mvvm_pokemon.utils.listeners.PokemonListListener
import io.ckl.mvvm_pokemon.utils.view_holders.PokemonViewHolder

class PokemonListAdapter(val listener: PokemonListListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var pokemons: List<PokemonMinified> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = pokemons.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is PokemonViewHolder) {
            holder.pokemon = pokemons.getOrNull(position)
            holder.listener = listener
        }
    }
}
