package com.army.ardiary.ui.main

import android.widget.ImageButton
import android.widget.ImageView
import com.army.ardiary.R
import com.army.ardiary.databinding.ActivityMainBinding
import com.army.ardiary.ui.BaseActivity
import com.army.ardiary.ui.main.diary.diarylist.DiaryListActivity
import com.army.ardiary.ui.main.map.MapActivity

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun initAfterBinding() {
        //TabLayoutMediator
        val my_btn: ImageButton = findViewById<ImageButton>(R.id.my_diary_btn)
        val map_btn: ImageView = findViewById<ImageView>(R.id.Button11)

        my_btn.setOnClickListener { startNextActivity(DiaryListActivity::class.java) }
        map_btn.setOnClickListener { startNextActivity(MapActivity::class.java) }
    }
}