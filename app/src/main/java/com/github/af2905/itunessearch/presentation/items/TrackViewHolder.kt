package com.github.af2905.itunessearch.presentation.items

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_track.view.*

class TrackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val trackNumber: TextView = itemView.track_number_text_view
    val trackName: TextView = itemView.track_name_text_view
}