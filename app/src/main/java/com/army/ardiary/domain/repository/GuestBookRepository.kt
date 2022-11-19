package com.army.ardiary.domain.repository

import com.army.ardiary.domain.model.GuestBook

interface GuestBookRepository {

    suspend fun getLikeGuestBookList(): Result<List<GuestBook>>
}