package com.rjornelas.core.domain.data.repository

import kotlinx.coroutines.flow.Flow

interface StorageRepository {
    val sorting: Flow<String>

    suspend fun saveSorting(sorting: String)
}