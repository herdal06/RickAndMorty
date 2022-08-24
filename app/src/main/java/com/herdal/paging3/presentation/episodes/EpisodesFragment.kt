package com.herdal.paging3.presentation.episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.herdal.paging3.data.model.episode.Episode
import com.herdal.paging3.databinding.FragmentEpisodesBinding
import com.herdal.paging3.presentation.episodes.adapter.EpisodeAdapter
import com.herdal.paging3.presentation.episodes.adapter.EpisodeItemDecorator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EpisodesFragment : Fragment() {

    private var _binding: FragmentEpisodesBinding? = null
    private val viewModel: EpisodesViewModel by viewModels()
    private val episodeAdapter: EpisodeAdapter by lazy {
        EpisodeAdapter(::onClickEpisode)
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEpisodesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        loadingData()
    }

    private fun loadingData() {
        lifecycleScope.launch {
            viewModel.listData.collect { pagingData ->
                episodeAdapter.submitData(pagingData)
            }
        }
    }

    private fun onClickEpisode(episode: Episode) {
        findNavController().navigate(
            EpisodesFragmentDirections.actionEpisodesFragmentToEpisodeDetailsFragment(episode)
        )
    }

    private fun initRecyclerView() = binding.rvEpisodes.apply {
        adapter = episodeAdapter
        setHasFixedSize(true)
        this.addItemDecoration(EpisodeItemDecorator(requireContext()))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}