package com.army.ardiary.domain.usecase.timecapsule

import com.army.ardiary.domain.model.TimeCapsuleItem

interface GetTimeCapsuleListUseCase {

    suspend operator fun invoke(): Result<List<TimeCapsuleItem>>
}