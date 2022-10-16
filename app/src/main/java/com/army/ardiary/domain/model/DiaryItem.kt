package com.army.ardiary.domain.model

import java.util.*

data class DiaryItem(
    val id: Int,
    val diaryContent: List<DiaryContent>,
    val location: String,
    val currentUpdated: Date
)
