package com.army.ardiary.di

import com.army.ardiary.data.repository.AuthRepositoryImpl
import com.army.ardiary.domain.repository.AuthRepository
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
}