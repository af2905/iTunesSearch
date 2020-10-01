package com.github.af2905.itunessearch.di.api

import com.github.af2905.itunessearch.di.api.ApiModule
import com.github.af2905.itunessearch.repository.server.ServerCommunicator
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    val serverCommunicator: ServerCommunicator
}