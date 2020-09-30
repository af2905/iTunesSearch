package com.github.af2905.itunessearch.repository.server

import com.github.af2905.itunessearch.repository.database.pojo.SearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    fun getArtists(
        @Query(QUERY_PARAM_TERM) term: String,
        @Query(QUERY_PARAM_ENTITY) entity: String = ALL_ARTIST,
        @Query(QUERY_PARAM_ATTRIBUTE) attribute: String = ALL_ARTIST_TERM
    ): Single<SearchResponse>

    companion object {
        private const val QUERY_PARAM_TERM = "term"
        private const val QUERY_PARAM_ENTITY = "entity"
        private const val QUERY_PARAM_ATTRIBUTE = "attribute"

        private const val ALL_ARTIST = "allArtist"
        private const val ALL_ARTIST_TERM = "allArtistTerm"
    }
}