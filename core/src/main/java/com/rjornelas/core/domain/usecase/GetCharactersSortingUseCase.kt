package com.rjornelas.core.domain.usecase

import com.rjornelas.core.domain.data.mapper.SortingMapper
import com.rjornelas.core.domain.data.repository.StorageRepository
import com.rjornelas.core.domain.usecase.base.CoroutinesDispatchers
import com.rjornelas.core.domain.usecase.base.FlowUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface GetCharactersSortingUseCase {
    suspend operator fun invoke(params: Unit = Unit): Flow<Pair<String, String>>
}

class GetCharactersSortingUseCaseImpl @Inject constructor(
    private val storageRepository: StorageRepository,
    private val sortingMapper: SortingMapper,
    private val dispatchers: CoroutinesDispatchers
) : FlowUseCase<Unit, Pair<String, String>>(), GetCharactersSortingUseCase {

    override suspend fun createFlowObservable(params: Unit): Flow<Pair<String, String>> {
        return withContext(dispatchers.io()) {
            storageRepository.sorting.map { sorting ->
                sortingMapper.mapToPair(sorting)
            }
        }
    }
}