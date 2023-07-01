package com.youlalala.marvel.feature.characters

import androidx.recyclerview.widget.DiffUtil
import com.youlalala.marvel.domain.model.Character

object CharactersDiffUtil: DiffUtil.ItemCallback<Character>() {

    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }
}