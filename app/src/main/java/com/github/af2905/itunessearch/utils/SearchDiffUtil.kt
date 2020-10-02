package com.github.af2905.itunessearch.utils

import androidx.recyclerview.widget.DiffUtil
import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity

class SearchDiffUtil(
    private val oldList: List<ArtistEntity>,
    private val newList: List<ArtistEntity>
) :
    DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].artistId == newList[newItemPosition].artistId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].artistName == newList[newItemPosition].artistName
                && oldList[oldItemPosition].artistType == newList[newItemPosition].artistType
    }
}