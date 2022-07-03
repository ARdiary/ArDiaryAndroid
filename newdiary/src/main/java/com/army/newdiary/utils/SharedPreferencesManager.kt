package com.army.newdiary.utils

import com.army.newdiary.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.army.newdiary.ApplicationClass.Companion.mSharedPreferences


fun saveJwt(jwtToken: String) {
    val editor = mSharedPreferences.edit()
    editor.putString(X_ACCESS_TOKEN, jwtToken)

    editor.apply()
}

fun getJwt(): String? = mSharedPreferences.getString(X_ACCESS_TOKEN, null)
