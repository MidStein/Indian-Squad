package com.example.indiansquad

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.indiansquad.databinding.ItemPlayerBinding

class PlayerListAdapter(val listener: IListener) : RecyclerView.Adapter<PlayerListAdapter.PlayerViewHolder>(){
    val items = ArrayList<Player>()
    class PlayerViewHolder(binding: ItemPlayerBinding) : RecyclerView.ViewHolder(binding.root){
        val image: ImageView = binding.playerFace
        val name: TextView = binding.playerName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder = PlayerViewHolder(binding)
        viewHolder.name.setOnClickListener {
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val currentItem = items[position]
        Glide.with(holder.image.context).load(currentItem.faceResourceId).into(holder.image)
        holder.name.text = currentItem.name
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateList(updatedList: ArrayList<Player>) {
        items.clear()
        items.addAll(updatedList)
    }
}

interface IListener {
    fun onItemClicked(item: Player)
}
