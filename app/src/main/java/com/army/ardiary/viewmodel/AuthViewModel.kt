package com.army.ardiary.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.army.ardiary.data.NetworkState
import com.army.ardiary.data.local.entities.User
import com.army.ardiary.data.remote.auth.AuthNetworkDataSource
import com.army.ardiary.data.remote.auth.vo.AuthResponse

class AuthViewModel:ViewModel() {
    private val authNetworkDataSource = AuthNetworkDataSource()

    var authResponse: LiveData<AuthResponse>
            = authNetworkDataSource.downloadAuthResponse

    var networkState: LiveData<NetworkState>
            = authNetworkDataSource.networkState

    fun autoLogin()
            = authNetworkDataSource.autoLogin()

    fun login(user: User)
            = authNetworkDataSource.login(user)

    fun signUp(user: User)
            = authNetworkDataSource.signUp(user)
}