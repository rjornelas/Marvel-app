package com.example.marvelapp.framework.di

import com.rjornelas.core.usecase.GetCharactersUseCase
import com.rjornelas.core.usecase.GetCharactersUseCaseImplementation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindCharactersUseCase(useCase: GetCharactersUseCaseImplementation): GetCharactersUseCase
}