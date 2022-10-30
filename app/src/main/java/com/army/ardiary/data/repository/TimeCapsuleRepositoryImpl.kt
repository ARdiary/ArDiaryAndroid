package com.army.ardiary.data.repository

import com.army.ardiary.data.remote.timecapsule.datasource.TimeCapsuleDataSource
import com.army.ardiary.domain.model.TimeCapsuleItem
import com.army.ardiary.domain.repository.TimeCapsuleRepository
import javax.inject.Inject

class TimeCapsuleRepositoryImpl @Inject constructor(
    private val dataSource: TimeCapsuleDataSource
) : TimeCapsuleRepository {

    override suspend fun getTimeCapsuleList(): Result<List<TimeCapsuleItem>> {
        return runCatching { dataSource.getTimeCapsuleList().map { it.toTimeCapsuleItem() } }
    }
}