package com.youlalala.marvel.feature.characters.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.youlalala.marvel.feature.characters.CharactersAdapter
import com.youlalala.marvel.feature.characters.databinding.FragmentCharactersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment() {

    private val charactersViewModel: CharactersViewModel by viewModels()
    private lateinit var binding: FragmentCharactersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
            lifecycleOwner=this@CharactersFragment
            adapter = CharactersAdapter()
            viewModel = charactersViewModel
        }

        charactersViewModel.getCharacters()
    }
}