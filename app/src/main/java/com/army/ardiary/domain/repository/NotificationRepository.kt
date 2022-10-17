package com.army.ardiary.domain.repository

import com.army.ardiary.domain.model.Notification

interface NotificationRepository {

    suspend fun getNotificationList(): Result<List<Notification>>
}