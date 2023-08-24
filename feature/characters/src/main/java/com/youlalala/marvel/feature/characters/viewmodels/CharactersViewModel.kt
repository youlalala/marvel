package com.youlalala.marvel.feature.characters.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.youlalala.marvel.domain.model.Character
import com.youlalala.marvel.domain.usecase.CharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersUseCase: CharactersUseCase,
): ViewModel(){

    private val _charactersUiState = MutableStateFlow<CharactersUiState>(CharactersUiState.Loading)
    val charactersUiState:StateFlow<CharactersUiState> = _charactersUiState.asStateFlow()


    fun getCharacters(){
        viewModelScope.launch{
            charactersUseCase.getCharacters()
                .onStart {
                    _charactersUiState.value = CharactersUiState.Loading
                }.catch {
                    _charactersUiState.value = CharactersUiState.Error
                }.collect {
                    _charactersUiState.value = CharactersUiState.Success(it)
            }
        }
    }
}

sealed class CharactersUiState(val data: List<Character>?= null){
    object Loading: CharactersUiState()
    object Error: CharactersUiState()
    data class Success(val charactersList: List<Character>): CharactersUiState(data = charactersList)
}