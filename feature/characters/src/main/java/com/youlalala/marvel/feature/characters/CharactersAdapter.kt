package com.youlalala.marvel.feature.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.youlalala.marvel.feature.characters.databinding.ItemCharacterBinding
import com.youlalala.marvel.domain.model.Character

class CharactersAdapter(): ListAdapter<Character, CharactersViewHolder>(CharactersDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}