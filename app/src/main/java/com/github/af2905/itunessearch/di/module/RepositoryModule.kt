package com.github.af2905.itunessearch.di.module

import com.github.af2905.itunessearch.di.scope.RepositoryScope
import com.github.af2905.itunessearch.repository.Repository
import com.github.af2905.itunessearch.repository.database.AppDatabase
import com.github.af2905.itunessearch.repository.server.ServerCommunicator
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    /* @RepositoryScope
   @Provides
/  fun providesRepository(communicator: ServerCommunicator, dao: ArtistDao): Repository {
       return Repository(communicator, dao)
   }*/
    @RepositoryScope
    @Provides
    fun providesRepository(communicator: ServerCommunicator, database: AppDatabase): Repository {
        return Repository(communicator, database)
    }
}