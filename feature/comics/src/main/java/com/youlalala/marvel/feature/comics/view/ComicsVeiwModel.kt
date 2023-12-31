package com.youlalala.marvel.feature.comics.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.youlalala.marvel.domain.model.Comic
import com.youlalala.marvel.domain.usecase.ComicsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(
    private val comicsUseCase: ComicsUseCase
): ViewModel(){

    private val _comicsListFlow = MutableStateFlow<List<Comic>>(emptyList())
    val comicsListFlow: StateFlow<List<Comic>> = _comicsListFlow

    fun getComics(){
        viewModelScope.launch{
            comicsUseCase.getComics().collectLatest {
                _comicsListFlow.value = it
            }
        }
    }
}