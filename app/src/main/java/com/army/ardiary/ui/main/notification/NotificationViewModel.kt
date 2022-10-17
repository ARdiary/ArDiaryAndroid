package com.army.ardiary.ui.main.notification

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.army.ardiary.domain.model.DiaryItem
import com.army.ardiary.domain.model.Notification
import com.army.ardiary.domain.usecase.notification.GetNotificationListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor(
    private val getNotificationListUseCase: GetNotificationListUseCase
) : ViewModel() {
    private val _notificationList = MutableStateFlow<List<Notification>>(emptyList())
    val notificationList: StateFlow<List<Notification>> = _notificationList

    init {
        viewModelScope.launch {
            getNotificationListUseCase()
                .onSuccess { _notificationList.emit(it) }
                .onFailure { }
        }
    }
}