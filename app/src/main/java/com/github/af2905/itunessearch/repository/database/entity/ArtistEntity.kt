package com.github.af2905.itunessearch.repository.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "artists")
class ArtistEntity(
    @SerializedName("wrapperType")
    @Expose
    private val wrapperType: String? = null,

    @SerializedName("artistType")
    @Expose
    private val artistType: String? = null,

    @SerializedName("artistName")
    @Expose
    private val artistName: String? = null,

    @SerializedName("artistLinkUrl")
    @Expose
    private val artistLinkUrl: String? = null,

    @SerializedName("artistId")
    @Expose
    @PrimaryKey
    private val artistId: Int,

    @SerializedName("primaryGenreName")
    @Expose
    private val primaryGenreName: String? = null,

    @SerializedName("primaryGenreId")
    @Expose
    private val primaryGenreId: Int? = null
)