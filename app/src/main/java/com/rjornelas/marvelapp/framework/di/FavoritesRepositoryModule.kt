package com.rjornelas.marvelapp.framework.di

import com.rjornelas.core.data.repository.FavoritesLocalDataSource
import com.rjornelas.core.data.repository.FavoritesRepository
import com.rjornelas.marvelapp.framework.FavoritesRepositoryImplementation
import com.rjornelas.marvelapp.framework.local.RoomFavoritesDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface FavoritesRepositoryModule {

    @Binds
    fun bindFavoritesRepository(repository: FavoritesRepositoryImplementation): FavoritesRepository

    @Binds
    fun bindLocalDataSource(
        dataSource: RoomFavoritesDataSource
    ): FavoritesLocalDataSource
}