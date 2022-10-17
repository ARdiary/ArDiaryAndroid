package com.army.ardiary.ui.common.viewutils

import android.os.Build
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import com.army.ardiary.R
import com.bumptech.glide.Glide
import java.util.*

@BindingAdapter("dDayColor")
fun CardView.setDDayColor(date: Date) {
    val currentTime = System.currentTimeMillis()

    if (date.time <= currentTime) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            this.setCardBackgroundColor(resources.getColor(R.color.lightGreen, null))
        else this.setCardBackgroundColor(resources.getColor(R.color.lightGreen))
    }
}