package com.army.ardiary

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ApplicationClass : Application() {
    companion object {
        const val X_ACCESS_TOKEN: String = "X-ACCESS-TOKEN"         // JWT Token Key
        const val X_REFRESH_TOKEN: String = "X-REFRESH-TOKEN"         // JWT Token Key
        const val TAG: String = "DIARY-APP"                      // Log, SharedPreference
        const val APP_DATABASE = "$TAG-DB"

        const val DEV_URL: String = "http://3.39.158.43:8088/"       // 테스트 서버 주소
        const val PROD_URL: String = "url"    // 실서버 주소
        const val BASE_URL: String = DEV_URL

        lateinit var mSharedPreferences: SharedPreferences
    }

    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, getString(R.string.kakao_app_key))

        mSharedPreferences = applicationContext.getSharedPreferences(TAG, Context.MODE_PRIVATE)
    }
}