package com.youlalala.marvel.feature.comics.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.youlalala.marvel.domain.model.Comic
import com.youlalala.marvel.feature.comics.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ComicListItemView(comic: Comic) {
    Column(
        modifier = Modifier
            .padding(horizontal = dimensionResource(id = R.dimen.card_side_margin))
            .padding(bottom = dimensionResource(id = R.dimen.card_bottom_margin))) {
        Card(
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.card_corner_radius)),
        ) {
            if (LocalInspectionMode.current) {
                Box(modifier = Modifier.background(Color.LightGray).height(200.dp).fillMaxWidth())
                return@Card
            }
            GlideImage(
                model = comic.thumbnail_url,
                contentDescription = stringResource(R.string.a11y_comic_item_image),
                Modifier.fillMaxWidth(),
            )

        }
        TitleText(text = comic.title)
    }
}