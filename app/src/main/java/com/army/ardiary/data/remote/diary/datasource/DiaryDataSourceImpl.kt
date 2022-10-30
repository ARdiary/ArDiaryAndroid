package com.army.ardiary.data.remote.diary.datasource

import com.army.ardiary.data.remote.diary.dto.DiaryItemDto
import com.army.ardiary.data.remote.diary.service.DiaryService
import javax.inject.Inject

class DiaryDataSourceImpl @Inject constructor(
    private val service: DiaryService
) : DiaryDataSource {

    override suspend fun getDiaryList(): List<DiaryItemDto> = service.getDiaryList()
}