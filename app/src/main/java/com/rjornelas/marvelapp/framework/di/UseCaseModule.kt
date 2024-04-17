package com.rjornelas.marvelapp.framework.di

import com.rjornelas.core.usecase.GetCharactersUseCase
import com.rjornelas.core.usecase.GetCharactersUseCaseImplementation
import com.rjornelas.core.usecase.GetCharacterCategoriesUseCase
import com.rjornelas.core.usecase.GetCharacterCategoriesUseCaseImpl
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
}