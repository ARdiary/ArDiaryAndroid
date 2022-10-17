package com.army.ardiary.ui.common.viewutils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun ImageView.setImage(url: String?) {
    url?.let {
        Glide.with(context)
            .load(url)
            .placeholder(com.army.newdiary.R.drawable.img_sample_dragon)
            .into(this)
    }
}