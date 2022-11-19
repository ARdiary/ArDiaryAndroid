package com.army.ardiary.data.remote.guestbook.service

import com.army.ardiary.data.remote.guestbook.dto.GuestBookDto
import retrofit2.http.GET

interface GuestBookService {

    @GET("api/diaries")
    suspend fun getGuestBookList(): List<GuestBookDto>
}