package com.example.hyperdealsbusiness

import android.content.Intent
import android.net.wifi.WifiConfiguration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.PlacesClient
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    lateinit var placesClient: PlacesClient
    var placeFields = Arrays.asList(Place.Field.ID,Place.Field.NAME,Place.Field.ADDRESS,Place.Field.LAT_LNG)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

initPlaces()
        setupPlacesAutocomplete()



        btnloginasbusinessman.setOnClickListener{
            startActivity(Intent (this,LoginActivityBusinessman::class.java))
        }





    }









    fun initPlaces(){
        Places.initialize(this,getString(R.string.places_api_key))
        placesClient  = Places.createClient(this)

    }
    fun setupPlacesAutocomplete(){
        val autocompleteFragment = supportFragmentManager.findFragmentById(R.id.place_autocomplete_fragment) as AutocompleteSupportFragment
        autocompleteFragment.setPlaceFields(placeFields)

        autocompleteFragment.setOnPlaceSelectedListener(object: PlaceSelectionListener {
            override fun onPlaceSelected(p0: Place) {

                Log.e(TAG,"${p0.address}  Lat - ${p0.latLng!!.latitude} Long - ${p0.latLng!!.longitude}")
            }

            override fun onError(p0: Status) {
Log.e(TAG,"error")

            }
        })

    }
}