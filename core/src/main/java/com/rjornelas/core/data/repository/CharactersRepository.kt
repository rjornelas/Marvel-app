package com.rjornelas.core.data.repository

import androidx.paging.PagingSource
import com.rjornelas.core.domain.model.Character

interface CharactersRepository {

    fun getCharacters(query: String): PagingSource<Int, Character>
}