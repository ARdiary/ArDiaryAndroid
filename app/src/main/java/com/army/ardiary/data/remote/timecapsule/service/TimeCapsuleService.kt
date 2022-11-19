package com.army.ardiary.data.remote.timecapsule.service

import com.army.ardiary.data.remote.timecapsule.dto.TimeCapsuleDto
import retrofit2.http.GET

interface TimeCapsuleService {

    @GET("api/diaries")
    suspend fun getTimeCapsuleList(): List<TimeCapsuleDto>
}