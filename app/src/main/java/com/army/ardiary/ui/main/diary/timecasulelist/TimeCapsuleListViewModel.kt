package com.army.ardiary.ui.main.diary.timecasulelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _errorMsg = MutableLiveData("")
    val errorMsg: LiveData<String> = _errorMsg

    init {
        viewModelScope.launch {
            getTimeCapsuleListUseCase()
                .onSuccess { _timeCapsuleList.emit(it) }
                .onFailure { }
        }
    }

    fun onClickTimeCapsuleItem(timeCapsuleItem: TimeCapsuleItem) {
        if (timeCapsuleItem.date.time > System.currentTimeMillis())
            _errorMsg.value = "아직 열람할 수 없습니다!"
        else {
            /* 클릭 이벤트 처리 */
        }
        _errorMsg.value = ""
    }
}