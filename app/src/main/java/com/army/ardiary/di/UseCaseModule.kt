package com.army.ardiary.di

import com.army.ardiary.domain.usecase.diary.GetDiaryListUseCase
import com.army.ardiary.domain.usecase.diary.impl.GetDiaryListUseCaseImpl
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
}