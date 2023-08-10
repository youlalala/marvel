package com.youlalala.marvel.feature.characters.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.youlalala.marvel.domain.model.Character

@Composable
fun CharacterDetailsScreen(
    viewModel: CharacterDetailsViewModel = viewModel()
) {

    val character by viewModel.characterDetailFlow.collectAsState()
    CharacterDetailsScreen(character = character)
}

@Composable
fun CharacterDetailsScreen(
    character: Character,
){
    Text(text = character.name)
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
            )
        )
}