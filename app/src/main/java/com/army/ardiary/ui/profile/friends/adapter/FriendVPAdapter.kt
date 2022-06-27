package com.army.ardiary.ui.profile.friends.adapter

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.army.ardiary.ui.profile.friends.FollowerFragment
import com.army.ardiary.ui.profile.friends.FollowingFragment

class FriendVPAdapter(fragment: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragment, lifecycle) {
    override fun getItemCount(): Int = 2

    private val followingFragment = FollowingFragment()
    private val followerFragment = FollowerFragment()

    override fun createFragment(position: Int): Fragment
    = when(position){
        0 -> followingFragment
        else -> followerFragment
    }
}