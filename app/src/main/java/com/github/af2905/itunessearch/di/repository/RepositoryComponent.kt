package com.github.af2905.itunessearch.di.repository

import com.github.af2905.itunessearch.di.api.ApiComponent
import com.github.af2905.itunessearch.di.database.DatabaseComponent
import com.github.af2905.itunessearch.di.module.RepositoryModule
import com.github.af2905.itunessearch.repository.AlbumRepository
import com.github.af2905.itunessearch.repository.SearchRepository
import com.github.af2905.itunessearch.repository.TrackRepository
import dagger.Component

@Component(
    modules = [RepositoryModule::class],
    dependencies = [ApiComponent::class, DatabaseComponent::class]
)
interface RepositoryComponent {
    val searchRepository: SearchRepository
    val albumRepository: AlbumRepository
    val trackRepository: TrackRepository
}