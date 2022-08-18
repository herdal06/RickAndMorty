package com.herdal.paging3.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.herdal.paging3.data.model.Character
import com.herdal.paging3.databinding.ItemCharacterBinding
import com.herdal.paging3.utils.extensions.loadImage


class CharacterPagedAdapter :
    PagingDataAdapter<Character, CharacterPagedAdapter.MyViewHolder>(diffCallback) {

    inner class MyViewHolder(val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.binding.apply {
            tvCharacterName.text = "${currentItem?.name}"
            tvStatus.text = "${currentItem?.status}"
            tvGender.text = "${currentItem?.gender}"
            tvFirstSeenIn.text = currentItem?.location?.name
            val imageLink = currentItem?.image
            imageView.loadImage(imageLink)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}