package com.army.ardiary.ui.profile.friends

import com.army.ardiary.databinding.ActivityFriendsBinding
import com.army.ardiary.ui.BaseActivity
import com.army.ardiary.ui.profile.friends.adapter.FriendVPAdapter
import com.google.android.material.tabs.TabLayoutMediator

class FriendsActivity : BaseActivity<ActivityFriendsBinding>(ActivityFriendsBinding::inflate) {
    val category = arrayOf("following", "follower")

    override fun initAfterBinding() {
        // TabLayoutMediator
        initButton()
        initTabLayout()
    }

    private fun initTabLayout() {
        with(binding) {
            friendFragmentVp.adapter = FriendVPAdapter(supportFragmentManager, lifecycle)
            TabLayoutMediator(friendTabLayout, friendFragmentVp) { tab, position ->
                tab.text = category[position]
            }.attach()
        }
    }

    private fun initButton() {
        with(binding) {
            btnBack.setOnClickListener { finish() }
            searchFriendBtn.setOnClickListener { }
        }
    }
}