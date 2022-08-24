package com.herdal.paging3.presentation.episodedetails.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.herdal.paging3.data.model.character.Character
import com.herdal.paging3.databinding.ItemEpisodeCharacterBinding
import com.herdal.paging3.utils.extensions.loadImage

class EpisodeCharactersAdapter() :
    ListAdapter<Character, EpisodeCharactersAdapter.EpisodeCharactersViewHolder>(DiffCallback()) {
    class EpisodeCharactersViewHolder(private val binding: ItemEpisodeCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) = binding.apply {
            textViewCharacterName.text = character.name
            imageView.loadImage(character.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeCharactersViewHolder {
        val binding =
            ItemEpisodeCharacterBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false
            )
        return EpisodeCharactersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EpisodeCharactersViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)

    }

    class DiffCallback : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean =
            oldItem == newItem
    }
}