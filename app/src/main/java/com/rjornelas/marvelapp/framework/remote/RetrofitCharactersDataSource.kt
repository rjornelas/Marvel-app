package com.rjornelas.marvelapp.framework.remote

import com.rjornelas.core.domain.data.repository.CharactersRemoteDataSource
import com.rjornelas.core.domain.domain.model.CharacterPaging
import com.rjornelas.core.domain.domain.model.Comic
import com.rjornelas.core.domain.domain.model.Event
import com.rjornelas.marvelapp.framework.network.MarvelApi
import com.rjornelas.marvelapp.framework.network.response.toCharacterModel
import com.rjornelas.marvelapp.framework.network.response.toComicModel
import com.rjornelas.marvelapp.framework.network.response.toEventModel
import javax.inject.Inject

class RetrofitCharactersDataSource @Inject constructor(
    private val marvelApi: MarvelApi
) : CharactersRemoteDataSource {

    override suspend fun fetchCharacters(queries: Map<String, String>): CharacterPaging {
        val data = marvelApi.getCharacters(queries).data
        val characters = data.results.map {
            it.toCharacterModel()
        }

        return CharacterPaging(
            data.offset,
            data.total,
            characters
        )
    }

    override suspend fun fetchComics(characterId: Int): List<Comic> {
        return marvelApi.getComics(characterId).data.results.map {
            it.toComicModel()
        }
    }

    override suspend fun fetchEvents(characterId: Int): List<Event> {
        return marvelApi.getEvents(characterId).data.results.map {
            it.toEventModel()
        }
    }
}