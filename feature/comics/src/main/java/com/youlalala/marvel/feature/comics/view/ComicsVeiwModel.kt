package com.youlalala.marvel.feature.comics.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.youlalala.marvel.domain.model.ComicList
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

    val comicsListFlow = MutableStateFlow<ComicList>(ComicList(emptyList()))
    fun getComics(){
        viewModelScope.launch{
            comicsUseCase.getComics().collectLatest {
                Log.i("test",it.toString())
                if(it.isSuccess){
                    Log.i("test","success")
                    comicsListFlow.value = it.getOrNull()!!
                }else{
                    // error 처리
                    Log.i("test","error")
                }
            }
        }
    }

}