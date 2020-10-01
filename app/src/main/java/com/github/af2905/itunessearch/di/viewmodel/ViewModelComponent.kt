package com.github.af2905.itunessearch.di.viewmodel

import com.github.af2905.itunessearch.di.repository.RepositoryComponent
import com.github.af2905.itunessearch.presentation.views.fragments.SearchFragment
import dagger.Component

@Component(modules = [ViewModelModule::class], dependencies = [RepositoryComponent::class])
interface ViewModelComponent {
    fun inject(fragment: SearchFragment)
}