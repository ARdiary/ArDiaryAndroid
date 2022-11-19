package com.army.ardiary.domain.usecase.guestbook.impl

import com.army.ardiary.domain.model.GuestBook
import com.army.ardiary.domain.repository.GuestBookRepository
import com.army.ardiary.domain.usecase.guestbook.GetLikeGuestBookListUseCase
import javax.inject.Inject

class GetLikeGuestBookListUseCaseImpl @Inject constructor(
    private val guestBookRepository: GuestBookRepository
) : GetLikeGuestBookListUseCase {

    override suspend fun invoke(): Result<List<GuestBook>> =
        guestBookRepository.getLikeGuestBookList()
}