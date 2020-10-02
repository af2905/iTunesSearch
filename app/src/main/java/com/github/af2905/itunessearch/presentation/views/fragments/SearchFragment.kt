package com.github.af2905.itunessearch.presentation.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.af2905.itunessearch.R
import com.github.af2905.itunessearch.di.viewmodel.ViewModelComponent
import com.github.af2905.itunessearch.presentation.adapters.ArtistAdapter
import com.github.af2905.itunessearch.presentation.afterTextChanged
import com.github.af2905.itunessearch.presentation.base.BaseFragment
import com.github.af2905.itunessearch.presentation.items.IArtistClickListener
import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity
import com.github.af2905.itunessearch.utils.SearchDiffUtil
import com.github.af2905.itunessearch.viewmodel.SearchViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_search.view.*
import kotlinx.android.synthetic.main.search_header.*
import kotlinx.android.synthetic.main.search_toolbar.view.*
import javax.inject.Inject

class SearchFragment : BaseFragment() {
    private lateinit var recycler: RecyclerView
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
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(view, adapter)
        loadDataFromViewModel()
        search_toolbar.search_edit_text.afterTextChanged {
            if (it.toString().length > 2) {
                viewModel?.downloadArtistsUponRequest(it.toString())
            }

            /* view.findViewById<Button>(R.id.button_first).setOnClickListener {
                 findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
             }*/
        }
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

    private fun setDataInAdapter(
        adapter: ArtistAdapter,
        artists: List<ArtistEntity>
    ): Disposable {
        val listOfArtist: Observable<List<ArtistEntity>> = Observable.fromArray(artists)
        val disposable = listOfArtist
            .map { DiffUtil.calculateDiff(SearchDiffUtil(adapter.getArtists(), it)) }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { adapter.setArtists(artists) }
            .subscribe { it.dispatchUpdatesTo(adapter) }
        disposeBag.add(disposable)
        return disposable
    }
}