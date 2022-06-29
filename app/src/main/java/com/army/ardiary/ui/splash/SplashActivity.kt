package com.army.ardiary.ui.splash

import android.Manifest
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.army.ardiary.data.NetworkState
import com.army.ardiary.databinding.ActivitySplashBinding
import com.army.ardiary.ui.BaseActivity
import com.army.ardiary.ui.login.LoginActivity
import com.army.ardiary.ui.main.MainActivity
import com.army.ardiary.utils.getJwt
import com.army.ardiary.viewmodel.AuthViewModel
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission


class SplashActivity: BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate){

    lateinit var authViewModel: AuthViewModel
    lateinit var permissionlistener: PermissionListener
    lateinit var tedPermission: TedPermission.Builder

    override fun initAfterBinding() {
        viewModelSetting()
        observerSetting()
        permissionSetting()

        Handler(Looper.getMainLooper()).postDelayed({
            authViewModel.autoLogin()
        }, 2000)
    }

    private fun viewModelSetting() {
        authViewModel = ViewModelProvider(this)
            .get(AuthViewModel::class.java)
    }
    private fun observerSetting(){
        authViewModel.networkState.observe(this, Observer {
            when(it){
                NetworkState.ERROR -> {
                    showToast("네트워크에 문제가 발생했습니다.")
                    finish()
                }
                NetworkState.LOADED -> {
                    tedPermission.check()
                }
                NetworkState.LOADING -> {}
            }
        })
        authViewModel.authResponse.observe(this, Observer {
            when(it.code){
                else -> startActivityWithClear(MainActivity::class.java)
            }
        })
    }
    private fun permissionSetting(){
        permissionlistener = object : PermissionListener {
            override fun onPermissionGranted() {
                showToast("Permission Granted")
                // Check Token and start mainActivity
                startActivityWithClear(
                    if(getJwt() == null) LoginActivity::class.java
                    else MainActivity::class.java
                )
            }

            override fun onPermissionDenied(deniedPermissions: List<String>) {
                showToast("Permission Denied\n$deniedPermissions")
                finish()
            }
        }

        tedPermission = TedPermission.create()
            .setPermissionListener(permissionlistener)
            .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
            .setPermissions(Manifest.permission.ACCESS_NETWORK_STATE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CAMERA)
    }
}