package com.rjornelas.marvelapp.framework

import com.rjornelas.core.domain.data.repository.StorageLocalDataSource
import com.rjornelas.core.domain.data.repository.StorageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StorageRepositoryImpl @Inject constructor(
    private val storageLocalDataSource: StorageLocalDataSource,
) : StorageRepository {

    override val sorting: Flow<String>
        get() = storageLocalDataSource.sorting

    override suspend fun saveSorting(sorting: String) {
        storageLocalDataSource.saveSorting(sorting)
    }
}