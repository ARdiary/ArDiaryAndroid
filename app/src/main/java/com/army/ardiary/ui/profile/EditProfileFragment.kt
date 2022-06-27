
package com.army.ardiary.ui.profile


import com.army.ardiary.R
import com.army.ardiary.databinding.FragmentEditProfileBinding
import com.army.ardiary.ui.BaseFragment

class EditProfileFragment : BaseFragment<FragmentEditProfileBinding>(FragmentEditProfileBinding::inflate) {
    override fun initAfterBinding() {
        buttonSetting()
    }
    private fun buttonSetting(){
        binding.editProfileBtn.setOnClickListener {
            binding.editProfileBtn.setOnClickListener {
                requireActivity()
                    .supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.profile_fragment_layout, MyProfileFragment())
                    .commitAllowingStateLoss()
            }
        }
    }
}