package com.army.ardiary.data.repository

import androidx.lifecycle.LiveData
import com.army.ardiary.data.NetworkState
import com.army.ardiary.data.remote.auth.AuthNetworkDataSource

class TestRepository: Repository {
    private val authNetworkDataSource = AuthNetworkDataSource()

    override var data: LiveData<*>
        = authNetworkDataSource.downloadAuthResponse

    override var networkState: LiveData<NetworkState>
        = authNetworkDataSource.networkState

    override fun fetchData()
        = authNetworkDataSource.autoLogin()
}