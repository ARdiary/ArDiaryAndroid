package com.army.ardiary.domain.model

import java.util.*

data class Notification(
    val id: Int,
    val profileImageUrl: String,
    val title: String,
    val content: String,
    val date: Date,
)