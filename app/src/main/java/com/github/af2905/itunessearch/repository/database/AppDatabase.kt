package com.github.af2905.itunessearch.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.af2905.itunessearch.repository.database.dao.AlbumDao
import com.github.af2905.itunessearch.repository.database.dao.ArtistDao
import com.github.af2905.itunessearch.repository.database.entity.AlbumEntity
import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity

@Database(entities = [ArtistEntity::class, AlbumEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun artistDao(): ArtistDao
    abstract fun albumDao(): AlbumDao
}