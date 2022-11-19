package com.army.ardiary.ui.profile.like.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.army.ardiary.domain.model.DiaryContent
import com.army.ardiary.domain.model.DiaryItem
import com.army.ardiary.domain.usecase.diary.GetLikeDiaryListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LikeDiaryViewModel @Inject constructor(
    private val getLikeDiaryListUseCase: GetLikeDiaryListUseCase
) : ViewModel() {
    private val _likeDiaryList = MutableStateFlow<List<DiaryContent>>(emptyList())
    val likeDiaryList: StateFlow<List<DiaryContent>> = _likeDiaryList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getLikeDiaryListUseCase()
                .onSuccess { _likeDiaryList.emit(it) }
                .onFailure { }
        }
    }
}