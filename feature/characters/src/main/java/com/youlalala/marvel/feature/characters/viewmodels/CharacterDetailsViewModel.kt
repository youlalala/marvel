package com.youlalala.marvel.feature.characters.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.youlalala.marvel.domain.model.Character
import com.youlalala.marvel.domain.usecase.CharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val charactersUseCase: CharactersUseCase,
): ViewModel() {

    private val _characterDetailFlow = MutableStateFlow(Character())
    val characterDetailFlow: StateFlow<Character> = _characterDetailFlow

    fun getCharacterDetail(characterId: Int){
        viewModelScope.launch {
            charactersUseCase.getCharacterDetail(characterId).collect{
                _characterDetailFlow.value = it[0]
            }
        }
    }
}

