package com.youlalala.marvel.feature.characters

import androidx.recyclerview.widget.RecyclerView
import com.youlalala.marvel.domain.model.Character
import com.youlalala.marvel.feature.characters.databinding.ItemCharacterBinding

class CharactersViewHolder(private val binding: ItemCharacterBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(item: Character){
        binding.apply {
            character = item
        }
    }
}