package com.github.af2905.itunessearch.presentation.items

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_album.view.*

class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val albumImage: ImageView = itemView.album_image_view
    val albumName: TextView = itemView.album_name_text_view
    val albumArtist: TextView = itemView.album_artist_name_text_view
}