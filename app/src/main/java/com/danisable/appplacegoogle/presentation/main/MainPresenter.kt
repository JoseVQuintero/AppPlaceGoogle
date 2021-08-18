package com.danisable.appplacegoogle.presentation.main

import android.content.Context
import android.util.Log
import com.danisable.appplacegoogle.domain.Locations
import com.google.firebase.firestore.FirebaseFirestore

class MainPresenter(private val context: Context, private val view: MainContract.View) :
    MainContract.Presenter {

    private var database = FirebaseFirestore.getInstance()


    override fun getLocations(){
        val locations = arrayListOf<Locations>()
        database.collection("locations")
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    //Log.d("TAG", "${document.id} => ${document.data}")
                    //locations.add(Locations.form(document.data) as Locations)
                    locations.add(document.toObject(Locations::class.java))
                }
                view.setLocations(locations)
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }

        /*database.collection("locations").get()
            .addOnSuccessListener {
                documents ->
                //Log.e("TAG", documents.toString())
                for(document in documents){
                    locations.add(document.toObject(Locations::class.java))
                }
            }*/
    }

}