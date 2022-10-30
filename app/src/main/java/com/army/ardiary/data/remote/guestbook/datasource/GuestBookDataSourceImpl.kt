package com.army.ardiary.data.remote.guestbook.datasource

import com.army.ardiary.data.remote.guestbook.dto.GuestBookDto
import com.army.ardiary.data.remote.guestbook.service.GuestBookService
import javax.inject.Inject

class GuestBookDataSourceImpl @Inject constructor(
    private val service: GuestBookService
) : GuestBookDataSource {

    override suspend fun getGuestBookList(): List<GuestBookDto> = service.getGuestBookList()
}