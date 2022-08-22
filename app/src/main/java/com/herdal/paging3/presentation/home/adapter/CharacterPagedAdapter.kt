package com.herdal.paging3.presentation.home.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.herdal.paging3.data.model.Character
import com.herdal.paging3.databinding.ItemCharacterBinding
import com.herdal.paging3.enums.CharacterStatusEnums
import com.herdal.paging3.utils.extensions.loadImage


class CharacterPagedAdapter(private val onClickCharacter: ((character: Character) -> Unit)?) :
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
        val character = getItem(position)

        holder.binding.apply {
            tvCharacterName.text = "${character?.name}"
            tvStatus.text = "${character?.status}"
            tvGender.text = "${character?.gender}"
            tvFirstSeenIn.text = character?.location?.name
            val imageLink = character?.image
            imageView.loadImage(imageLink)


            if (character != null) {
                when (character.status) {
                    CharacterStatusEnums.CHARACTER_ALIVE.value -> ivCharacterStatus.setColorFilter(
                        Color.parseColor("#14D91B")
                    )
                    CharacterStatusEnums.CHARACTER_DEAD.value -> ivCharacterStatus.setColorFilter(
                        Color.parseColor("#FF0800")
                    )
                    CharacterStatusEnums.CHARACTER_UNKNOWN.value -> ivCharacterStatus.setColorFilter(
                        Color.parseColor("#E3E3E3")
                    )
                    else -> ivCharacterStatus.setColorFilter(
                        Color.parseColor("#F8F816")
                    )
                }
            }
        }
        holder.itemView.setOnClickListener {
            if (character != null) {
                onClickCharacter?.invoke(character)
            }
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