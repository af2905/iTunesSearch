package com.github.af2905.itunessearch.presentation.items

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity
import kotlinx.android.synthetic.main.item_artist.view.*

class ArtistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private lateinit var artist: ArtistEntity
    val artistName: TextView = itemView.artist_name_text_view

    fun bind(artist: ArtistEntity) {
        this.artist = artist
    }
}