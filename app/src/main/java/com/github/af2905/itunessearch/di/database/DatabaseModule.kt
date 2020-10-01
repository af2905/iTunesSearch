package com.github.af2905.itunessearch.di.database

import com.github.af2905.itunessearch.repository.database.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule(private val database: AppDatabase) {
    @Provides
    fun providesRoomDatabase(): AppDatabase {
        return database
    }
}