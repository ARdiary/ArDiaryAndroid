package com.army.ardiary.domain.repository

import com.army.ardiary.domain.model.TimeCapsuleItem

interface TimeCapsuleRepository {

    suspend fun getTimeCapsuleList(): Result<List<TimeCapsuleItem>>
}