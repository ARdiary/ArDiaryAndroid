package com.army.ardiary.ui.main.diary.diarylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.army.ardiary.domain.model.DiaryItem
import com.army.ardiary.domain.usecase.diary.GetDiaryListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiaryListViewModel @Inject constructor(
    private val getDiaryListUseCase: GetDiaryListUseCase
) : ViewModel() {
    private val _diaryList = MutableStateFlow<List<DiaryItem>>(emptyList())
    val diaryList: StateFlow<List<DiaryItem>> = _diaryList

    init {
        viewModelScope.launch {
            getDiaryListUseCase()
                .onSuccess { _diaryList.emit(it) }
                .onFailure { it.printStackTrace() }
        }
    }
}