package com.github.af2905.itunessearch.di.database

import android.content.Context
import androidx.room.Room
import com.github.af2905.itunessearch.repository.database.AppDatabase
import com.github.af2905.itunessearch.repository.database.dao.AlbumDao
import com.github.af2905.itunessearch.repository.database.dao.TrackDao
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class DatabaseModule(private val context: Context) {
    @Reusable
    @Provides
    fun providesAlbumDao(database: AppDatabase): AlbumDao {
        return database.albumDao()
    }

    @Reusable
    @Provides
    fun providesTrackDao(database: AppDatabase): TrackDao {
        return database.trackDao()
    }

    @Reusable
    @Provides
    fun providesRoomDatabase(): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "database")
            .allowMainThreadQueries()
            .build()
    }
}