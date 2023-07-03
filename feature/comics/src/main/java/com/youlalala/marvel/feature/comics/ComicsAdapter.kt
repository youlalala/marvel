package com.youlalala.marvel.feature.comics

import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import com.google.android.material.composethemeadapter.MdcTheme
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.youlalala.marvel.domain.model.Comic
import com.youlalala.marvel.feature.comics.compose.ComicListItemView

/**
 * Adapter for the [RecyclerView] in [ComicsFragment].
 */
class ComicsAdapter : ListAdapter<Comic, RecyclerView.ViewHolder>(ComicDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ComicViewHolder(ComposeView(parent.context))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val comic = getItem(position)
        (holder as ComicViewHolder).bind(comic)
    }

    class ComicViewHolder(
        composeView: ComposeView
    ) : RecyclerView.ViewHolder(composeView) {
        fun bind(comic: Comic) {
            (itemView as ComposeView).setContent {
                MdcTheme {
                    ComicListItemView(comic = comic)
                }
            }
        }
    }
}


private class ComicDiffCallback : DiffUtil.ItemCallback<Comic>() {

    override fun areItemsTheSame(oldItem: Comic, newItem: Comic): Boolean {
        return oldItem.id== newItem.id
    }

    override fun areContentsTheSame(oldItem: Comic, newItem: Comic): Boolean {
        return oldItem == newItem
    }
}
