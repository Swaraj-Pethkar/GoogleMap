package com.example.googlemap.room

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.googlemap.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapDynamic : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_dynamic)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        val id = intent.getStringExtra("id");
        val name = intent.getStringExtra("name");
        val email = intent.getStringExtra("email");
        val phoneNumber = intent.getStringExtra("phoneNumber");
        val address = intent.getStringExtra("address");
        val latitude = intent.getStringExtra("latitude");
        val longitude = intent.getStringExtra("longitude");
        val toLatitude = intent.getStringExtra("toLatitude");
        val toLongitude = intent.getStringExtra("toLongitude");
        val doubleLatitude: Double = latitude!!.toDouble()
        val doubleLongitude: Double = longitude!!.toDouble()
        val doubleToLatitude: Double = toLatitude!!.toDouble()
        val doubleToLongitude: Double = toLongitude!!.toDouble()
        mMap = googleMap
        // Add a marker in Sydney and move the camera
        val location = LatLng(doubleLatitude, doubleLongitude)
        val toLocation = LatLng(doubleToLatitude, doubleToLongitude)
        val snippet: String = " Name:$name\n Email:$email\n Phone Number:$phoneNumber\n Address:$address"

        mMap.addMarker(MarkerOptions().position(location).title("ID:$id").snippet(snippet))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 10f))

        mMap.setInfoWindowAdapter(CustomInfoWindowAdapter(applicationContext))

        mMap.addCircle(
            CircleOptions()
            .center(location)
            .radius(10000.0)
            .strokeColor(Color.BLACK)
            .fillColor(Color.GRAY))

        mMap.addGroundOverlay(
            GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.common_full_open_on_phone))
            .position(location, 8600f, 6500f))

        mMap.addPolyline(
            PolylineOptions()
            .add(location, toLocation)
            .width(5f)
            .color(Color.RED))
    }
}