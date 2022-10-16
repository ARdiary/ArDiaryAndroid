package com.army.ardiary.data.repository

import com.army.ardiary.domain.model.DiaryContent
import com.army.ardiary.domain.model.DiaryItem
import com.army.ardiary.domain.repository.DiaryRepository
import java.util.*
import javax.inject.Inject

class DiaryRepositoryImpl @Inject constructor() : DiaryRepository {

    override suspend fun getDiaryList(): Result<List<DiaryItem>> {
        return runCatching {
            val dummyContentList = listOf(
                DiaryContent(0, "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg", "dog", " world", "전체 공개", 4),
                DiaryContent(1, "https://i.ytimg.com/vi/ByH9LuSILxU/maxresdefault.jpg", "cat", " world", "전체 공개", 3),
                DiaryContent(2, "https://miro.medium.com/max/640/0*xmispf7VSwpt0IKt.jpg", "red panda", " world", "전체 공개", 5),
            )
            listOf(
                DiaryItem(0, dummyContentList, "경주", Date()),
                DiaryItem(1, dummyContentList, "경주 그 어딘가", Date()),
                DiaryItem(2, dummyContentList, "인천", Date()),
            )
        }
    }
}