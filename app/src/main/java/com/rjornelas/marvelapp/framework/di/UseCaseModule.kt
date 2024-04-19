package com.rjornelas.marvelapp.framework.di

import com.rjornelas.core.usecase.AddFavoriteUseCase
import com.rjornelas.core.usecase.AddFavoriteUseCaseImpl
import com.rjornelas.core.usecase.CheckFavoriteUseCase
import com.rjornelas.core.usecase.CheckFavoriteUseCaseImpl
import com.rjornelas.core.usecase.GetCharactersUseCase
import com.rjornelas.core.usecase.GetCharactersUseCaseImplementation
import com.rjornelas.core.usecase.GetCharacterCategoriesUseCase
import com.rjornelas.core.usecase.GetCharacterCategoriesUseCaseImpl
import com.rjornelas.core.usecase.GetFavoritesUseCase
import com.rjornelas.core.usecase.GetFavoritesUseCaseImpl
import com.rjornelas.core.usecase.RemoveFavoriteUseCase
import com.rjornelas.core.usecase.RemoveFavoriteUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindGetCharactersUseCase(useCase: GetCharactersUseCaseImplementation): GetCharactersUseCase

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
}