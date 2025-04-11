package com.example.superhero.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.superhero.R
import com.example.superhero.data.Superhero
import com.example.superhero.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroAdapter(var items: List<Superhero>, val onClick: (position:Int) -> Unit) : Adapter<SuperheroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        val binding = ItemSuperheroBinding.inflate(layoutInflater.fr)
        return SuperheroViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        val superhero = items[position]
        holder.render(superhero)
        holder.itemView.setOnClickListener {
            onClick(position)
        }
        fun updateItems (items: List<Superhero>){

        }
    }
}

class SuperheroViewHolder(binding: ItemSuperheroBinding) : ViewHolder(binding.root) {
    data class Biography(
        val
        val
        val

            )

    var nameTextView: TextView = view.findViewById(R.id.nameTextView)
    var avatarImageView: ImageView = view.findViewById(R.id.avatarImageView)

    fun render(superhero: Superhero) {
        nameTextView.text = superhero.name
        Picasso.get().load(superhero.image.url).into(avatarImageView);
    }
}
