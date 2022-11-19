package com.army.ardiary.data.repository

import com.army.ardiary.data.remote.guestbook.datasource.GuestBookDataSource
import com.army.ardiary.domain.model.GuestBook
import com.army.ardiary.domain.repository.GuestBookRepository
import javax.inject.Inject

class GuestBookRepositoryImpl @Inject constructor(
    private val dataSource: GuestBookDataSource
) : GuestBookRepository {

    override suspend fun getLikeGuestBookList(): Result<List<GuestBook>> {
        return runCatching { listOf(
            GuestBook(
                "https://dictionary.cambridge.org/ko/images/thumb/dog_noun_001_04904.jpg?version=5.0.244",
                "test1",
                "testing",
                "2022-02-22",
                "test",
                true
            ),
            GuestBook(
                "https://www.collinsdictionary.com/images/full/dog_230497594.jpg",
                "test2",
                "testing",
                "2022-02-22",
                "test",
                true
            ),
            GuestBook(
                "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=1.00xw:0.669xh;0,0.190xh&resize=1200:*",
                "test3",
                "testing",
                "2022-02-22",
                "test",
                true
            ),
            GuestBook(
                "https://images.immediate.co.uk/production/volatile/sites/4/2022/06/Dog-love-hero-87954c7.jpg?quality=90&resize=940,400",
                "test4",
                "testing",
                "2022-02-22",
                "test",
                true
            ),
            GuestBook(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHfSLr7bMI_19SlJ7v4kfRWAybmJjexTCcyw&usqp=CAU",
                "test5",
                "testing",
                "2022-02-22",
                "test",
                true
            )
        ) }
    }
}