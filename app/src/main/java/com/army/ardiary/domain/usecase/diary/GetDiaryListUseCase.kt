package com.army.ardiary.domain.usecase.diary

import com.army.ardiary.domain.model.DiaryItem

interface GetDiaryListUseCase {

    suspend operator fun invoke(): Result<List<DiaryItem>>
}