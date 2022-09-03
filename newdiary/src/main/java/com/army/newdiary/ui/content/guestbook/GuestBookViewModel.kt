package com.army.newdiary.ui.content.guestbook

import androidx.lifecycle.ViewModel
import com.army.newdiary.domain.model.getCurrentDate
import kotlinx.coroutines.flow.MutableStateFlow

class GuestBookViewModel : ViewModel() {

    val contentText = MutableStateFlow("")
    val currentDate = getCurrentDate()

}