package com.army.ardiary.ui.profile.like.viewmodel

import androidx.lifecycle.ViewModel
import com.army.ardiary.domain.usecase.guestbook.GetLikeGuestBookListUseCase
import javax.inject.Inject

class LikeGuestBookViewModel @Inject constructor(
    private val getLikeGuestBookListUseCase: GetLikeGuestBookListUseCase
) : ViewModel() {

}