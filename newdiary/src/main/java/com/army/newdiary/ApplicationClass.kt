package com.army.newdiary

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class ApplicationClass : Application() {
    companion object {
        const val X_ACCESS_TOKEN: String = "X-ACCESS-TOKEN"         // JWT Token Key
        const val TAG: String = "DIARY-APP"                      // Log, SharedPreference
        const val APP_DATABASE = "$TAG-DB"

        const val DEV_URL: String = "https://www.naver.com"       // 테스트 서버 주소
        const val PROD_URL: String = "url"    // 실서버 주소
        const val BASE_URL: String = DEV_URL

        lateinit var mSharedPreferences: SharedPreferences
    }

    override fun onCreate() {
        super.onCreate()

        mSharedPreferences = applicationContext.getSharedPreferences(TAG, Context.MODE_PRIVATE)
    }
}