package com.army.ardiary.domain.model

data class GuestBook(
    val imagePath: String,
    val title: String,
    val name: String,
    val date: String,
    val description: String,
    var isLike: Boolean = false
)