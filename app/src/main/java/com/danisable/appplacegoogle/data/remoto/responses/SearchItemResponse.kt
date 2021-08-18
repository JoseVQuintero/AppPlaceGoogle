package com.danisable.appplacegoogle.data.remoto.responses

import com.google.gson.annotations.SerializedName

data class SearchItemResponse(
    @SerializedName("formatted_address")
    val formatted_address: String?,
    @SerializedName("reference")
    val reference: String,
    @SerializedName("types")
    val types: List<String>,
    @SerializedName("scope")
    val scope: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("geometry")
    val geometry: GeometryResponse,
    @SerializedName("vicinity")
    val vicinity: String?,
    @SerializedName("id")
    val id: String,
    @SerializedName("photos")
    val photos: List<PhotosItemResponse>,
    @SerializedName("place_id")
    val placeId: String
)