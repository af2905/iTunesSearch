package com.github.af2905.itunessearch.di.database

import com.github.af2905.itunessearch.repository.database.dao.AlbumDao
import com.github.af2905.itunessearch.repository.database.dao.TrackDao
import dagger.Component

@Component(modules = [DatabaseModule::class])
interface DatabaseComponent {
    val albumDao: AlbumDao
    val trackDao: TrackDao
}