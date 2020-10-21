package com.github.af2905.itunessearch.di.module

import com.github.af2905.itunessearch.repository.AlbumRepository
import com.github.af2905.itunessearch.repository.SearchRepository
import com.github.af2905.itunessearch.repository.TrackRepository
import com.github.af2905.itunessearch.repository.database.AppDatabase
import com.github.af2905.itunessearch.repository.server.ServerCommunicator
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class RepositoryModule {
    @Reusable
    @Provides
    fun providesSearchRepository(communicator: ServerCommunicator): SearchRepository {
        return SearchRepository(communicator)
    }

    @Reusable
    @Provides
    fun providesAlbumRepository(
        communicator: ServerCommunicator, database: AppDatabase
    ): AlbumRepository {
        return AlbumRepository(communicator, database.albumDao())
    }

    @Reusable
    @Provides
    fun providesTrackRepository(
        communicator: ServerCommunicator, database: AppDatabase
    ): TrackRepository {
        return TrackRepository(communicator, database.trackDao())
    }
}