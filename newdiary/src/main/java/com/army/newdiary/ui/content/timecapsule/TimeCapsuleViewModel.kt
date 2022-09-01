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
        var flag = false

        if (y > currentDate.year) flag = true
        else if (y == currentDate.year && m > currentDate.month) flag = true
        else if (y == currentDate.year && m == currentDate.month && d > currentDate.date)
            flag = true

        if (flag) this.dDay.value = Date(y, m, d)
        return flag
    }
}