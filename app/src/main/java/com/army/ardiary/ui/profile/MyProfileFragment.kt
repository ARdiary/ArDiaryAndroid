
package com.army.ardiary.ui.profile

import com.army.ardiary.R
import com.army.ardiary.databinding.FragmentMyProfileBinding
import com.army.ardiary.ui.BaseFragment
import com.army.ardiary.ui.profile.friends.FriendsActivity
import com.army.ardiary.ui.profile.like.LikeActivity

class MyProfileFragment : BaseFragment<FragmentMyProfileBinding>(FragmentMyProfileBinding::inflate) {
    lateinit var myProfileActivity: MyProfileActivity

    override fun initAfterBinding() {
        myProfileActivity = requireActivity() as MyProfileActivity
        buttonSetting()
    }
    private fun buttonSetting(){
        binding.editProfileBtn.setOnClickListener {
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .replace(R.id.profile_fragment_layout, EditProfileFragment())
                .commitAllowingStateLoss()
        }
        binding.friendList.setOnClickListener { myProfileActivity.startNextActivity(FriendsActivity::class.java) }
        binding.likeList.setOnClickListener { myProfileActivity.startNextActivity(LikeActivity::class.java) }
    }
}