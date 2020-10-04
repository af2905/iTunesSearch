package com.github.af2905.itunessearch.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.af2905.itunessearch.repository.Repository
import com.github.af2905.itunessearch.repository.database.entity.TrackEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class TrackViewModel(private val repository: Repository) : ViewModel() {
    private val disposeBag = CompositeDisposable()
    private val liveDataTracks = MutableLiveData<List<TrackEntity>>()

    fun downloadTracksUponRequest(collectionId: Int) {
        disposeBag.add(
            repository.getTracks(collectionId)
                .retry()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(TAG, it.toString())
                    liveDataTracks.value = it
                }, {

                })
        )
    }

    fun getLiveDataTracks(): LiveData<List<TrackEntity>> {
        return liveDataTracks
    }

    override fun onCleared() {
        super.onCleared()
        disposeBag.clear()
    }

    companion object {
        private const val TAG = "TEST_OF_LOADING_DATA"
    }
}