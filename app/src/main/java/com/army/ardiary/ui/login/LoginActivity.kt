package com.army.ardiary.ui.login

import android.view.View
import com.army.ardiary.databinding.ActivityLoginBinding
import com.army.ardiary.ui.BaseActivity
import com.army.ardiary.ui.profile.MyProfileActivity

class LoginActivity: BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate), View.OnClickListener {

    override fun initAfterBinding() {
        binding.loginSignUpTv.setOnClickListener(this)
        binding.loginSignInBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v == null) return

        when(v) {
            binding.loginSignUpTv -> startNextActivity(MyProfileActivity::class.java)
            binding.loginSignInBtn -> login()
        }
    }

    private fun login() {}
}