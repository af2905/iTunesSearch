package com.github.af2905.itunessearch.repository

import com.github.af2905.itunessearch.repository.database.Database
import com.github.af2905.itunessearch.repository.server.ServerCommunicator

class Repository(private val communicator: ServerCommunicator, private val database: Database) {

}