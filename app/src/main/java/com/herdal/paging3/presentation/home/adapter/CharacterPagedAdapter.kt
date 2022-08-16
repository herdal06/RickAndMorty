package com.herdal.paging3.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.herdal.paging3.data.model.Character
import com.herdal.paging3.databinding.ItemCharacterBinding

class CharacterPagedAdapter :
    PagingDataAdapter<Character, CharacterPagedAdapter.CharacterViewHolder>(diffCallback) {

    inner class CharacterViewHolder(val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Character, newItem: Character) =
                oldItem == newItem

        }
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.binding.apply {
            tvCharacterName.text = currentItem?.name
            val image = currentItem?.image
            imageView.load(image) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}