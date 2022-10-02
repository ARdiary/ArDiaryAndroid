package com.army.ardiary.data.remote.auth

import com.army.ardiary.data.remote.auth.dto.AuthDto
import com.army.ardiary.data.remote.auth.dto.UserDto

interface AuthNetworkDataSource {

    suspend fun login(userDto: UserDto): AuthDto

    suspend fun signUp(userDto: UserDto): AuthDto
}