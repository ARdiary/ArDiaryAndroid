package com.army.ardiary.ui.profile.friends

import com.army.ardiary.databinding.ActivityFriendsBinding
import com.army.ardiary.ui.BaseActivity
import com.army.ardiary.ui.profile.friends.adapter.FriendVPAdapter
import com.google.android.material.tabs.TabLayoutMediator

class FriendsActivity : BaseActivity<ActivityFriendsBinding>(ActivityFriendsBinding::inflate) {
    val category = arrayOf("following", "follower")

    override fun initAfterBinding() {
        // TabLayoutMediator
        binding.friendFragmentVp.adapter = FriendVPAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(
            binding.friendTabLayout,
            binding.friendFragmentVp
        ) { tab, position -> tab.text = category[position] }.attach()
        binding.searchFriendBtn.setOnClickListener { }
    }
}