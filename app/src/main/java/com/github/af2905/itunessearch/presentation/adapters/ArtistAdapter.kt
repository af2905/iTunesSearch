package com.github.af2905.itunessearch.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.af2905.itunessearch.R
import com.github.af2905.itunessearch.presentation.items.ArtistViewHolder
import com.github.af2905.itunessearch.presentation.items.IArtistClickListener
import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity

class ArtistAdapter : RecyclerView.Adapter<ArtistViewHolder>() {
    private var artists: MutableList<ArtistEntity> = mutableListOf()
    private lateinit var clickListener: IArtistClickListener<ArtistEntity>

    fun getArtists() = artists

    fun setArtists(artists: List<ArtistEntity>) {
        this.artists.clear()
        this.artists = artists as MutableList<ArtistEntity>
    }

    fun setClickListener(clickListener: IArtistClickListener<ArtistEntity>) {
        this.clickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_artist, parent, false)
        return ArtistViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.itemView.tag = artists[position]
        val artist = artists[position]
        holder.bind(artist, clickListener)

        holder.artistName.text = artist.artistName
    }

    override fun getItemCount(): Int = artists.size
}