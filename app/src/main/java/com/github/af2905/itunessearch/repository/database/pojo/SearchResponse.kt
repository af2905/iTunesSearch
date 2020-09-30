package com.github.af2905.itunessearch.repository.database.pojo

import com.github.af2905.itunessearch.repository.database.entity.ArtistEntity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class SearchResponse(
    @SerializedName("resultCount")
    @Expose
    val resultCount: Int? = null,

    @SerializedName("results")
    @Expose
    val results: List<ArtistEntity>? = null
)