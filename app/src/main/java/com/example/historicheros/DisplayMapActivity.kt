package com.example.historicheros

import android.content.Intent
import android.location.Geocoder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.historicheros.databinding.ActivityDisplayMapBinding
import com.example.historicheros.model.UserMap
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*


class DisplayMapActivity : AppCompatActivity(),GoogleMap.OnInfoWindowClickListener ,OnMapReadyCallback {
//variables
    private lateinit var mMap: GoogleMap
    private lateinit var userMap: UserMap
    private lateinit var binding: ActivityDisplayMapBinding
    private lateinit var geocoder: Geocoder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDisplayMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userMap =intent.getSerializableExtra(EXTRA_USER_MAP) as UserMap

        supportActionBar?.title = userMap.title
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
//setting long click listener on marker
        mMap.setOnMapLongClickListener { latLng ->
            mMap.addMarker(MarkerOptions()
                .position(latLng)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
                .draggable(true)
            )
        }

        googleMap.setOnInfoWindowClickListener(this)

        val boundsBuilder = LatLngBounds.Builder()
        for (place in userMap.places){
            val latLng = LatLng(place.latitude, place.longitude)
            boundsBuilder.include(latLng)

            //condition for different marker colors
            if(place.latitude == 53.341099 && place.longitude == -6.254482){
                val circle = mMap.addCircle(
                    CircleOptions()
                        .center(LatLng(53.341099, -6.254482))
                        .radius(10000.0)
                        .strokeColor(0x50465e7d)
                        .fillColor(0x3013AED4)
                )
                mMap.addMarker(

                    MarkerOptions().position(latLng)
                        .title(place.title)
                        .snippet(place.discription )
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
            }else if(place.latitude == 53.343792 && place.longitude == -6.254572){
                val circle = mMap.addCircle(
                    CircleOptions()
                        .center(LatLng(53.341099, -6.254482))
                        .radius(10000.0)
                        .strokeColor(0x50465e7d)
                        .fillColor(0x3013AED4)
                )
                mMap.addMarker(
                    MarkerOptions().position(latLng)
                        .title(place.title)
                        .snippet(place.discription )
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)))
            }else{
                val circle = mMap.addCircle(
                    CircleOptions()
                        .center(LatLng(53.341099, -6.254482))
                        .radius(10000.0)
                        .strokeColor(0x50465e7d)
                        .fillColor(0x3013AED4)
                )
                mMap.addMarker(
                    MarkerOptions().position(latLng)
                        .title(place.title)
                        .snippet(place.discription )
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)))
            }
        }
        //map animation and closer view of places
        mMap.animateCamera(CameraUpdateFactory
        .newLatLngBounds(boundsBuilder.build(), 1000, 1000, 0)
        )
    }

        override fun onInfoWindowClick(marker: Marker) {
           for (place in userMap.places){
                if (place.latitude == 53.341099){
                    val intent = Intent(this@DisplayMapActivity, LibraryMarkerActivity::class.java)
                    startActivity(intent)
                }else if (place.latitude == 53.343792){
                        val intent = Intent(this@DisplayMapActivity, TrinityMarkerActivity::class.java)
                        startActivity(intent)
                }else if (place.latitude == 53.340893){
                    val intent = Intent(this@DisplayMapActivity, GalleryMarkerActivity::class.java)
                    startActivity(intent)
                }
           }
        }

 /*   override fun onMarkerDrag(marker: Marker) {
        TODO("Not yet implemented")
        //Toast.makeText(this, "Drag!", Toast.LENGTH_SHORT).show()
    }

    override fun onMarkerDragEnd(marker: Marker) {
        TODO("Not yet implemented")
       // Toast.makeText(this, "Drag End!", Toast.LENGTH_SHORT).show()
    }

    override fun onMarkerDragStart(marker: Marker) {
        TODO("Not yet implemented")
        //Toast.makeText(this, "Drag Start!", Toast.LENGTH_SHORT).show()
    }*/
}
