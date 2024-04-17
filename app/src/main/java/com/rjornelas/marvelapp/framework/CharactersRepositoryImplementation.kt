package com.rjornelas.marvelapp.framework

import androidx.paging.PagingSource
import com.rjornelas.core.data.repository.CharactersRemoteDataSource
import com.rjornelas.core.data.repository.CharactersRepository
import com.rjornelas.core.domain.model.Character
import com.rjornelas.core.domain.model.Comic
import com.rjornelas.core.domain.model.Event
import com.rjornelas.marvelapp.framework.network.response.DataWrapperResponse
import com.rjornelas.marvelapp.framework.paging.CharactersPagingSource
import javax.inject.Inject

class CharactersRepositoryImplementation @Inject constructor(
    private val remoteDataSource: CharactersRemoteDataSource
) : CharactersRepository {

    override fun getCharacters(query: String): PagingSource<Int, Character> {
        return CharactersPagingSource(remoteDataSource, query)
    }

    override suspend fun getComics(characterId: Int): List<Comic> {
        return remoteDataSource.fetchComics(characterId)
    }

    override suspend fun getEvents(characterId: Int): List<Event> {
        return remoteDataSource.fetchEvents(characterId)
    }
}