package com.danisable.appplacegoogle.data.remoto

import com.danisable.appplacegoogle.data.remoto.responses.GooglePlaceResponse
import com.danisable.appplacegoogle.data.remoto.services.GoogleServices
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    private val client = OkHttpClient.Builder().build()

    private val googleService: GoogleServices

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://maps.googleapis.com/maps/api/")
            .addConverterFactory(GsonConverterFactory.create()).client(client).build()

        googleService = retrofit.create(GoogleServices::class.java)
    }
    suspend fun goToSearch(search: String, location: String, radius: String, key: String): Response<GooglePlaceResponse > =
        googleService.getNearbyPlacesByText(search, location, radius, key)
}