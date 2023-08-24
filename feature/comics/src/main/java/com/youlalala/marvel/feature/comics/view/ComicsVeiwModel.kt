package com.youlalala.marvel.feature.comics.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.youlalala.marvel.domain.ErrorMessage
import com.youlalala.marvel.domain.MarvelErrorException
import com.youlalala.marvel.domain.model.ComicList
import com.youlalala.marvel.domain.usecase.ComicsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(
    private val comicsUseCase: ComicsUseCase
): ViewModel(){

    val comicsListFlow = MutableStateFlow(ComicList(emptyList()))
    fun getComics(){
        viewModelScope.launch{
            comicsUseCase.getComics().collectLatest { result ->
                result.onSuccess {
                    comicsListFlow.value = it
                }.onFailure {
                    val exception = it as MarvelErrorException
                    when(exception.code){
                        ErrorMessage.CLIENT_ERROR -> {
                            // TODO: handle client error
                            Log.i("test", "getComics: ${exception.code}")
                        }
                        ErrorMessage.SERVER_ERROR -> {
                            // TODO:
                            Log.i("test", "getComics: ${exception.code}")
                        }
                        ErrorMessage.UNKNOWN_ERROR -> {
                            // TODO:
                            Log.i("test", "getComics: ${exception.code}")
                        }
                    }
                }
            }
        }
    }

}

sealed class ComicsState{
    object Loading: ComicsState()
    data class Success(val comicsList: ComicList): ComicsState()
    data class Error(val message: ErrorMessage): ComicsState()
}