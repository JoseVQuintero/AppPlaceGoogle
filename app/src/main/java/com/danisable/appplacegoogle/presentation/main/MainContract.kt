package com.danisable.appplacegoogle.presentation.main

import com.danisable.appplacegoogle.domain.Locations

interface MainContract {

    interface Presenter {
        fun getLocations()
    }

    interface View  {
        fun setLocations(locations: List<Locations>)
    }

}