package com.github.af2905.itunessearch.repository.server

import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity
import io.reactivex.Single

class ServerCommunicator(private val apiService: ApiService) {

    fun getArtists(term: String): Single<List<ArtistEntity>> {
        return apiService.getArtists(term).map { return@map it.results }
    }
}