package com.example.googlemap

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
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
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val india = LatLng(20.5937,78.9629)
        mMap.addMarker(MarkerOptions()
            .position(india)
            .title("Marker in India"))

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(india, 10f))

        mMap.addCircle(CircleOptions()
                .center(LatLng(20.5937,78.9629))
                .radius(10000.0)
                .strokeColor(Color.BLACK)
                .fillColor(Color.GRAY))

        mMap.addGroundOverlay(GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.common_full_open_on_phone))
                .position(india, 8600f, 6500f))

        mMap.addPolyline(PolylineOptions()
                .add(LatLng(20.5937,78.9629), LatLng(37.0902,95.7129))
                .width(5f)
                .color(Color.RED))
    }
}