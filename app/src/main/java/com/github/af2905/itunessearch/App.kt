package com.github.af2905.itunessearch

import android.app.Application
import androidx.room.Room
import com.github.af2905.itunessearch.di.api.ApiModule
import com.github.af2905.itunessearch.di.api.DaggerApiComponent
import com.github.af2905.itunessearch.di.database.DaggerDatabaseComponent
import com.github.af2905.itunessearch.di.database.DatabaseModule
import com.github.af2905.itunessearch.di.repository.DaggerRepositoryComponent
import com.github.af2905.itunessearch.di.repository.RepositoryModule
import com.github.af2905.itunessearch.di.viewmodel.DaggerViewModelComponent
import com.github.af2905.itunessearch.di.viewmodel.ViewModelComponent
import com.github.af2905.itunessearch.di.viewmodel.ViewModelModule
import com.github.af2905.itunessearch.repository.database.AppDatabase


class App : Application() {
    private lateinit var database: AppDatabase
    private lateinit var viewModelComponent: ViewModelComponent

    override fun onCreate() {
        super.onCreate()
        initRoom()
        initDagger()
    }

    private fun initRoom() {
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .allowMainThreadQueries()
            .build()
    }

    private fun initDagger() {
        val apiComponent = DaggerApiComponent.builder()
            .apiModule(ApiModule())
            .build()

        val databaseComponent = DaggerDatabaseComponent.builder()
            .databaseModule(DatabaseModule(this.database))
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