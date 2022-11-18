package com.army.ardiary.data.remote.guestbook.datasource

import com.army.ardiary.data.remote.guestbook.dto.GuestBookDto

interface GuestBookDataSource {

    suspend fun getGuestBookList(): List<GuestBookDto>
    suspend fun getLikeGuestBookList(): List<GuestBookDto>
}