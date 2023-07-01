package com.youlalala.marvel.feature.characters.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.youlalala.marvel.domain.model.Character
import com.youlalala.marvel.feature.characters.CharactersAdapter

@BindingAdapter("submit_list")
fun bindCharacters(recyclerView: RecyclerView, itemList: List<Character>){
    val adapter = recyclerView.adapter as CharactersAdapter
    adapter.submitList(itemList)
}