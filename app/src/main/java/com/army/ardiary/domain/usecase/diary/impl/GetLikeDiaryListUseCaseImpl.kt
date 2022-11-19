package com.army.ardiary.domain.usecase.diary.impl

import com.army.ardiary.domain.model.DiaryContent
import com.army.ardiary.domain.repository.DiaryRepository
import com.army.ardiary.domain.usecase.diary.GetLikeDiaryListUseCase
import javax.inject.Inject

class GetLikeDiaryListUseCaseImpl @Inject constructor(
    private val diaryRepository: DiaryRepository
) : GetLikeDiaryListUseCase {

    override suspend fun invoke(): Result<List<DiaryContent>> = diaryRepository.getLikeDiaryList()
}