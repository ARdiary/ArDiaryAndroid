package com.army.ardiary.data.remote.timecapsule.dto

import com.army.ardiary.domain.model.TimeCapsuleItem
import java.util.*

data class TimeCapsuleDto(
    val id: Int,
) {

    fun toTimeCapsuleItem(): TimeCapsuleItem =
        TimeCapsuleItem(id, "경주", listOf("name1", "name2", "name3"), Date())
}