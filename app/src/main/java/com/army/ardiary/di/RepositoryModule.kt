package com.army.ardiary.di

import com.army.ardiary.data.repository.*
import com.army.ardiary.domain.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun provideAuthRepository(
        authRepository: AuthRepositoryImpl
    ): AuthRepository

    @Singleton
    @Binds
    abstract fun provideDiaryRepository(
        diaryRepositoryImpl: DiaryRepositoryImpl
    ): DiaryRepository

    @Singleton
    @Binds
    abstract fun provideTimeCapsuleRepository(
        timeCapsuleRepositoryImpl: TimeCapsuleRepositoryImpl
    ): TimeCapsuleRepository

    @Singleton
    @Binds
    abstract fun provideNotificationRepository(
        notificationRepositoryImpl: NotificationRepositoryImpl
    ): NotificationRepository

    @Singleton
    @Binds
    abstract fun provideGuestBookRepository(
        guestBookRepositoryImpl: GuestBookRepositoryImpl
    ): GuestBookRepository
}