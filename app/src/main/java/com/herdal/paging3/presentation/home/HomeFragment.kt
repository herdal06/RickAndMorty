package com.herdal.paging3.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.herdal.paging3.data.model.character.Character
import com.herdal.paging3.databinding.FragmentHomeBinding
import com.herdal.paging3.presentation.home.adapter.CharacterPagedAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val viewModel: HomeViewModel by viewModels()
    private val characterAdapter: CharacterPagedAdapter by lazy {
        CharacterPagedAdapter(::onClickCharacter)
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
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
                characterAdapter.submitData(pagingData)
            }
        }
    }

    private fun onClickCharacter(character: Character) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToCharacterDetailsFragment(character)
        )
    }

    private fun initRecyclerView() {
        binding.rvCharacters.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
            setHasFixedSize(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}