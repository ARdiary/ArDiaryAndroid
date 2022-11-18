package com.army.ardiary.data.repository

import com.army.ardiary.data.remote.guestbook.datasource.GuestBookDataSource
import com.army.ardiary.domain.model.GuestBook
import com.army.ardiary.domain.repository.GuestBookRepository
import javax.inject.Inject

class GuestBookRepositoryImpl @Inject constructor(
    private val dataSource: GuestBookDataSource
) : GuestBookRepository {

    override suspend fun getLikeGuestBookList(): Result<List<GuestBook>> {
        return runCatching { dataSource.getLikeGuestBookList().map { it.toGuestBook() } }
    }
}