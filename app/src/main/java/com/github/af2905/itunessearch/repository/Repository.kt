package com.github.af2905.itunessearch.repository

import com.github.af2905.itunessearch.repository.database.AppDatabase
import com.github.af2905.itunessearch.repository.database.entity.AlbumEntity
import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity
import com.github.af2905.itunessearch.repository.server.ServerCommunicator
import io.reactivex.Single

class Repository(private val communicator: ServerCommunicator, private val database: AppDatabase) {

    fun getArtists(term: String): Single<List<ArtistEntity>> {
        return communicator.getArtists(term)
    }

    fun getAlbums(artistId: Int): Single<List<AlbumEntity>> {
        return communicator.getAlbums(artistId)
            .map { database.albumDao().insertAlbums(it) }
            .flatMap { return@flatMap Single.just(database.albumDao().getAll(artistId)) }
    }
}