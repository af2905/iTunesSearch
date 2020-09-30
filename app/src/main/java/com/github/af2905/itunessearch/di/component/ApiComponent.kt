package com.github.af2905.itunessearch.di.component

import com.github.af2905.itunessearch.di.module.ApiModule
import com.github.af2905.itunessearch.di.scope.ApiScope
import com.github.af2905.itunessearch.repository.server.ServerCommunicator
import dagger.Component

@ApiScope
@Component(modules = [ApiModule::class])
interface ApiComponent {
    val serverCommunicator: ServerCommunicator
}