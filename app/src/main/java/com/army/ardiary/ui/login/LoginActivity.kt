package com.army.ardiary.ui.login

import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.army.ardiary.ApplicationClass.Companion.TAG
import com.army.ardiary.databinding.ActivityLoginBinding
import com.army.ardiary.ui.BaseActivity
import com.army.ardiary.ui.main.MainActivity
import com.army.ardiary.ui.profile.MyProfileActivity
import com.army.ardiary.utils.saveJwt
import com.army.ardiary.viewmodel.AuthViewModel
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate),
    View.OnClickListener {
    val kakaoOAuthApi = ""
    val kakaoGetTokenApi = ""

    val tokens = listOf(
        "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBY2Nlc3MgVG9rZW4iLCJpZCI6MTAsImlhdCI6MTY2NzA1OTI2MiwiZXhwIjoxNjY3MDYyODYyfQ.dRlLTvE81LjNw6avhwo_M8IFm0vk7dpIECWuzCk-ULo",
        "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NjcwNTkyNjIsImV4cCI6MTY2NzE0NTY2Mn0.ZAP2nD6j8UTaf4_OBdOu0KqIabjKhPM9qKiF-J5RqPg"
    )

    private val authViewModel: AuthViewModel by viewModels()

    override fun initAfterBinding() {
        binding.loginSignUpTv.setOnClickListener(this)
        binding.loginSignInBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == null) return

        when (v) {
            binding.loginSignUpTv -> startNextActivity(MyProfileActivity::class.java)
            binding.loginSignInBtn -> {
                saveJwt(tokens[0], tokens[1])
                startNextActivity(MainActivity::class.java)
                //login()
            }
        }
    }

    private fun login() {
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this@LoginActivity)) {
            UserApiClient.instance.loginWithKakaoTalk(this@LoginActivity, callback = callback)
        } else {
            UserApiClient.instance.loginWithKakaoAccount(this@LoginActivity, callback = callback)
        }
    }

    private val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            error.printStackTrace()
        } else if (token != null) {
            saveJwt(token.accessToken, token.refreshToken)
            UserApiClient.instance.me { user, e ->
                if (e != null) {
                    e.printStackTrace()
                } else if (user != null) {
                    Log.d(TAG, "user: $user")
                    // kakao 정책상 실 서비스가 아니라 email을 강제로 받아올 수 없음
                    // 테스트로 강제로 받아오는 것으로 수행함
                    user.kakaoAccount?.let {
                        authViewModel.login(email = it.email!!)
                    }
                }
                //viewModel?.addKakaoUser(token.accessToken, kakaoId)
            }
            Log.d(TAG, "로그인성공 - 토큰 $token")
            startActivityWithClear(MainActivity::class.java)
        }
    }
}