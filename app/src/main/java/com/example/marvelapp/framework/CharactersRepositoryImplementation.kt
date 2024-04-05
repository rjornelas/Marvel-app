package com.example.marvelapp.framework

import androidx.paging.PagingSource
import com.example.marvelapp.framework.network.response.DataWrapperResponse
import com.example.marvelapp.framework.paging.CharactersPagingSource
import com.rjornelas.core.data.repository.CharactersRemoteDataSource
import com.rjornelas.core.data.repository.CharactersRepository
import com.rjornelas.core.domain.model.Character
import javax.inject.Inject

class CharactersRepositoryImplementation @Inject constructor(
    private val remoteDataSource: CharactersRemoteDataSource<DataWrapperResponse>
): CharactersRepository {
    override fun getCharacters(query: String): PagingSource<Int, Character> {
        return CharactersPagingSource(remoteDataSource, query)
    }
}