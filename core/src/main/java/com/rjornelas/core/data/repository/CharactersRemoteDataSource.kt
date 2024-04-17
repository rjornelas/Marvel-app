package com.rjornelas.core.data.repository

import com.rjornelas.core.domain.model.CharacterPaging
import com.rjornelas.core.domain.model.Comic
import com.rjornelas.core.domain.model.Event

interface CharactersRemoteDataSource {

    suspend fun fetchCharacters(queries: Map<String, String>): CharacterPaging

    suspend fun fetchComics(characterId: Int): List<Comic>

    suspend fun fetchEvents(characterId: Int): List<Event>
}