package com.danisable.appplacegoogle.data.remoto.responses

import com.google.gson.annotations.SerializedName

data class ViewPortResponse(
    @SerializedName("southwest")
    val southwest: SouthwestResponse,
    @SerializedName("northeast")
    val northeast: NortheastResponse
)