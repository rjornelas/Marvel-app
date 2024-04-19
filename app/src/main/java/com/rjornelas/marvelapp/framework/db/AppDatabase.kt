package com.rjornelas.marvelapp.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rjornelas.marvelapp.framework.db.dao.FavoriteDao
import com.rjornelas.marvelapp.framework.db.entity.FavoriteEntity

@Database(entities = [FavoriteEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao
}