package com.danisable.appplacegoogle.presentation.search

import android.content.Context
import android.location.Location
import android.util.Log
import com.danisable.appplacegoogle.R
import com.danisable.appplacegoogle.data.remoto.RetrofitBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SearchPresenter(private val context: Context, private val view: SearchInteractor.View): SearchInteractor.Presenter,
    CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    private val retrofit = RetrofitBuilder()

    override fun getResultsBySearch(search: String) {
        if(search.isEmpty()) {
            view.onError("Plase write a correct location.")
        }else{
            launch {
                val latitude = "32.488334"
                val longitude = "-117.018182"
                val radius = 1000
                val apiKey = "AIzaSyB9yqLaK7oDvr29_8_3njEco20Mnt8iUks"//context.getString(R.string.google_api_key)

                val response = retrofit.goToSearch(search, "$latitude,$longitude", radius.toString(), apiKey)
                if (response.isSuccessful) {
                    Log.e("TAG", "${response.body()}")
                } else {
                    view.onError("Data not fund")
                }
            }
        }
    }
}