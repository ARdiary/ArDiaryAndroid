package com.army.ardiary.utils

import com.army.ardiary.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.army.ardiary.ApplicationClass.Companion.X_REFRESH_TOKEN
import com.army.ardiary.ApplicationClass.Companion.mSharedPreferences

fun saveJwt(jwtToken: String, refreshToken: String) {
    val editor = mSharedPreferences.edit()
    editor.putString(X_ACCESS_TOKEN, jwtToken)
    editor.putString(X_REFRESH_TOKEN, refreshToken)

    editor.apply()
}

fun getJwt(): String? = mSharedPreferences.getString(X_ACCESS_TOKEN, null)