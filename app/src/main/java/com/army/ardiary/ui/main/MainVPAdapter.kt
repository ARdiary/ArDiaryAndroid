package com.army.ardiary.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.army.ardiary.ui.main.camera.ArFragment
import com.army.ardiary.ui.main.map.MapFragment

class MainVPAdapter(fa: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fa, lifecycle) {

    override fun createFragment(position: Int): Fragment =
        if (position == 0) ArFragment() else MapFragment()

    override fun getItemCount(): Int = 2
}