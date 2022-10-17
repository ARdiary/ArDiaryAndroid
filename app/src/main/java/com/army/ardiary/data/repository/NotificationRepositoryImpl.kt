package com.army.ardiary.data.repository

import com.army.ardiary.domain.model.Notification
import com.army.ardiary.domain.repository.NotificationRepository
import java.util.*
import javax.inject.Inject

class NotificationRepositoryImpl @Inject constructor() : NotificationRepository {

    override suspend fun getNotificationList(): Result<List<Notification>> = runCatching {
        listOf(
            Notification(
                0,
                "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg",
                "dog",
                " world",
                Date()
            ),
            Notification(
                1,
                "https://i.ytimg.com/vi/ByH9LuSILxU/maxresdefault.jpg",
                "cat",
                " world",
                Date()
            ),
            Notification(
                2,
                "https://miro.medium.com/max/640/0*xmispf7VSwpt0IKt.jpg",
                "red panda",
                " world",
                Date()
            ),
        )
    }
}