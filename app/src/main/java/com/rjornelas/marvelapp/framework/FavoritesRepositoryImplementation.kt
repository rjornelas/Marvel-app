package com.rjornelas.marvelapp.framework

import com.rjornelas.core.data.repository.FavoritesLocalDataSource
import com.rjornelas.core.data.repository.FavoritesRepository
import com.rjornelas.core.domain.model.Character
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoritesRepositoryImplementation @Inject constructor(
    private val favoritesLocalDataSource: FavoritesLocalDataSource,
) : FavoritesRepository {

    override fun getAll(): Flow<List<Character>> {
        return favoritesLocalDataSource.getAll()
    }

    override suspend fun isFavorite(characterId: Int): Boolean {
        return favoritesLocalDataSource.isFavorite(characterId)
    }

    override suspend fun saveFavorite(character: Character) {
        favoritesLocalDataSource.save(character)
    }

    override suspend fun deleteFavorite(character: Character) {
        favoritesLocalDataSource.delete(character)
    }
}