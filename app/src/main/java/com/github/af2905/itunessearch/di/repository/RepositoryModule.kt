package com.github.af2905.itunessearch.di.module

import com.github.af2905.itunessearch.repository.AlbumRepository
import com.github.af2905.itunessearch.repository.SearchRepository
import com.github.af2905.itunessearch.repository.TrackRepository
import com.github.af2905.itunessearch.repository.database.dao.AlbumDao
import com.github.af2905.itunessearch.repository.database.dao.TrackDao
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
        communicator: ServerCommunicator, albumDao: AlbumDao
    ): AlbumRepository {
        return AlbumRepository(communicator, albumDao)
    }

    @Reusable
    @Provides
    fun providesTrackRepository(
        communicator: ServerCommunicator, trackDao: TrackDao
    ): TrackRepository {
        return TrackRepository(communicator, trackDao)
    }
}