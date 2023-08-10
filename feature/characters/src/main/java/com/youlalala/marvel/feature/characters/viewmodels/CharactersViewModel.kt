package com.youlalala.marvel.feature.characters.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.youlalala.marvel.domain.model.Character
import com.youlalala.marvel.domain.usecase.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel(){

    private val _charactersListFlow = MutableStateFlow<List<Character>>(emptyList())
    val charactersListFlow:StateFlow<List<Character>> = _charactersListFlow

    fun getCharacters(){
        viewModelScope.launch{
            getCharactersUseCase().collectLatest{
                _charactersListFlow.value = it
            }
        }
    }
}