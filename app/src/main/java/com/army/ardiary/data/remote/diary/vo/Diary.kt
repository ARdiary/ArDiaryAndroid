package com.army.ardiary.data.remote.diary.vo

data class Diary(
    val imagePath: String,
    val name: String,
    val description: String,
    var isLike: Boolean = false
)