package com.army.ardiary.data.remote.timecapsule.datasource

import com.army.ardiary.data.remote.timecapsule.dto.TimeCapsuleDto

interface TimeCapsuleDataSource {

    suspend fun getTimeCapsuleList(): List<TimeCapsuleDto>
}