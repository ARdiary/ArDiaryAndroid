package com.army.ardiary.data.remote.diary.dto


import com.army.ardiary.domain.model.DiaryContent
import com.google.gson.annotations.SerializedName

data class DiaryItemDto(
    @SerializedName("armarkerId")
    val armarkerId: Int,
    @SerializedName("audio")
    val audio: String?,
    @SerializedName("content")
    val content: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("diaryId")
    val diaryId: Int,
    @SerializedName("image")
    val image: String?,
    @SerializedName("privacyOption")
    val privacyOption: Int,
    @SerializedName("title")
    val title: String?,
    @SerializedName("video")
    val video: String?,
    @SerializedName("writer")
    val writer: String
) {
    fun toDiaryContent(): DiaryContent = DiaryContent(
        id = armarkerId,
        thumbnailUrl = image ?: "",
        title = title ?: "title",
        content = content,
        type = privacyOption.toString(),
        likeCount = 0,
        commentCount = 0,
    )
}