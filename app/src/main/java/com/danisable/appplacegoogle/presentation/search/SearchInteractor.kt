package com.danisable.appplacegoogle.presentation.search

import com.danisable.appplacegoogle.domain.Locations

interface SearchInteractor {

    interface Presenter {
        fun getResultsBySearch(location : String)
    }

    interface View  {
        fun onError(msg: String)
        fun setResults(locations: List<Locations>)
    }

}