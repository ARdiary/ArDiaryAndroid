package com.army.ardiary.di

import com.army.ardiary.domain.usecase.diary.GetDiaryListUseCase
import com.army.ardiary.domain.usecase.diary.impl.GetDiaryListUseCaseImpl
import com.army.ardiary.domain.usecase.notification.GetNotificationListUseCase
import com.army.ardiary.domain.usecase.notification.impl.GetNotificationListUseCaseImpl
import com.army.ardiary.domain.usecase.timecapsule.GetTimeCapsuleListUseCase
import com.army.ardiary.domain.usecase.timecapsule.impl.GetTimeCapsuleListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Singleton
    @Binds
    abstract fun provideGetDiaryListUseCase(
        getDiaryListUseCaseImpl: GetDiaryListUseCaseImpl
    ): GetDiaryListUseCase

    @Singleton
    @Binds
    abstract fun provideGetTimeCapsuleListUseCase(
        getTimeCapsuleListUseCaseImpl: GetTimeCapsuleListUseCaseImpl
    ): GetTimeCapsuleListUseCase

    @Singleton
    @Binds
    abstract fun provideGetNotificationListUseCase(
        getNotificationListUseCaseImpl: GetNotificationListUseCaseImpl
    ): GetNotificationListUseCase
}