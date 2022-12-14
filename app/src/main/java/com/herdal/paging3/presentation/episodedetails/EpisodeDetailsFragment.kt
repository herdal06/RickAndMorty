package com.herdal.paging3.presentation.episodedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.herdal.paging3.databinding.FragmentEpisodeDetailsBinding
import com.herdal.paging3.presentation.episodedetails.adapter.EpisodeCharactersAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeDetailsFragment : Fragment() {

    private var _binding: FragmentEpisodeDetailsBinding? = null
    private val args: EpisodeDetailsFragmentArgs by navArgs()
    private val episodeCharactersAdapter: EpisodeCharactersAdapter by lazy {
        EpisodeCharactersAdapter()
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEpisodeDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initRecyclerView()
    }

    private fun initRecyclerView() = binding.rvEpisodeCharacters.apply {
        adapter = episodeCharactersAdapter
        setHasFixedSize(true)
    }

    private fun getArgs() = args.episode

    private fun initViews() {
        val episode = getArgs()
        binding.apply {
            tvNameDetails.text = episode.name
            tvEpisodeDetails.text = episode.episode
            tvAirDateDetails.text = episode.air_date
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}