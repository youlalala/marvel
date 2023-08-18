package com.youlalala.marvel.feature.characters.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.youlalala.marvel.feature.characters.CharactersAdapter
import com.youlalala.marvel.feature.characters.viewmodels.CharactersUiState

@BindingAdapter("submit_list")
fun bindCharacters(recyclerView: RecyclerView, uiState: CharactersUiState){
    if(uiState is CharactersUiState.Success){
        val adapter = recyclerView.adapter as CharactersAdapter
        adapter.submitList(uiState.data)
    }
}

@BindingAdapter("imageUrl")
fun bindImg(view: ImageView, url: String){
    Glide.with(view.rootView)
        .load(url)
        .into(view)
}