package com.army.newdiary.ui.common.viewutil

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.army.newdiary.R
import com.army.newdiary.domain.model.Date
import com.army.newdiary.domain.model.getCurrentDate

@BindingAdapter("dday")
fun TextView.setDday(date: Date) {
    val curDate = getCurrentDate().toJavaDate()
    val gap = date.toJavaDate().time - curDate.time
    val dDay = gap / (1000 * 60 * 60 * 24)

    text = resources.getString(R.string.left_date, dDay.toInt())
}