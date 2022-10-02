 package com.army.ardiary.ui.main.map

import android.app.ListActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.army.ardiary.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

 class MapActivity : AppCompatActivity(), OnMapReadyCallback {

     private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)


        var my_btn : ImageButton = findViewById<ImageButton>(R.id.my_diary_btn)

        my_btn.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)

        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

     override fun onMapReady(googleMap: GoogleMap) {
         mMap = googleMap

         // Add a marker in Sydney and move the camera
         val Seoul = LatLng(37.541, 126.986)
         val Seoul2 = LatLng(37.641, 126.886)
         //a val for how zoomed in you want to be on the map. Use zoom level 15f.
         val zoomLevel = 20f


         // Set the map type to Hybrid.

         //addMarker
         mMap.addMarker(
             MarkerOptions()
                 .position(Seoul)
                 .title("Marker in Seoul"))

         mMap.addMarker(
             MarkerOptions()
                 .position(Seoul2)
                 .title("Marker in Seoul2"))


         mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Seoul,zoomLevel))
         mMap.getUiSettings().setZoomControlsEnabled(true)

         //길게 클릭했을 때 호출
         setMapLongClick(mMap)
     }


     //길게 클릭했을 때 (저장 기능은 아직 x)
     private fun setMapLongClick(map: GoogleMap) {
         map.setOnMapLongClickListener { latLng ->
             map.addMarker(
                 MarkerOptions()
                     .position(latLng)
             )}


     }
}