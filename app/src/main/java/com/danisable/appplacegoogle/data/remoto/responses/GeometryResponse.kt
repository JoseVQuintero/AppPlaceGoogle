package com.danisable.appplacegoogle.data.remoto.responses

import com.google.gson.annotations.SerializedName

data class GeometryResponse(
    @SerializedName("viewport")
    val viewport: ViewPortResponse?,
    @SerializedName("location")
    val location: LocationResponse?
)
