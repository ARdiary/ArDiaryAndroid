package com.army.ardiary.data.remote.diary.datasource

import com.army.ardiary.data.remote.diary.dto.DiaryItemDto

interface DiaryDataSource {

    suspend fun getDiaryList(): List<DiaryItemDto>
}