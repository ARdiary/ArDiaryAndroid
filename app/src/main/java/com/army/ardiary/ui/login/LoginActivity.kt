package com.army.ardiary.ui.login

import android.util.Log
import android.view.View
import com.army.ardiary.ApplicationClass.Companion.TAG
import com.army.ardiary.databinding.ActivityLoginBinding
import com.army.ardiary.ui.BaseActivity
import com.army.ardiary.ui.profile.MyProfileActivity
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate),
    View.OnClickListener {
    val kakaoOAuthApi = ""
    val kakaoGetTokenApi = ""

    override fun initAfterBinding() {
        binding.loginSignUpTv.setOnClickListener(this)
        binding.loginSignInBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == null) return

        when (v) {
            binding.loginSignUpTv -> startNextActivity(MyProfileActivity::class.java)
            binding.loginSignInBtn -> login()
        }
    }

    private fun login() {
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this@LoginActivity)) {
            UserApiClient.instance.loginWithKakaoTalk(this@LoginActivity, callback = callback)
        } else {
            UserApiClient.instance.loginWithKakaoAccount(this@LoginActivity, callback = callback)
        }
    }

    private val callback : (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            error.printStackTrace()
        } else if (token != null) {
            UserApiClient.instance.me { user, error ->
                val kakaoId = user!!.id
                //viewModel?.addKakaoUser(token.accessToken, kakaoId)
            }
            Log.d(TAG, "로그인성공 - 토큰 $token")
        }
    }
}