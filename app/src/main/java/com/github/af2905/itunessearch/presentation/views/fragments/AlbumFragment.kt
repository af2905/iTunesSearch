package com.github.af2905.itunessearch.presentation.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.github.af2905.itunessearch.R
import com.github.af2905.itunessearch.di.viewmodel.ViewModelComponent
import com.github.af2905.itunessearch.presentation.adapters.AlbumAdapter
import com.github.af2905.itunessearch.presentation.base.BaseFragment
import com.github.af2905.itunessearch.presentation.decoration.DivItemDecoration
import com.github.af2905.itunessearch.presentation.items.IAlbumClickListener
import com.github.af2905.itunessearch.repository.database.entity.AlbumEntity
import com.github.af2905.itunessearch.viewmodel.AlbumViewModel
import kotlinx.android.synthetic.main.artist_header.*
import kotlinx.android.synthetic.main.fragment_album.*
import javax.inject.Inject
import kotlin.properties.Delegates

class AlbumFragment : BaseFragment() {
    private var artistId by Delegates.notNull<Int>()
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: AlbumAdapter
    private val albumClickListener: IAlbumClickListener<AlbumEntity> =
        object : IAlbumClickListener<AlbumEntity> {
            override fun openAlbumDetail(m: AlbumEntity) {
                showAlbumDetail(m)
            }
        }
    var viewModel: AlbumViewModel? = null
        @Inject set

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_album, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AlbumAdapter(albumClickListener)
        recycler = albums_recycler_view
        recycler.adapter = adapter
        recycler.addItemDecoration(DivItemDecoration(16, 8))
        artistId = requireArguments().getInt("id")
        artist_name_text_view.text = requireArguments().getString("name")
        viewModel?.downloadAlbumsUponRequest(artistId)
        loadDataFromViewModel()
    }

    private fun loadDataFromViewModel() {
        viewModel?.getLiveDataAlbums()
            ?.observe(viewLifecycleOwner, { adapter.submitList(it) })
    }

    private fun showAlbumDetail(album: AlbumEntity) {
        val bundle = Bundle()
        bundle.putInt("id", album.collectionId)
        bundle.putString("imageUrl", album.artworkUrl100)
        bundle.putString("genreName", album.primaryGenreName)
        bundle.putString("releaseDate", album.releaseDate)
        bundle.putString("collectionName", album.collectionName)
        album.trackCount?.let { bundle.putInt("trackCount", it) }
        findNavController().navigate(R.id.action_AlbumFragment_to_TrackFragment, bundle)
    }
}