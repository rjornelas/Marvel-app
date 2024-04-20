package com.rjornelas.marvelapp.framework.di

import com.rjornelas.core.domain.data.repository.CharactersRemoteDataSource
import com.rjornelas.core.domain.data.repository.CharactersRepository
import com.rjornelas.marvelapp.framework.CharactersRepositoryImpl
import com.rjornelas.marvelapp.framework.remote.RetrofitCharactersDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CharactersRepositoryModule {

    @Binds
    fun bindCharacterRepository(repository: CharactersRepositoryImpl): CharactersRepository

    @Binds
    fun bindRemoteDataSource(
        dataSource: RetrofitCharactersDataSource
    ): CharactersRemoteDataSource
}