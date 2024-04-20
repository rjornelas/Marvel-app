package com.rjornelas.marvelapp.framework.di

import com.rjornelas.core.domain.usecase.AddFavoriteUseCase
import com.rjornelas.core.domain.usecase.AddFavoriteUseCaseImpl
import com.rjornelas.core.domain.usecase.CheckFavoriteUseCase
import com.rjornelas.core.domain.usecase.CheckFavoriteUseCaseImpl
import com.rjornelas.core.domain.usecase.GetCharacterCategoriesUseCase
import com.rjornelas.core.domain.usecase.GetCharacterCategoriesUseCaseImpl
import com.rjornelas.core.domain.usecase.GetCharactersSortingUseCase
import com.rjornelas.core.domain.usecase.GetCharactersSortingUseCaseImpl
import com.rjornelas.core.domain.usecase.GetCharactersUseCase
import com.rjornelas.core.domain.usecase.GetCharactersUseCaseImpl
import com.rjornelas.core.domain.usecase.GetFavoritesUseCase
import com.rjornelas.core.domain.usecase.GetFavoritesUseCaseImpl
import com.rjornelas.core.domain.usecase.RemoveFavoriteUseCase
import com.rjornelas.core.domain.usecase.RemoveFavoriteUseCaseImpl
import com.rjornelas.core.domain.usecase.SaveCharactersSortingUseCase
import com.rjornelas.core.domain.usecase.SaveCharactersSortingUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindGetCharactersUseCase(useCase: GetCharactersUseCaseImpl): GetCharactersUseCase

    @Binds
    fun bindGetComicsUseCase(
        useCase: GetCharacterCategoriesUseCaseImpl
    ): GetCharacterCategoriesUseCase

    @Binds
    fun bindCheckFavoriteUseCase(useCase: CheckFavoriteUseCaseImpl): CheckFavoriteUseCase

    @Binds
    fun bindAddFavoriteUseCase(useCase: AddFavoriteUseCaseImpl): AddFavoriteUseCase

    @Binds
    fun bindRemoveFavoriteUseCase(useCase: RemoveFavoriteUseCaseImpl): RemoveFavoriteUseCase

    @Binds
    fun bindGetFavoritesUseCase(useCase: GetFavoritesUseCaseImpl): GetFavoritesUseCase

    @Binds
    fun bindGetCharactersSortingUseCase(
        useCase: GetCharactersSortingUseCaseImpl
    ): GetCharactersSortingUseCase

    @Binds
    fun bindSaveCharactersSortingUseCase(
        useCase: SaveCharactersSortingUseCaseImpl
    ): SaveCharactersSortingUseCase
}