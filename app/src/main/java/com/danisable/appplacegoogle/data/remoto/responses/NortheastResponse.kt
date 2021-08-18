package com.danisable.appplacegoogle.data.remoto.responses

import com.google.gson.annotations.SerializedName

data class NortheastResponse(
    @SerializedName("lng")
    val lng: Double,
    @SerializedName("lat")
    val lat: Double
)