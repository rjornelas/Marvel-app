package com.rjornelas.marvelapp.framework.di

import com.rjornelas.core.data.repository.CharactersRemoteDataSource
import com.rjornelas.core.data.repository.CharactersRepository
import com.rjornelas.marvelapp.framework.CharactersRepositoryImplementation
import com.rjornelas.marvelapp.framework.network.response.DataWrapperResponse
import com.rjornelas.marvelapp.framework.remote.RetrofitCharactersDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCharacterRepository(repository: CharactersRepositoryImplementation): CharactersRepository

    @Binds
    fun bindRemoteDataSource(dataSource: RetrofitCharactersDataSource): CharactersRemoteDataSource<DataWrapperResponse>
}