package com.youlalala.marvel.feature.characters.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.youlalala.marvel.domain.model.Character
import com.youlalala.marvel.feature.characters.R
import com.youlalala.marvel.feature.characters.viewmodels.CharacterDetailsViewModel
import kotlinx.coroutines.withContext

@Composable
fun CharacterDetailsScreen(
    viewModel: CharacterDetailsViewModel
) {

    val character by viewModel.characterDetailFlow.collectAsState()
    CharacterDetailsScreen(character = character)
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CharacterDetailsScreen(
    character: Character,
){

    Column(modifier = Modifier.padding(16.dp)){
        Card(shape = RoundedCornerShape(dimensionResource(id = R.dimen.card_corner_radius))){
            if (LocalInspectionMode.current) {
                Box(modifier = Modifier.background(Color.LightGray).height(200.dp).fillMaxWidth())
                return@Card
            }
            GlideImage(
                model = character.thumbnail_url,
                contentDescription = stringResource(R.string.a11y_character_item_image),
                Modifier.fillMaxWidth().height(300.dp),
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = character.name,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 20.dp)
        )
        Text(
            text = character.description,
            textAlign = TextAlign.Left
        )
    }
}

@Preview
@Composable
private fun CharacterDetailsPreview(
    @PreviewParameter(CharacterDetailsPreviewParamProvider::class) character: Character
){
    CharacterDetailsScreen(character = character)
}


private class CharacterDetailsPreviewParamProvider : PreviewParameterProvider<Character> {
    override val values: Sequence<Character> =
        sequenceOf(
            Character(
                name = "abc",
                description = "asdfasdfasfdasdfasdfasdfas",
            )
        )
}