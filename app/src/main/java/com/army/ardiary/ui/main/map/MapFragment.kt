package com.army.ardiary.ui.main.map

import com.army.ardiary.R
import com.army.ardiary.databinding.FragmentMapBinding
import com.army.ardiary.ui.BaseFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment() : BaseFragment<FragmentMapBinding>(FragmentMapBinding::inflate) {

    private lateinit var mMap: GoogleMap

    override fun initAfterBinding() {
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync {
            mMap = it

            // Add a marker in Sydney and move the camera
            val sydney = LatLng(-34.0, 151.0)
            mMap.addMarker(
                MarkerOptions()
                    .position(sydney)
                    .title("Marker in Sydney")
            )
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        }
    }
}