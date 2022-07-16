package com.army.ardiary.ui.login

import android.util.Log
import android.view.View
import com.army.ardiary.databinding.ActivityLoginBinding
import com.army.ardiary.ui.BaseActivity
import com.army.ardiary.ui.profile.MyProfileActivity
import com.gun0912.tedpermission.provider.TedPermissionProvider.context

class LoginActivity: BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate), View.OnClickListener {

    override fun initAfterBinding() {
        binding.loginSignUpTv.setOnClickListener(this)
        binding.loginSignInBtn.setOnClickListener(this)
        appContext = this
        KakaoSdk.init(this,getString(R.string.kakao_app_key))
    }

    override fun onClick(v: View?) {
        if(v == null) return

        when(v) {
            binding.loginSignUpTv -> startNextActivity(MyProfileActivity::class.java)
            binding.loginSignInBtn -> login()
        }
    }

    private fun login() {
        UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
            if (error != null) Log.e("TAG", "로그인 실패", error)
            else if (token != null) Log.i("TAG", "로그인 성공 ${token.accessToken}")
        }
    }
}