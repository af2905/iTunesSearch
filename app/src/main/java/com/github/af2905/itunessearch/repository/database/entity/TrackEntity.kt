package com.github.af2905.itunessearch.repository.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
@Entity(tableName = "songs")
data class TrackEntity(
    @SerializedName("wrapperType")
    @Expose
    val wrapperType: String? = null,

    @SerializedName("collectionType")
    @Expose
    val collectionType: String? = null,

    @SerializedName("artistId")
    @Expose
    val artistId: Int? = null,

    @SerializedName("collectionId")
    @Expose
    val collectionId: Int? = null,

    @SerializedName("amgArtistId")
    @Expose
    val amgArtistId: Int? = null,

    @SerializedName("artistName")
    @Expose
    val artistName: String? = null,

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
    val releaseDate: String? = null,

    @SerializedName("primaryGenreName")
    @Expose
    val primaryGenreName: String? = null,

    @SerializedName("kind")
    @Expose
    val kind: String? = null,

    @SerializedName("trackId")
    @Expose
    @PrimaryKey
    val trackId: Int,

    @SerializedName("trackName")
    @Expose
    val trackName: String? = null,

    @SerializedName("trackCensoredName")
    @Expose
    val trackCensoredName: String? = null,

    @SerializedName("trackViewUrl")
    @Expose
    val trackViewUrl: String? = null,

    @SerializedName("previewUrl")
    @Expose
    val previewUrl: String? = null,

    @SerializedName("artworkUrl30")
    @Expose
    val artworkUrl30: String? = null,

    @SerializedName("trackPrice")
    @Expose
    val trackPrice: Double? = null,

    @SerializedName("trackExplicitness")
    @Expose
    val trackExplicitness: String? = null,

    @SerializedName("discCount")
    @Expose
    val discCount: Int? = null,

    @SerializedName("discNumber")
    @Expose
    val discNumber: Int? = null,

    @SerializedName("trackNumber")
    @Expose
    val trackNumber: Int? = null,

    @SerializedName("trackTimeMillis")
    @Expose
    val trackTimeMillis: Int? = null,

    @SerializedName("isStreamable")
    @Expose
    val isStreamable: Boolean? = null
)