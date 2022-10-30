package com.army.ardiary.data.remote.friend.dto

data class FriendDto(
    val profileImagePath: String,
    val name: String,
    var editable: Boolean = false
)
