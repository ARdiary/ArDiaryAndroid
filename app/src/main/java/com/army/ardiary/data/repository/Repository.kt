package com.army.ardiary.data.repository

import androidx.lifecycle.LiveData
import com.army.ardiary.data.NetworkState

interface Repository {
    val data: LiveData<*>
    val networkState: LiveData<NetworkState>

    fun fetchData()
}