package com.github.af2905.itunessearch.repository

import com.github.af2905.itunessearch.repository.database.dao.TrackDao
import com.github.af2905.itunessearch.repository.database.entity.TrackEntity
import com.github.af2905.itunessearch.repository.server.ServerCommunicator
import io.reactivex.Single

class TrackRepository(private val communicator: ServerCommunicator, private val dao: TrackDao) {

    fun getTracks(collectionId: Int): Single<List<TrackEntity>> {
        return communicator.getTracks(collectionId)
            .map { dao.insertTracks(it) }
            .map { dao.getAll(collectionId) }
    }
}