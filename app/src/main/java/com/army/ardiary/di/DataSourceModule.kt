package com.army.ardiary.di

import com.army.ardiary.data.remote.auth.AuthNetworkDataSource
import com.army.ardiary.data.remote.auth.AuthNetworkDataSourceImpl
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
}