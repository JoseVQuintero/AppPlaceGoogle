package com.danisable.appplacegoogle.domain

import com.google.firebase.firestore.GeoPoint

data class Locations(
    val name: String? = "",
    val description: String? = "",
    val position: GeoPoint? = null
)