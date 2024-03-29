package com.army.ardiary.di

import android.content.Context
import com.army.ardiary.ApplicationClass.Companion.BASE_URL
import com.army.ardiary.BuildConfig
import com.army.ardiary.config.TokenAuthenticator
import com.army.ardiary.config.XAccessTokenInterceptor
import com.army.ardiary.data.remote.auth.AuthService
import com.army.ardiary.data.remote.diary.service.DiaryService
import com.army.ardiary.data.remote.friend.service.FriendService
import com.army.ardiary.data.remote.guestbook.service.GuestBookService
import com.army.ardiary.data.remote.timecapsule.service.TimeCapsuleService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
//@InstallIn(ViewModelComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        xAccessTokenInterceptor: XAccessTokenInterceptor,
        tokenAuthenticator: TokenAuthenticator
    ): Retrofit {
        val client = OkHttpClient.Builder()
            .readTimeout(30000, TimeUnit.MILLISECONDS)
            .connectTimeout(30000, TimeUnit.MILLISECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .authenticator(tokenAuthenticator)
            .addNetworkInterceptor(xAccessTokenInterceptor) // JWT 자동 헤더 전송
            .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(BASE_URL).build()
    }

    @Singleton
    @Provides
    fun provideXAccessTokenInterceptor(@ApplicationContext context: Context): XAccessTokenInterceptor {
        return XAccessTokenInterceptor(context)
    }

    @Singleton
    @Provides
    fun provideTokenAuthenticator(@ApplicationContext context: Context): TokenAuthenticator {
        return TokenAuthenticator(context)
    }

    /* Create Service */
    @Singleton
    @Provides
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Singleton
    @Provides
    fun provideDiaryService(retrofit: Retrofit): DiaryService {
        return retrofit.create(DiaryService::class.java)
    }

    @Singleton
    @Provides
    fun provideFriendService(retrofit: Retrofit): FriendService {
        return retrofit.create(FriendService::class.java)
    }

    @Singleton
    @Provides
    fun provideGuestBookService(retrofit: Retrofit): GuestBookService {
        return retrofit.create(GuestBookService::class.java)
    }

    @Singleton
    @Provides
    fun provideTimeCapsuleService(retrofit: Retrofit): TimeCapsuleService {
        return retrofit.create(TimeCapsuleService::class.java)
    }
}