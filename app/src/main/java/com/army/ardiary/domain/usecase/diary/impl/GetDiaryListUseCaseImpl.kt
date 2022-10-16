package com.army.ardiary.domain.usecase.diary.impl

import com.army.ardiary.domain.model.DiaryItem
import com.army.ardiary.domain.repository.DiaryRepository
import com.army.ardiary.domain.usecase.diary.GetDiaryListUseCase
import javax.inject.Inject

class GetDiaryListUseCaseImpl @Inject constructor(
    private val diaryRepository: DiaryRepository
) : GetDiaryListUseCase {

    override suspend fun invoke(): Result<List<DiaryItem>> = diaryRepository.getDiaryList()
}