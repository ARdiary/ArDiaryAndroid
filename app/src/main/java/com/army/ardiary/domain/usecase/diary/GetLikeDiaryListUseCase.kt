package com.army.ardiary.domain.usecase.diary

import com.army.ardiary.domain.model.DiaryItem

interface GetLikeDiaryListUseCase {

    suspend operator fun invoke(): Result<List<DiaryItem>>
}