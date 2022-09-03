package com.army.ardiary.ui.profile.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.army.ardiary.R

class MenuItem(
    context: Context,
    attrs: AttributeSet?
) : LinearLayout(context, attrs) {

    init {
        (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(R.layout.view_profile_menu_item, this, true)

        val a = context.obtainStyledAttributes(attrs, R.styleable.ProfileCustomMenuItem)

        val iconView = findViewById<ImageView>(R.id.iv_icon)
        val titleView = findViewById<TextView>(R.id.tv_title)

        titleView.text = a.getString(R.styleable.ProfileCustomMenuItem_menuTitle)
        iconView.setImageDrawable(a.getDrawable(R.styleable.ProfileCustomMenuItem_menuIcon))

        a.recycle()
    }
}