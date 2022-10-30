package com.army.ardiary.domain.model

data class Friend(
    val profileImagePath: String,
    val name: String,
    var editable: Boolean = false
)
