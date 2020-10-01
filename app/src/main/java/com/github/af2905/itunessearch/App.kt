package com.github.af2905.itunessearch

import android.app.Application
import com.github.af2905.itunessearch.di.component.*
import com.github.af2905.itunessearch.di.module.ApiModule
import com.github.af2905.itunessearch.di.module.DatabaseModule
import com.github.af2905.itunessearch.di.module.RepositoryModule
import com.github.af2905.itunessearch.di.module.ViewModelModule

class App : Application() {
    private lateinit var viewModelComponent: ViewModelComponent

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        val apiComponent = DaggerApiComponent.builder()
            .apiModule(ApiModule())
            .build()

        val databaseComponent = DaggerDatabaseComponent.builder()
            .databaseModule(DatabaseModule(applicationContext))
            .build()

        val repositoryComponent = DaggerRepositoryComponent.builder()
            .apiComponent(apiComponent)
            .databaseComponent(databaseComponent)
            .repositoryModule(RepositoryModule())
            .build()

        viewModelComponent = DaggerViewModelComponent.builder()
            .repositoryComponent(repositoryComponent)
            .viewModelModule(ViewModelModule(this))
            .build()
    }

    fun getViewModelComponent(): ViewModelComponent {
        return this.viewModelComponent
    }
}