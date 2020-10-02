package com.github.af2905.itunessearch.presentation.views.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.af2905.itunessearch.R
import com.github.af2905.itunessearch.di.viewmodel.ViewModelComponent
import com.github.af2905.itunessearch.presentation.SearchBar
import com.github.af2905.itunessearch.presentation.adapters.ArtistAdapter
import com.github.af2905.itunessearch.presentation.base.BaseFragment
import com.github.af2905.itunessearch.presentation.items.IArtistClickListener
import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity
import com.github.af2905.itunessearch.utils.SearchDiffUtil
import com.github.af2905.itunessearch.viewmodel.SearchViewModel
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_search.view.*
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SearchFragment : BaseFragment() {
    private lateinit var recycler: RecyclerView
    private lateinit var searchBar: SearchBar
    private val adapter = ArtistAdapter()
    private val disposeBag = CompositeDisposable()
    private val artistClickListener: IArtistClickListener<ArtistEntity> =
        object : IArtistClickListener<ArtistEntity> {
            override fun openAlbums(m: ArtistEntity) {
                TODO("Not yet implemented")
            }
        }

    var viewModel: SearchViewModel? = null
        @Inject set

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        searchBar = SearchBar(activity.applicationContext)
        initRecyclerView(view, adapter)
        loadDataFromViewModel()
        loadArtistsWhenTextChanged()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* view.findViewById<Button>(R.id.button_first).setOnClickListener {
             findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
         }*/
    }

    private fun initRecyclerView(view: View, adapter: ArtistAdapter) {
        adapter.setClickListener(artistClickListener)
        recycler = view.artists_recycler_view
        recycler.adapter = adapter
    }

    private fun loadDataFromViewModel() {
        viewModel?.getLiveDataFoundArtists()
            ?.observe(viewLifecycleOwner, { setDataInAdapter(adapter, it) })

    }

    private fun setDataInAdapter(adapter: ArtistAdapter, artists: List<ArtistEntity>): Disposable {
        val listOfArtist: Observable<List<ArtistEntity>> = Observable.fromArray(artists)
        val disposable = listOfArtist
            .map { DiffUtil.calculateDiff(SearchDiffUtil(adapter.getArtists(), it)) }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { adapter.setArtists(artists) }
            .subscribe { it.dispatchUpdatesTo(adapter) }
        disposeBag.add(disposable)
        return disposable
    }


    private fun loadArtistsWhenTextChanged() {
        disposeBag.add(
            Observable.create(ObservableOnSubscribe<String> {
                searchBar.editText.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {
                        Log.d("TAG", s.toString())
                        Log.d("TAG", it.toString())
                    }

                    override fun onTextChanged(
                        s: CharSequence?,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {
                        Log.d("TAG", s.toString())
                        Log.d("TAG", it.toString())
                    }

                    override fun afterTextChanged(s: Editable?) {
                        Log.d("TAG", it.toString())
                        Log.d("TAG", s.toString())
                        it.onNext(s.toString())
                    }
                })
            })
                .map { text -> text.toLowerCase(Locale.ROOT).trim() }
                .debounce(250, TimeUnit.MILLISECONDS)
                .distinct()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("TAG", it)
                    viewModel?.downloadArtistsUponRequest(it)
                }
        )
    }
}