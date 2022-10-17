package com.army.ardiary.domain.usecase.notification.impl

import com.army.ardiary.domain.model.Notification
import com.army.ardiary.domain.repository.NotificationRepository
import com.army.ardiary.domain.usecase.notification.GetNotificationListUseCase
import javax.inject.Inject

class GetNotificationListUseCaseImpl @Inject constructor(
    private val notificationRepository: NotificationRepository
) : GetNotificationListUseCase {

    override suspend fun invoke(): Result<List<Notification>> =
        notificationRepository.getNotificationList()
}