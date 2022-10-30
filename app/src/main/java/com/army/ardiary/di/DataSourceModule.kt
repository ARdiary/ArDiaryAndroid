package com.army.ardiary.di

import com.army.ardiary.data.remote.auth.AuthNetworkDataSource
import com.army.ardiary.data.remote.auth.AuthNetworkDataSourceImpl
import com.army.ardiary.data.remote.diary.datasource.DiaryDataSource
import com.army.ardiary.data.remote.diary.datasource.DiaryDataSourceImpl
import com.army.ardiary.data.remote.friend.datasource.FriendDataSource
import com.army.ardiary.data.remote.friend.datasource.FriendDataSourceImpl
import com.army.ardiary.data.remote.guestbook.datasource.GuestBookDataSource
import com.army.ardiary.data.remote.guestbook.datasource.GuestBookDataSourceImpl
import com.army.ardiary.data.remote.timecapsule.datasource.TimeCapsuleDataSource
import com.army.ardiary.data.remote.timecapsule.datasource.TimeCapsuleDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun provideAuthDataSource(
        authDataSource: AuthNetworkDataSourceImpl
    ): AuthNetworkDataSource

    @Singleton
    @Binds
    abstract fun provideDiaryDataSource(
        diaryDataSourceImpl: DiaryDataSourceImpl
    ): DiaryDataSource

    @Singleton
    @Binds
    abstract fun provideTimeCapsuleDataSource(
        timeCapsuleDataSourceImpl: TimeCapsuleDataSourceImpl
    ): TimeCapsuleDataSource

    @Singleton
    @Binds
    abstract fun provideGuestBookDataSource(
        guestBookDataSourceImpl: GuestBookDataSourceImpl
    ): GuestBookDataSource

    @Singleton
    @Binds
    abstract fun provideFriendDataSource(
        friendDataSourceImpl: FriendDataSourceImpl
    ): FriendDataSource
}