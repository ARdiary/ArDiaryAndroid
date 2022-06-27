package com.army.ardiary.ui.profile.like.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.army.ardiary.ui.profile.like.DiaryListFragment
import com.army.ardiary.ui.profile.like.GuestBookListFragment

class LikeVPAdapter(fragment: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragment, lifecycle) {
    override fun getItemCount(): Int = 2

    private val diaryListFragment = DiaryListFragment()
    private val guestBookListFragment = GuestBookListFragment()

    override fun createFragment(position: Int): Fragment
    = when(position){
        0 -> diaryListFragment
        else -> guestBookListFragment
    }
}