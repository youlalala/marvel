package com.youlalala.marvel.feature.comics.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.youlalala.marvel.domain.model.Comic
import com.youlalala.marvel.domain.usecase.GetComicsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(
    private val getComicsUseCase: GetComicsUseCase
): ViewModel(){

//    private val _comicsListFlow = MutableStateFlow<List<Comic>>(emptyList())
//    val comicsListFlow: StateFlow<List<Comic>> = _comicsListFlow
    private val _comicsListLiveData = MutableLiveData<List<Comic>>()
    val comicsListLiveData: LiveData<List<Comic>> = _comicsListLiveData

    fun getComics(){
        viewModelScope.launch{
            getComicsUseCase().collectLatest {
                _comicsListLiveData.postValue(it)
            }
//            getComicsUseCase().collectLatest{
//                Log.i("TEST",it.toString())
//                _comicsListFlow.value = it
//            }
        }
    }
}