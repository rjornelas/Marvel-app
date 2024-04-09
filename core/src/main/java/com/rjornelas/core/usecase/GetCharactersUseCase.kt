package com.rjornelas.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rjornelas.core.data.repository.CharactersRepository
import com.rjornelas.core.domain.model.Character
import com.rjornelas.core.usecase.GetCharactersUseCase.GetCharactersParams
import com.rjornelas.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetCharactersUseCase {
    operator fun invoke(param: GetCharactersParams): Flow<PagingData<Character>>

    data class GetCharactersParams(val query: String, val pagingConfig: PagingConfig)

}

class GetCharactersUseCaseImplementation @Inject constructor(
    private val charactersRepository: CharactersRepository
) : PagingUseCase<GetCharactersParams, Character>(), GetCharactersUseCase {
    override fun createFlowObservable(params: GetCharactersParams): Flow<PagingData<Character>> {
        val pagingSource = charactersRepository.getCharacters(params.query)
        return Pager(config = params.pagingConfig) {
            pagingSource
        }.flow
    }
}