package com.github.af2905.itunessearch.di.viewmodel

import com.github.af2905.itunessearch.repository.Repository
import com.github.af2905.itunessearch.viewmodel.AlbumViewModel
import com.github.af2905.itunessearch.viewmodel.SearchViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun providesArtistsViewModel(repository: Repository): SearchViewModel {
        return SearchViewModel(repository)
    }

    @Provides
    fun providesAlbumsViewModel(repository: Repository): AlbumViewModel {
        return AlbumViewModel(repository)
    }
}