package com.army.newdiary.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.army.newdiary.R
import com.army.newdiary.databinding.ActivityNewBinding
import com.army.newdiary.ui.content.SelectFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewActivity : AppCompatActivity() {
    lateinit var newActivityBinding: ActivityNewBinding
    private val viewModel: NewDiaryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newActivityBinding = ActivityNewBinding.inflate(layoutInflater)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_layout, SelectFragment())
            .commitAllowingStateLoss()

        setContentView(newActivityBinding.root)
    }
}