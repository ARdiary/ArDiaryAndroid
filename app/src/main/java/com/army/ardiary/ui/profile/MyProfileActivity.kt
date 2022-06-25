package com.army.ardiary.ui.profile

import android.view.View
import com.army.ardiary.databinding.ActivityMyProfileBinding
import com.army.ardiary.ui.BaseActivity


class MyProfileActivity: BaseActivity<ActivityMyProfileBinding>(ActivityMyProfileBinding::inflate), View.OnClickListener {

    override fun initAfterBinding() {
        binding.signUpBackIv.setOnClickListener(this)
        binding.signUpSignUpBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v == null) return

        when(v) {

        }
    }

}