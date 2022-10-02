package com.army.ardiary.data.remote.auth

import com.army.ardiary.data.remote.auth.dto.AuthDto
import com.army.ardiary.data.remote.auth.dto.UserDto
import javax.inject.Inject

class AuthNetworkDataSourceImpl @Inject constructor(
    private val authService: AuthService
) : AuthNetworkDataSource {

    override suspend fun login(userDto: UserDto): AuthDto = authService.login(userDto)

    override suspend fun signUp(userDto: UserDto): AuthDto = authService.signUp(userDto)
}