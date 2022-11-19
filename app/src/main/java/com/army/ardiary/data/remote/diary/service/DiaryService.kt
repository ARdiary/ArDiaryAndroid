package com.army.ardiary.data.remote.diary.service

import com.army.ardiary.data.remote.diary.dto.DiaryItemDto
import retrofit2.http.GET

interface DiaryService {

    @GET("api/diaries")
    suspend fun getDiaryList(): List<DiaryItemDto>
}