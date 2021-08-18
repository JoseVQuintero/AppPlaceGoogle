package com.danisable.appplacegoogle.data.remoto.services

import com.danisable.appplacegoogle.data.remoto.responses.GooglePlaceResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleServices {

    @GET("place/textsearch/json")
    suspend fun getNearbyPlacesByText(
        @Query("query") query: String?,
        @Query("location") location: String?,
        @Query("radius") radius: String,
        @Query("key") key: String

    ): Response<GooglePlaceResponse>
}