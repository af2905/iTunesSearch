package com.github.af2905.itunessearch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.af2905.itunessearch.repository.SearchRepository
import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers

class SearchViewModel(private val repository: SearchRepository) : ViewModel() {
    private var requestDisposable = Disposables.empty()
    private val liveDataArtists = MutableLiveData<List<ArtistEntity>>()

    fun downloadArtistsUponRequest(term: String) {
        requestDisposable.dispose()
        requestDisposable =
            repository.getArtists(term)
                .retry()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ liveDataArtists.value = it }, { })
    }

    fun getLiveDataArtists(): LiveData<List<ArtistEntity>> {
        return liveDataArtists
    }

    override fun onCleared() {
        super.onCleared()
        requestDisposable.dispose()
    }
}