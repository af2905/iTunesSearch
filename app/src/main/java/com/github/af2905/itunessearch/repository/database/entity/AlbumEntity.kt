package com.github.af2905.itunessearch.repository.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity(tableName = "albums")
data class AlbumEntity(
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
    val artistId: Int? = null,

    @SerializedName("amgArtistId")
    @Expose
    val amgArtistId: Int? = null,

    @SerializedName("primaryGenreName")
    @Expose
    val primaryGenreName: String? = null,

    @SerializedName("primaryGenreId")
    @Expose
    val primaryGenreId: Int? = null,

    @SerializedName("collectionType")
    @Expose
    val collectionType: String? = null,

    @SerializedName("collectionId")
    @Expose
    @PrimaryKey
    val collectionId: Int,

    @SerializedName("collectionName")
    @Expose
    val collectionName: String? = null,

    @SerializedName("collectionCensoredName")
    @Expose
    val collectionCensoredName: String? = null,

    @SerializedName("artistViewUrl")
    @Expose
    val artistViewUrl: String? = null,

    @SerializedName("collectionViewUrl")
    @Expose
    val collectionViewUrl: String? = null,

    @SerializedName("artworkUrl60")
    @Expose
    val artworkUrl60: String? = null,

    @SerializedName("artworkUrl100")
    @Expose
    val artworkUrl100: String? = null,

    @SerializedName("collectionPrice")
    @Expose
    val collectionPrice: Double? = null,

    @SerializedName("collectionExplicitness")
    @Expose
    val collectionExplicitness: String? = null,

    @SerializedName("trackCount")
    @Expose
    val trackCount: Int? = null,

    @SerializedName("copyright")
    @Expose
    val copyright: String? = null,

    @SerializedName("country")
    @Expose
    val country: String? = null,

    @SerializedName("currency")
    @Expose
    val currency: String? = null,

    @SerializedName("releaseDate")
    @Expose
    val releaseDate: String? = null
)