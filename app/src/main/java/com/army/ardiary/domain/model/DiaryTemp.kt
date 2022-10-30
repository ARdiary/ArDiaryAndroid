package com.army.ardiary.domain.model

data class DiaryTemp(
    val imagePath: String,
    val name: String,
    val description: String,
    var isLike: Boolean = false
)