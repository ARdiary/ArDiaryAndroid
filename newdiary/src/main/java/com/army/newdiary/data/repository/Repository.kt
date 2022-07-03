package com.army.newdiary.data.repository

import androidx.lifecycle.LiveData
import com.army.newdiary.data.NetworkState

interface Repository {
    val data: LiveData<*>
    val networkState: LiveData<NetworkState>

    fun fetchData()
}