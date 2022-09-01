package com.army.newdiary.ui.content.timecapsule

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.army.newdiary.domain.model.Date
import com.army.newdiary.domain.model.getCurrentDate
import kotlinx.coroutines.flow.MutableStateFlow

class TimeCapsuleViewModel : ViewModel() {

    val titleText = MutableStateFlow("")
    val contentText = MutableStateFlow("")

    val dDayFlag = MutableLiveData(false)
    val dDay = MutableLiveData(getCurrentDate(1))

    fun onClickDdayButton() {
        dDayFlag.value = true
    }

    fun setDday(y: Int, m: Int, d: Int): Boolean {
        val currentDate = getCurrentDate()

        if (y < currentDate.year) return false
        else if (m < currentDate.month) return false
        else if (d <= currentDate.date) return false
        this.dDay.value = Date(y, m, d)

        return true
    }
}