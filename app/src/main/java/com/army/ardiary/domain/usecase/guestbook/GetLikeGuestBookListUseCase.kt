package com.army.ardiary.domain.usecase.guestbook

import com.army.ardiary.domain.model.GuestBook

interface GetLikeGuestBookListUseCase {

    suspend fun invoke(): Result<List<GuestBook>>
}