package com.github.af2905.itunessearch.di.viewmodel

import com.github.af2905.itunessearch.repository.Repository
import com.github.af2905.itunessearch.viewmodel.AlbumViewModel
import com.github.af2905.itunessearch.viewmodel.SearchViewModel
import com.github.af2905.itunessearch.viewmodel.TrackViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun providesArtistViewModel(repository: Repository): SearchViewModel {
        return SearchViewModel(repository)
    }

    @Provides
    fun providesAlbumViewModel(repository: Repository): AlbumViewModel {
        return AlbumViewModel(repository)
    }

    @Provides
    fun provideTrackViewModel(repository: Repository): TrackViewModel{
        return TrackViewModel(repository)
    }
}