package com.army.ardiary.ui.main.diary.diarylist

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.army.ardiary.domain.model.DiaryItem
import com.army.ardiary.domain.usecase.diary.GetDiaryListUseCase
import com.army.ardiary.ui.main.diary.diarylist.DiaryListActivity.Companion.GRID_VERTICAL
import com.army.ardiary.ui.main.diary.diarylist.DiaryListActivity.Companion.LINEAR_VERTICAL
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

    private val _layoutType = MutableLiveData<Int>(LINEAR_VERTICAL)
    val layoutType: LiveData<Int> = _layoutType

    private val _isGrid = MutableLiveData<Int>(View.VISIBLE)
    val isGrid: LiveData<Int> = _isGrid
    private val _isLinear = MutableLiveData<Int>(View.GONE)
    val isLinear: LiveData<Int> = _isLinear

    init {
        viewModelScope.launch {
            getDiaryListUseCase()
                .onSuccess { _diaryList.emit(it) }
                .onFailure { it.printStackTrace() }
        }
    }

    fun toggleLayoutType() {
        _layoutType.value?.apply {
            when (this) {
                LINEAR_VERTICAL -> {
                    _layoutType.value = GRID_VERTICAL
                    _isGrid.value = View.GONE
                    _isLinear.value = View.VISIBLE
                }
                GRID_VERTICAL -> {
                    _layoutType.value = LINEAR_VERTICAL
                    _isGrid.value = View.VISIBLE
                    _isLinear.value = View.GONE
                }
            }
        }
    }
}