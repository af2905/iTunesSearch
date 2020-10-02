package com.github.af2905.itunessearch.repository.server

import com.github.af2905.itunessearch.repository.database.pojo.SearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //https://itunes.apple.com/search?term=maroon&media=music&entity=musicArtist
    @GET("search")
    fun getArtists(
        @Query(QUERY_PARAM_TERM) term: String,
        @Query(QUERY_PARAM_MEDIA) attribute: String = MUSIC,
        @Query(QUERY_PARAM_ENTITY) entity: String = MUSIC_ARTIST
    ): Single<SearchResponse>

    companion object {
        private const val QUERY_PARAM_TERM = "term"
        private const val QUERY_PARAM_MEDIA = "media"
        private const val QUERY_PARAM_ENTITY = "entity"

        private const val MUSIC = "music"
        private const val MUSIC_ARTIST = "musicArtist"
    }
}