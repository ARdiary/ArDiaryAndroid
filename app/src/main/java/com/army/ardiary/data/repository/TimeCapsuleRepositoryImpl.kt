package com.army.ardiary.data.repository

import com.army.ardiary.domain.model.TimeCapsuleItem
import com.army.ardiary.domain.repository.TimeCapsuleRepository
import java.util.*
import javax.inject.Inject

class TimeCapsuleRepositoryImpl @Inject constructor() : TimeCapsuleRepository {

    override suspend fun getTimeCapsuleList(): Result<List<TimeCapsuleItem>> {
        return runCatching {
            val name = listOf("name1", "name2", "name3")
            listOf(
                TimeCapsuleItem(0, "경주", name, Date()),
                TimeCapsuleItem(
                    1,
                    "경주 그 어딘가",
                    name,
                    Date(System.currentTimeMillis() + 3600000 * 24 * 3)
                ),
                TimeCapsuleItem(2, "인천", name, Date()),
            )
        }
    }
}