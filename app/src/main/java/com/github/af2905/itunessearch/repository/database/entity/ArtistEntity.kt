package com.github.af2905.itunessearch.repository.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "artists")
data class ArtistEntity(
    @SerializedName("wrapperType")
    @Expose
    val wrapperType: String? = null,

    @SerializedName("artistType")
    @Expose
    val artistType: String? = null,

    @SerializedName("artistName")
    @Expose
    val artistName: String? = null,

    @SerializedName("artistLinkUrl")
    @Expose
    val artistLinkUrl: String? = null,

    @SerializedName("artistId")
    @Expose
    @PrimaryKey
    val artistId: Int,

    @SerializedName("primaryGenreName")
    @Expose
    val primaryGenreName: String? = null,

    @SerializedName("primaryGenreId")
    @Expose
    val primaryGenreId: Int? = null
)