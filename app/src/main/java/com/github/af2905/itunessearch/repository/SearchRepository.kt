package com.github.af2905.itunessearch.repository

import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity
import com.github.af2905.itunessearch.repository.server.ServerCommunicator
import io.reactivex.Single

class SearchRepository(private val communicator: ServerCommunicator) {

    fun getArtists(term: String): Single<List<ArtistEntity>> {
        return communicator.getArtists(term)
    }
}