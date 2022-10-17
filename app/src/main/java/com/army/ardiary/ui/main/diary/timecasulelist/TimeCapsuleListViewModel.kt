package com.army.ardiary.ui.main.diary.timecasulelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.army.ardiary.domain.model.TimeCapsuleItem
import com.army.ardiary.domain.usecase.timecapsule.GetTimeCapsuleListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TimeCapsuleListViewModel @Inject constructor(
    private val getTimeCapsuleListUseCase: GetTimeCapsuleListUseCase
) : ViewModel() {

    private val _timeCapsuleList = MutableStateFlow<List<TimeCapsuleItem>>(emptyList())
    val timeCapsuleList: StateFlow<List<TimeCapsuleItem>> = _timeCapsuleList

    init {
        viewModelScope.launch {
            getTimeCapsuleListUseCase()
                .onSuccess { }
                .onFailure { }
        }
    }
}