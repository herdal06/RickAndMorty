package com.herdal.paging3.presentation.episodes.adapter

import com.herdal.paging3.data.model.episode.Episode
import com.herdal.paging3.databinding.ItemEpisodeBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


class EpisodeAdapter(private val onClickEpisode: ((episode: Episode) -> Unit)?) :
    PagingDataAdapter<Episode, EpisodeAdapter.EpisodeViewHolder>(diffCallback) {

    inner class EpisodeViewHolder(val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root)


    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Episode>() {
            override fun areItemsTheSame(oldItem: Episode, newItem: Episode): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Episode, newItem: Episode): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = getItem(position)

        holder.binding.apply {
            if (episode != null) {
                tvEpisode.text = episode.episode
                tvName.text = episode.name
                tvAirDate.text = episode.air_date
            }
        }
        holder.itemView.setOnClickListener {
            if (episode != null) {
                onClickEpisode?.invoke(episode)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            ItemEpisodeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}