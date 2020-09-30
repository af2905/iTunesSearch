package com.github.af2905.itunessearch.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.github.af2905.itunessearch.repository.Repository
import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ArtistsViewModel(application: Application, private val repository: Repository) :
    AndroidViewModel(application) {
    private val disposeBag = CompositeDisposable()
    private val liveDataFoundArtists = MutableLiveData<List<ArtistEntity>>()

    fun downloadArtistsUponRequest() {
        disposeBag.add(
            repository.getArtists("martin")
                .retry()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(TAG, it.toString())
                    liveDataFoundArtists.value = it
                }, {

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposeBag.clear()
    }

    companion object {
        private const val TAG = "TEST_OF_LOADING_DATA"
    }
}