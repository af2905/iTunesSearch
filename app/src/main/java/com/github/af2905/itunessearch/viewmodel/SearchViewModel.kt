package com.github.af2905.itunessearch.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.af2905.itunessearch.repository.Repository
import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SearchViewModel(private val repository: Repository) : ViewModel() {
    private val disposeBag = CompositeDisposable()
    private val liveDataArtists = MutableLiveData<List<ArtistEntity>>()

    fun downloadArtistsUponRequest(term: String) {
        disposeBag.add(
            repository.getArtists(term)
                .retry()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(TAG, it.toString())
                    liveDataArtists.value = it
                }, {

                })
        )
    }

    fun getLiveDataArtists(): LiveData<List<ArtistEntity>> {
        return liveDataArtists
    }

    override fun onCleared() {
        super.onCleared()
        disposeBag.clear()
    }

    companion object {
        private const val TAG = "TEST_OF_LOADING_DATA"
    }
}