package com.youlalala.marvel.feature.characters

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.youlalala.marvel.domain.model.Character
import com.youlalala.marvel.feature.characters.databinding.ItemCharacterBinding
import com.youlalala.marvel.feature.characters.view.CharactersFragmentDirections

class CharactersViewHolder(private val binding: ItemCharacterBinding): RecyclerView.ViewHolder(binding.root){

    init {
        binding.setClickListener{
            navigateToCharacterDetail(binding.character!!, it)
        }
    }

    fun bind(item: Character){
        binding.apply {
            character = item
        }
    }

    private fun navigateToCharacterDetail(
        character: Character,
        view: android.view.View
    ) {
        val direction =
            CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailFragment(
                character.id
            )
        view.findNavController().navigate(direction)
    }
}