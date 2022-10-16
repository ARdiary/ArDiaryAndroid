package com.army.ardiary.ui.common.viewutils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.util.*

@BindingAdapter("updatedTime")
fun TextView.setUpdatedTime(date: Date) {
    "최근 업데이트 : 19시 25분"
    val currentTime = System.currentTimeMillis()

    val diff: Long = currentTime - date.time
    val seconds = diff / 1000
    val minutes = seconds / 60
    val hours = minutes / 60
    val days = hours / 24
    val years = days / 365

    val t = "최근 업데이트 : " + if (years > 0) "${years}년 전"
    else if (days > 0) "${days}일 전"
    else if (hours > 0) "${hours}시간 전"
    else if (minutes > 0) "${minutes}분 전"
    else "방금 전"

    text = t
}