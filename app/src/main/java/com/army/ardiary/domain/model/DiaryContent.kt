package com.army.ardiary.domain.model

data class DiaryContent(
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val content: String,
    val type: String,
    val likeCount: Int = 0
)