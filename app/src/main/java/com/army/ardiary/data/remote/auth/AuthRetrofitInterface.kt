package com.army.ardiary.data.remote.auth

import com.army.ardiary.data.local.entities.User
import com.army.ardiary.data.remote.auth.vo.AuthResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthRetrofitInterface {
    @POST("/users")
    fun signUp(@Body user: User): Call<AuthResponse>

    @POST("/users/login")
    fun login(@Body user: User): Call<AuthResponse>

    @GET("/users/auto-login")
    fun autoLogin(): Call<AuthResponse>
}