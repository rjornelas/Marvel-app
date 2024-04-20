package com.rjornelas.marvelapp.framework.di

import com.rjornelas.core.domain.data.repository.StorageLocalDataSource
import com.rjornelas.core.domain.data.repository.StorageRepository
import com.rjornelas.marvelapp.framework.StorageRepositoryImpl
import com.rjornelas.marvelapp.framework.local.DataStorePreferencesDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface StorageRepositoryModule {

    @Binds
    fun bindStorageRepository(repository: StorageRepositoryImpl): StorageRepository

    @Singleton
    @Binds
    fun bindLocalDataSource(dataSource: DataStorePreferencesDataSource): StorageLocalDataSource
}