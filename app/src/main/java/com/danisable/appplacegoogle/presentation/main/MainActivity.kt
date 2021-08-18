package com.danisable.appplacegoogle.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.danisable.appplacegoogle.R
import com.danisable.appplacegoogle.domain.Locations
import com.danisable.appplacegoogle.presentation.search.SearchActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View, OnMapReadyCallback {
    private var mMap: GoogleMap? = null
    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMap()
        initPresenter()
        setupActions()
    }

    private fun setupActions() {
        fbSearch.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume(){
        super.onResume()
        getLocations()
    }

    override fun onMapReady(google: GoogleMap) {
        //val defaultLocatation = LatLng(39.481186,-0.340987)
        //google.addMarker(MarkerOptions().position(defaultLocatation).title("My first location"))
        //google.moveCamera(CameraUpdateFactory.newLatLng(defaultLocatation))

        mMap = google
        getLocations()

    }

    override fun setLocations(points: List<Locations>){
        for(point in points) {
            //Log.e("TAG","${point.position?.latitude}")
            val defaultLocatation = point.position?.let { LatLng(it.latitude,point.position.longitude) }
            mMap?.addMarker(MarkerOptions().position(defaultLocatation).title(point.description))
            mMap?.moveCamera(CameraUpdateFactory.newLatLng(defaultLocatation))
        }
    }

    private fun initPresenter(){
        presenter = MainPresenter(this, this)
    }

    private fun initMap(){
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun getLocations(){
        presenter!!.getLocations()
    }
}