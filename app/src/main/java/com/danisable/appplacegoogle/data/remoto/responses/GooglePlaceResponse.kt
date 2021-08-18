package com.danisable.appplacegoogle.data.remoto.responses
import android.speech.RecognizerResultsIntent
import com.google.gson.annotations.SerializedName;

data class GooglePlaceResponse(
    @SerializedName("next_page_token")
    val nextPAgeToken: String,
    @SerializedName("results")
    val results: MutableList<SearchItemResponse>,
    @SerializedName("status")
    val status: String
)