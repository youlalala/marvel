package com.youlalala.marvel.feature.characters.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.youlalala.marvel.feature.characters.databinding.FragmentCharacterDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment : Fragment() {

    private val args: CharacterDetailFragmentArgs by navArgs()
    private val characterDetailViewModel: CharacterDetailViewModel by viewModels()
    lateinit var binding: FragmentCharacterDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCharacterDetailBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = this@CharacterDetailFragment
            viewModel = characterDetailViewModel
        }

        characterDetailViewModel.getCharacterDetail(args.characterId)
    }

}