package com.github.af2905.itunessearch.presentation.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.github.af2905.itunessearch.R
import com.github.af2905.itunessearch.di.viewmodel.ViewModelComponent
import com.github.af2905.itunessearch.presentation.adapters.ArtistAdapter
import com.github.af2905.itunessearch.presentation.afterTextChanged
import com.github.af2905.itunessearch.presentation.base.BaseFragment
import com.github.af2905.itunessearch.presentation.items.IArtistClickListener
import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity
import com.github.af2905.itunessearch.viewmodel.SearchViewModel
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.search_header.*
import kotlinx.android.synthetic.main.search_toolbar.view.*
import javax.inject.Inject

class SearchFragment : BaseFragment() {
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: ArtistAdapter
    private val artistClickListener: IArtistClickListener<ArtistEntity> =
        object : IArtistClickListener<ArtistEntity> {
            override fun openAlbums(m: ArtistEntity) {
                showAlbums(m)
            }
        }

    var viewModel: SearchViewModel? = null
        @Inject set

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ArtistAdapter(artistClickListener)
        recycler = artists_recycler_view
        recycler.adapter = adapter
        loadDataFromViewModel()
        search_toolbar.search_edit_text.afterTextChanged {
            viewModel?.downloadArtistsUponRequest(it.toString())
        }
    }

    private fun loadDataFromViewModel() {
        viewModel?.getLiveDataFoundArtists()
            ?.observe(viewLifecycleOwner, { adapter.submitList(it) })
    }

    private fun showAlbums(artist: ArtistEntity) {
        val bundle = Bundle()
        bundle.putInt("id", artist.artistId)
        bundle.putString("name", artist.artistName)

        findNavController().navigate(R.id.action_SearchFragment_to_AlbumsFragment, bundle)
    }
}