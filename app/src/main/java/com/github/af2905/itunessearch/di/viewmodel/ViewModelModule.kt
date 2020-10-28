package com.github.af2905.itunessearch.di.viewmodel

import com.github.af2905.itunessearch.repository.AlbumRepository
import com.github.af2905.itunessearch.repository.SearchRepository
import com.github.af2905.itunessearch.repository.TrackRepository
import com.github.af2905.itunessearch.viewmodel.AlbumViewModel
import com.github.af2905.itunessearch.viewmodel.SearchViewModel
import com.github.af2905.itunessearch.viewmodel.TrackViewModel
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class ViewModelModule {
    @Reusable
    @Provides
    fun providesArtistViewModel(repository: SearchRepository): SearchViewModel {
        return SearchViewModel(repository)
    }

    @Reusable
    @Provides
    fun providesAlbumViewModel(repository: AlbumRepository): AlbumViewModel {
        return AlbumViewModel(repository)
    }

    @Reusable
    @Provides
    fun provideTrackViewModel(repository: TrackRepository): TrackViewModel {
        return TrackViewModel(repository)
    }
}