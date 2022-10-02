package com.army.ardiary.data.remote.auth.dto

import com.google.gson.annotations.SerializedName

data class AuthResponseDto(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: AuthDto?
)