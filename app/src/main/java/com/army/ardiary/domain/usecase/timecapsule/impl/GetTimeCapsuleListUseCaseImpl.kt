package com.army.ardiary.domain.usecase.timecapsule.impl

import com.army.ardiary.domain.model.DiaryItem
import com.army.ardiary.domain.model.TimeCapsuleItem
import com.army.ardiary.domain.repository.TimeCapsuleRepository
import com.army.ardiary.domain.usecase.diary.GetDiaryListUseCase
import com.army.ardiary.domain.usecase.timecapsule.GetTimeCapsuleListUseCase
import javax.inject.Inject

class GetTimeCapsuleListUseCaseImpl @Inject constructor(
    private val timeCapsuleRepository: TimeCapsuleRepository
) : GetTimeCapsuleListUseCase {

    override suspend fun invoke(): Result<List<TimeCapsuleItem>> = timeCapsuleRepository.getTimeCapsuleList()
}