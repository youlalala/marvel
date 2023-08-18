package com.youlalala.marvel.feature.characters.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.youlalala.marvel.feature.characters.CharactersAdapter
import com.youlalala.marvel.feature.characters.databinding.FragmentCharactersBinding
import com.youlalala.marvel.feature.characters.viewmodels.CharactersUiState
import com.youlalala.marvel.feature.characters.viewmodels.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharactersFragment : Fragment() {

    private val charactersViewModel: CharactersViewModel by viewModels()
    private lateinit var binding: FragmentCharactersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeUiState()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharactersBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply{
            lifecycleOwner=viewLifecycleOwner
            adapter = CharactersAdapter()
            viewModel = charactersViewModel
        }

        charactersViewModel.getCharacters()
    }

    private fun observeUiState(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                charactersViewModel.charactersUiState.collect { uiState ->
                    when (uiState) {
                        is CharactersUiState.Success -> binding.progressBar.visibility = View.GONE
                        is CharactersUiState.Error -> binding.progressBar.visibility = View.GONE
                        is CharactersUiState.Loading -> binding.progressBar.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}