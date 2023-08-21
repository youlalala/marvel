package com.youlalala.marvel.feature.comics.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.dimensionResource
import com.youlalala.marvel.domain.model.Comic
import com.youlalala.marvel.feature.comics.R
import com.youlalala.marvel.feature.comics.compose.ComicListItemView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

@Composable
fun ComicsScreen(
    viewModel: ComicsViewModel = viewModel()
){
    val comics by viewModel.comicsListFlow.collectAsState()
    ComicsScreen(comics = comics.comics)
}

@Composable
fun ComicsScreen(
    comics: List<Comic>,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            horizontal = dimensionResource(id = R.dimen.card_side_margin),
            vertical = dimensionResource(id = R.dimen.header_margin)
        )
    ){
        items(
            items = comics
        ) { comic ->
            ComicListItemView(comic = comic)
        }
    }
}

@Preview
@Composable
private fun ComicsScreenPreview(
    @PreviewParameter(ComicsPreviewParamProvider::class) comics: List<Comic>
) {
    ComicsScreen(comics = comics)
}

private class ComicsPreviewParamProvider : PreviewParameterProvider<List<Comic>>{
    override val values: Sequence<List<Comic>> =
        sequenceOf(
            listOf(
                Comic(
                    id = 1,
                    title = "Comic 1"
                ),
                Comic(
                    id = 2,
                    title = "Comic 2"
                ),
                Comic(
                    id = 3,
                    title = "Comic 3"
                ),
                Comic(
                    id = 4,
                    title = "Comic 4"
                ),
                Comic(
                    id = 5,
                    title = "Comic 5"
                ),
                Comic(
                    id = 6,
                    title = "Comic 6"
                )
            )
        )
}