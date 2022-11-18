package com.army.ardiary.ui.profile.like

import com.army.ardiary.databinding.ActivityLikeBinding
import com.army.ardiary.ui.BaseActivity
import com.army.ardiary.ui.profile.friends.adapter.FriendVPAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LikeActivity : BaseActivity<ActivityLikeBinding>(ActivityLikeBinding::inflate) {
    val category = arrayOf("일기♡", "방명록♡")

    override fun initAfterBinding() {
        initButton()
        initTabLayout()
    }

    private fun initTabLayout() {
        with(binding) {
            likeFragmentVp.adapter = FriendVPAdapter(supportFragmentManager, lifecycle)
            TabLayoutMediator(likeTabLayout, likeFragmentVp) { tab, position ->
                tab.text = category[position]
            }.attach()
        }
    }

    private fun initButton() {
        with(binding) {
            btnBack.setOnClickListener { finish() }
        }
    }
}