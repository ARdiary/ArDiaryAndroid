package com.army.ardiary.data.remote.guestbook.dto

import com.army.ardiary.domain.model.GuestBook
import com.google.gson.annotations.SerializedName

data class GuestBookDto(
    @SerializedName("userId") val userId: Int,
) {

    fun toGuestBook(): GuestBook = GuestBook(
        imagePath = "https://dictionary.cambridge.org/ko/images/thumb/dog_noun_001_04904.jpg?version=5.0.244",
        title = "test1",
        name = "testing",
        date = "2022-02-22",
        description = "test",
        isLike = true,
    )
}