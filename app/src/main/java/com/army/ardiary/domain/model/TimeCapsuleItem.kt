package com.army.ardiary.domain.model

import java.util.*

data class TimeCapsuleItem(
    val id: Int,
    val location: String,
    val userList: List<String>,
    val date: Date
)