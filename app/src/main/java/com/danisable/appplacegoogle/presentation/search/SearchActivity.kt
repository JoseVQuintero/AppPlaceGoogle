package com.danisable.appplacegoogle.presentation.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.danisable.appplacegoogle.R
import com.danisable.appplacegoogle.domain.Locations
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity(), SearchInteractor.View {

    private var presenter: SearchPresenter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        presenter = SearchPresenter(this, this)
        setupActions()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun setupActions() {
        imgBack.setOnClickListener {
            onBackPressed()
        }

        btnSearch.setOnClickListener {
            val location = etSearch.text.toString()
            presenter!!.getResultsBySearch(location)
        }
    }

    override fun onError(msg: String) {

    }

    override fun setResults(locations: List<Locations>) {

    }

}