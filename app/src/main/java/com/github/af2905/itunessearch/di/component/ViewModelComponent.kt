package com.github.af2905.itunessearch.di.component

import com.github.af2905.itunessearch.di.module.ViewModelModule
import com.github.af2905.itunessearch.di.scope.ViewModelScope
import com.github.af2905.itunessearch.presentation.views.SearchFragment
import dagger.Component

@ViewModelScope
@Component(modules = [ViewModelModule::class], dependencies = [RepositoryComponent::class])
interface ViewModelComponent {
    fun inject(fragment: SearchFragment)
}