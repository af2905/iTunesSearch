package com.github.af2905.itunessearch.presentation.items

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_artist.view.*

class ArtistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val artistName: TextView = itemView.artist_name_text_view
}