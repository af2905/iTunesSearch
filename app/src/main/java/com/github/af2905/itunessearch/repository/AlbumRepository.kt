package com.github.af2905.itunessearch.repository

import com.github.af2905.itunessearch.repository.database.dao.AlbumDao
import com.github.af2905.itunessearch.repository.database.entity.AlbumEntity
import com.github.af2905.itunessearch.repository.server.ServerCommunicator
import io.reactivex.Single

class AlbumRepository(private val communicator: ServerCommunicator, private val dao: AlbumDao) {

    fun getAlbums(artistId: Int): Single<List<AlbumEntity>> {
        return communicator.getAlbums(artistId)
            .map { dao.insertAlbums(it) }
            .map { dao.getAll(artistId) }
    }
}