package com.github.af2905.itunessearch.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.af2905.itunessearch.repository.Repository
import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers

class SearchViewModel(private val repository: Repository) : ViewModel() {
    private var requestDisposable = Disposables.empty()
    private val liveDataArtists = MutableLiveData<List<ArtistEntity>>()

    fun downloadArtistsUponRequest(term: String) {
        requestDisposable =
            repository.getArtists(term)
                .retry()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(TAG, it.toString())
                    liveDataArtists.value = it
                }, {

                })
    }

    fun getLiveDataArtists(): LiveData<List<ArtistEntity>> {
        return liveDataArtists
    }

    override fun onCleared() {
        super.onCleared()
        requestDisposable.dispose()
    }

    companion object {
        private const val TAG = "TEST_OF_LOADING_DATA"
    }
}