package com.army.newdiary.ui.common.custom

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.army.newdiary.R
import com.army.newdiary.databinding.ViewMarkerPreviewBinding
import com.bumptech.glide.Glide

class MarkerPreview(
    context: Context,
    attrs: AttributeSet?
) : LinearLayout(context, attrs) {

    private val imageList: List<ImageView>
    private val binding: ViewMarkerPreviewBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.view_marker_preview,
        this,
        true
    )

    init {
        imageList = listOf(binding.defaultImageIv, binding.markerImageIv, binding.shadowImageIv)
    }

    fun setMarkerImage(url: String) {
        imageList.forEach {
            Glide.with(context)
                .load(url)
                .into(it)
        }
    }

    fun setMarkerImage(id: Int) {
        imageList.forEach {
            Glide.with(context)
                .load(id)
                .into(it)
        }
    }

    fun setMarkerImage(drawable: Drawable) {
        imageList.forEach {
            Glide.with(context)
                .load(drawable)
                .into(it)
        }
    }
}