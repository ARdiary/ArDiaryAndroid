package com.army.ardiary.ui.profile.like

import com.army.ardiary.databinding.ActivityLikeBinding
import com.army.ardiary.ui.BaseActivity
import com.army.ardiary.ui.profile.like.adapter.LikeVPAdapter
import com.google.android.material.tabs.TabLayoutMediator

class LikeActivity: BaseActivity<ActivityLikeBinding>(ActivityLikeBinding::inflate) {
    val category = arrayOf("일기♡", "방명록♡")

    override fun initAfterBinding() {
        // TabLayoutMediator
        binding.likeFragmentVp.adapter = LikeVPAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(binding.likeTabLayout, binding.likeFragmentVp){ tab, position -> tab.text = category[position] }.attach()
    }
}