package com.rjornelas.marvelapp.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rjornelas.marvelapp.framework.db.dao.CharacterDao
import com.rjornelas.marvelapp.framework.db.dao.FavoriteDao
import com.rjornelas.marvelapp.framework.db.dao.RemoteKeyDao
import com.rjornelas.marvelapp.framework.db.entity.CharacterEntity
import com.rjornelas.marvelapp.framework.db.entity.FavoriteEntity
import com.rjornelas.marvelapp.framework.db.entity.RemoteKey

@Database(
    entities = [
        FavoriteEntity::class,
        CharacterEntity::class,
        RemoteKey::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao

    abstract fun characterDao(): CharacterDao

    abstract fun remoteKeyDao(): RemoteKeyDao
}