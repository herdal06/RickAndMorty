package com.herdal.paging3.presentation.characterdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.herdal.paging3.databinding.FragmentCharacterDetailsBinding
import com.herdal.paging3.utils.extensions.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailsFragment : Fragment() {

    private var _binding: FragmentCharacterDetailsBinding? = null
    private val viewModel: CharacterDetailsViewModel by viewModels()
    private val args: CharacterDetailsFragmentArgs by navArgs()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun getArgs() = args.character

    private fun initViews() {
        val character = getArgs()
        binding.apply {
            tvCharacterDetailsName.text = character.name
            ivCharacter.loadImage(character.image)
            tvDetailsStatus.text = character.status
            tvDetailsSpecies.text = character.species
            tvDetailsGender.text = character.gender
            tvDetailsOrigin.text = character.origin.name
            tvDetailsLocation.text = character.location.name
            tvDetailsNumberOfEpisodes.text = character.episode.size.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}