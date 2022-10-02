package com.army.ardiary.data.remote.auth.dto

import com.army.ardiary.domain.model.User
import com.google.gson.annotations.SerializedName

data class UserDto(@SerializedName("email") val email: String)

fun User.toUserDto(): UserDto = UserDto(
    email = email
)