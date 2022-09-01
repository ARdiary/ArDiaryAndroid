package com.army.newdiary.domain.model

import java.util.*

data class Date(
    val year: Int,
    val month: Int,
    val date: Int
) {
    fun toJavaDate(): java.util.Date {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, date)

        return calendar.time
    }
}

fun getCurrentDate(plusY: Int = 0, plusM: Int = 0, plusD: Int = 0): Date {
    val calendar = Calendar.getInstance()

    return Date(
        calendar.get(Calendar.YEAR) + plusY,
        calendar.get(Calendar.MONTH) + plusM,
        calendar.get(Calendar.DATE) + plusD
    )
}