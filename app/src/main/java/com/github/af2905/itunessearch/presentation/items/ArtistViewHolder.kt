package com.github.af2905.itunessearch.presentation.items

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity
import kotlinx.android.synthetic.main.item_artist.view.*

class ArtistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private lateinit var artist: ArtistEntity
    private lateinit var clickListener: IArtistClickListener<ArtistEntity>
    private val openAlbums = View.OnClickListener { clickListener.openAlbums(artist) }

    val artistName = itemView.artist_name_text_view

    fun bind(artist: ArtistEntity, clickListener: IArtistClickListener<ArtistEntity>) {
        this.artist = artist
        this.clickListener = clickListener
        itemView.setOnClickListener(openAlbums)
    }
}