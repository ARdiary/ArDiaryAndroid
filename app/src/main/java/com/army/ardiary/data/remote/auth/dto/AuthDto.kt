package com.army.ardiary.data.remote.auth.dto

import com.army.ardiary.domain.model.Auth
import com.google.gson.annotations.SerializedName

data class AuthDto(@SerializedName("jwt") val jwt: String){
    fun toAuth(): Auth = Auth(token = jwt)
}