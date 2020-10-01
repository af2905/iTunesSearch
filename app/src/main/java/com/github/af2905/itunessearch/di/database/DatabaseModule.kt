package com.github.af2905.itunessearch.di.database

import android.content.Context
import androidx.room.Room
import com.github.af2905.itunessearch.repository.database.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule(private val context: Context) {
    /*    @Provides
        fun providesArtistDao(database: AppDatabase): ArtistDao {
            return database.artistDao()
        }*/

    @Provides
    fun providesRoomDatabase(): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "database")
            .allowMainThreadQueries()
            .build()
    }
}