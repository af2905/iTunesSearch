package com.github.af2905.itunessearch.presentation.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

class AlbumFragment : BaseFragment() {
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: AlbumAdapter
    private val albumClickListener: IAlbumClickListener<AlbumEntity> =
        object : IAlbumClickListener<AlbumEntity> {
            override fun openAlbumDetail(m: AlbumEntity) {
                Toast.makeText(requireContext(), "click!", Toast.LENGTH_SHORT).show()
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
        val artistId = requireArguments().getInt("id")
        artist_name_text_view.text = requireArguments().getString("name")
        viewModel?.downloadAlbumsUponRequest(artistId)
        loadDataFromViewModel()
    }

    private fun loadDataFromViewModel() {
        viewModel?.getLiveDataFoundAlbums()
            ?.observe(viewLifecycleOwner, { adapter.submitList(it) })
    }
}