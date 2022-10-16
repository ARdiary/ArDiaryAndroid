package com.army.ardiary.domain.repository

import com.army.ardiary.domain.model.DiaryItem

interface DiaryRepository {

    suspend fun getDiaryList(): Result<List<DiaryItem>>
}