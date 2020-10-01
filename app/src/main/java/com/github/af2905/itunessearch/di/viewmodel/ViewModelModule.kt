package com.github.af2905.itunessearch.di.viewmodel

import android.app.Application
import com.github.af2905.itunessearch.App
import com.github.af2905.itunessearch.repository.Repository
import com.github.af2905.itunessearch.viewmodel.SearchViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule(app: App) {
    var app: Application = app

    @Provides
    fun providesArtistsViewModel(repository: Repository): SearchViewModel {
        return SearchViewModel(app, repository)
    }
}