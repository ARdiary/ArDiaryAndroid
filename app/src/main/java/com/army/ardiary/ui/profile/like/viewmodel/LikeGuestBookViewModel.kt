package com.army.ardiary.ui.profile.like.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.army.ardiary.domain.model.GuestBook
import com.army.ardiary.domain.usecase.guestbook.GetLikeGuestBookListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LikeGuestBookViewModel @Inject constructor(
    private val getLikeGuestBookListUseCase: GetLikeGuestBookListUseCase
) : ViewModel() {

    private val _likeGuestBookList = MutableStateFlow<List<GuestBook>>(emptyList())
    val likeGuestBook: StateFlow<List<GuestBook>> = _likeGuestBookList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getLikeGuestBookListUseCase()
                .onSuccess { _likeGuestBookList.emit(it) }
                .onFailure { }
        }
    }
}