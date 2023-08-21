package com.youlalala.marvel.feature.comics

import com.youlalala.marvel.feature.comics.view.ComicsViewModel
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ComicsViewModelTest {

    @Test
    fun getComics_200OK() {
        val viewModel = ComicsViewModel(GetComicsUseCaseMock())
        viewModel.getComics()
    }
}