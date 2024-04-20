package com.rjornelas.marvelapp.framework.local

import com.rjornelas.core.domain.data.repository.FavoritesLocalDataSource
import com.rjornelas.core.domain.domain.model.Character
import com.rjornelas.marvelapp.framework.db.dao.FavoriteDao
import com.rjornelas.marvelapp.framework.db.entity.FavoriteEntity
import com.rjornelas.marvelapp.framework.db.entity.toCharactersModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RoomFavoritesDataSource @Inject constructor(
    private val favoriteDao: FavoriteDao
) : FavoritesLocalDataSource {

    override fun getAll(): Flow<List<Character>> {
        return favoriteDao.loadFavorites().map {
            it.toCharactersModel()
        }
    }

    override suspend fun isFavorite(characterId: Int): Boolean {
        return favoriteDao.hasFavorite(characterId) != null
    }

    override suspend fun save(character: Character) {
        favoriteDao.insertFavorite(character.toFavoriteEntity())
    }

    override suspend fun delete(character: Character) {
        favoriteDao.deleteFavorite(character.toFavoriteEntity())
    }

    private fun Character.toFavoriteEntity() = FavoriteEntity(id, name, imageUrl)
}