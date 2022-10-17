package com.army.ardiary.domain.usecase.notification

import com.army.ardiary.domain.model.Notification

interface GetNotificationListUseCase {

    suspend operator fun invoke(): Result<List<Notification>>
}