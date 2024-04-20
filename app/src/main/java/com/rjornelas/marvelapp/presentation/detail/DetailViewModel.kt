package com.rjornelas.marvelapp.presentation.detail

import androidx.lifecycle.ViewModel
import com.rjornelas.core.domain.usecase.AddFavoriteUseCase
import com.rjornelas.core.domain.usecase.CheckFavoriteUseCase
import com.rjornelas.core.domain.usecase.GetCharacterCategoriesUseCase
import com.rjornelas.core.domain.usecase.RemoveFavoriteUseCase
import com.rjornelas.core.domain.usecase.base.CoroutinesDispatchers
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    getCharacterCategoriesUseCase: GetCharacterCategoriesUseCase,
    checkFavoriteUseCase: CheckFavoriteUseCase,
    addFavoriteUseCase: AddFavoriteUseCase,
    removeFavoriteUseCase: RemoveFavoriteUseCase,
    coroutinesDispatchers: CoroutinesDispatchers
) : ViewModel() {

    val categories = UiActionStateLiveData(
        coroutinesDispatchers.main(),
        getCharacterCategoriesUseCase
    )

    val favorite = FavoriteUiActionStateLiveData(
        coroutinesDispatchers.main(),
        checkFavoriteUseCase,
        addFavoriteUseCase,
        removeFavoriteUseCase
    )
}