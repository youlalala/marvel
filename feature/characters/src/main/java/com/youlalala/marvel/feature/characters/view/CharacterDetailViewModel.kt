package com.youlalala.marvel.feature.characters.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.youlalala.marvel.domain.model.Character
import com.youlalala.marvel.domain.usecase.GetCharacterDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase,
): ViewModel() {

    private val _characterDetailFlow = MutableStateFlow(Character())
    val characterDetailFlow: StateFlow<Character> = _characterDetailFlow

    fun getCharacterDetail(characterId: Int){
        viewModelScope.launch {
            getCharacterDetailUseCase(characterId).collect{
                _characterDetailFlow.value = it[0]
            }
        }
    }
}

