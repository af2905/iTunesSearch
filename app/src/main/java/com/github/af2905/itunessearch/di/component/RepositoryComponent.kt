package com.github.af2905.itunessearch.di.component

import com.github.af2905.itunessearch.di.module.RepositoryModule
import com.github.af2905.itunessearch.di.scope.RepositoryScope
import com.github.af2905.itunessearch.repository.Repository
import dagger.Component

@RepositoryScope
@Component(
    modules = [RepositoryModule::class],
    dependencies = [ApiComponent::class, DatabaseComponent::class]
)
interface RepositoryComponent {
    val repository: Repository
}