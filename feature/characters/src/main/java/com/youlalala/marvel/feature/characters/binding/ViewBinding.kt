package com.youlalala.marvel.feature.characters.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.youlalala.marvel.domain.model.Character
import com.youlalala.marvel.feature.characters.CharactersAdapter

@BindingAdapter("submit_list")
fun bindCharacters(recyclerView: RecyclerView, itemList: List<Character>){
    val adapter = recyclerView.adapter as CharactersAdapter
    adapter.submitList(itemList)
}

@BindingAdapter("image_url")
fun bindImg(view: ImageView, url: String){
    Glide.with(view.rootView)
        .load(url)
        .into(view)
}