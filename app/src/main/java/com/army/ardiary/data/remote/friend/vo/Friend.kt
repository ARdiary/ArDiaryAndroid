package com.army.ardiary.data.remote.friend.vo

data class Friend(
    val profileImagePath: String,
    val name: String,
    var editable: Boolean = false
)
