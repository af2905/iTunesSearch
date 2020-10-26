package com.github.af2905.itunessearch.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.af2905.itunessearch.repository.AlbumRepository
import com.github.af2905.itunessearch.repository.SearchRepository
import com.github.af2905.itunessearch.repository.TrackRepository
import com.github.af2905.itunessearch.viewmodel.AlbumViewModel
import com.github.af2905.itunessearch.viewmodel.SearchViewModel
import com.github.af2905.itunessearch.viewmodel.TrackViewModel
import dagger.*
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass

@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Singleton
class ViewModelFactory @Inject constructor(
    private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModelProvider = viewModels[modelClass]
            ?: throw IllegalArgumentException("model class $modelClass not found")
        return viewModelProvider.get() as T
    }
}

@Module
abstract class ViewModelModule {
    @Reusable
    @Provides
    fun providesArtistViewModel(repository: SearchRepository): SearchViewModel {
        return SearchViewModel(repository)
    }

    @Reusable
    @Provides
    fun providesAlbumViewModel(repository: AlbumRepository): AlbumViewModel {
        return AlbumViewModel(repository)
    }

    @Reusable
    @Provides
    fun provideTrackViewModel(repository: TrackRepository): TrackViewModel {
        return TrackViewModel(repository)
    }

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    internal abstract fun searchViewModel(viewModel: SearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AlbumViewModel::class)
    internal abstract fun albumViewModel(viewModel: AlbumViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TrackViewModel::class)
    internal abstract fun trackViewModel(viewModel: TrackViewModel): ViewModel
}