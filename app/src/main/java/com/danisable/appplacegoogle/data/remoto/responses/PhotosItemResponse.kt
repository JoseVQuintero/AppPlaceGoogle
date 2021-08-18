package com.danisable.appplacegoogle.data.remoto.responses

import com.google.gson.annotations.SerializedName

data class PhotosItemResponse(
    @SerializedName("photo_reference")
    val photo_reference: String,
    @SerializedName("width")
    val width: Int,
    @SerializedName("html_attributions")
    val html_attributions: List<String>,
    @SerializedName("height")
    val height: Int
)
