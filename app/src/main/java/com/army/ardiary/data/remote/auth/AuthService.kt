package com.army.ardiary.data.remote.auth

import com.army.ardiary.data.remote.auth.dto.AuthDto
import com.army.ardiary.data.remote.auth.dto.UserDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("/api/signup")
    suspend fun signUp(@Body userDto: UserDto): AuthDto

    @POST("/api/login")
    suspend fun login(@Body userDto: UserDto): AuthDto
}