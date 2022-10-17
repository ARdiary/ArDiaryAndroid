package com.army.ardiary.ui.common.viewutils

import android.os.Build
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.army.ardiary.R
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("updatedTime")
fun TextView.setUpdatedTime(date: Date) {
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

@BindingAdapter("dDay")
fun TextView.setDDay(date: Date) {
    val currentTime = System.currentTimeMillis()

    val diff: Long = date.time - currentTime
    val seconds = diff / 1000
    val minutes = seconds / 60
    val hours = minutes / 60
    val days = hours / 24

    val t = if (days > 0) "D-${days}"
    else if (hours > 0) "H-${hours}"
    else if (minutes > 0) "M-${minutes}"
    else {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            this.setTextColor(resources.getColor(R.color.green, null))
        else this.setTextColor(resources.getColor(R.color.green))
        "열람 가능"
    }

    text = t
}

@BindingAdapter("date")
fun TextView.setDate(date: Date) {
    val format: SimpleDateFormat = SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분")
        .apply { timeZone = TimeZone.getTimeZone("Aisa/Seoul") }

    text = format.format(date)
}

@BindingAdapter("users")
fun TextView.setUsers(userNameList: List<String>) {
    val t = if (userNameList.size >= 2) "${userNameList[0]}외 ${userNameList.size - 1}명"
    else userNameList[0]

    text = t
}