package com.rjornelas.core.usecase

import com.rjornelas.core.data.repository.FavoritesRepository
import com.rjornelas.core.domain.model.Character
import com.rjornelas.core.usecase.base.CoroutinesDispatchers
import com.rjornelas.core.usecase.base.FlowUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface GetFavoritesUseCase {
    suspend operator fun invoke(params: Unit = Unit): Flow<List<Character>>
}

class GetFavoritesUseCaseImpl @Inject constructor(
    private val favoritesRepository: FavoritesRepository,
    private val dispatchers: CoroutinesDispatchers
) : FlowUseCase<Unit, List<Character>>(), GetFavoritesUseCase {

    override suspend fun createFlowObservable(params: Unit): Flow<List<Character>> {
        return withContext(dispatchers.io()) {
            favoritesRepository.getAll()
        }
    }
}