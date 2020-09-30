package com.github.af2905.itunessearch.di.module

import android.app.Application
import com.github.af2905.itunessearch.App
import com.github.af2905.itunessearch.di.scope.ViewModelScope
import com.github.af2905.itunessearch.repository.Repository
import com.github.af2905.itunessearch.viewmodel.SearchViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule(app: App) {
    var app: Application = app

    @ViewModelScope
    @Provides
    fun providesArtistsViewModel(repository: Repository): SearchViewModel {
        return SearchViewModel(app, repository)
    }
}