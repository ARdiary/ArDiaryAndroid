package com.army.ardiary.data.remote.timecapsule.datasource

import com.army.ardiary.data.remote.timecapsule.dto.TimeCapsuleDto
import com.army.ardiary.data.remote.timecapsule.service.TimeCapsuleService
import javax.inject.Inject

class TimeCapsuleDataSourceImpl @Inject constructor(
    private val service: TimeCapsuleService
) : TimeCapsuleDataSource {

    override suspend fun getTimeCapsuleList(): List<TimeCapsuleDto> = service.getTimeCapsuleList()
}