package com.army.ardiary.config

import android.content.Context
import com.army.ardiary.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.army.ardiary.utils.getJwt
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class XAccessTokenInterceptor @Inject constructor(
    private val applicationContext: Context
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        getJwt()?.let { builder.addHeader(X_ACCESS_TOKEN, it) }

        return chain.proceed(builder.build())
    }
}