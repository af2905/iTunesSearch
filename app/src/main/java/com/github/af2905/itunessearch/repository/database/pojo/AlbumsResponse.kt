package com.github.af2905.itunessearch.repository.database.pojo

import com.github.af2905.itunessearch.repository.database.entity.AlbumEntity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AlbumsResponse(
    @SerializedName("resultCount")
    @Expose
    val resultCount: Int? = null,

    @SerializedName("results")
    @Expose
    val results: List<AlbumEntity>? = null
)