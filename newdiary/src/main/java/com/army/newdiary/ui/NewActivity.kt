package com.army.newdiary.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.army.newdiary.R
import com.army.newdiary.databinding.ActivityNewBinding
import com.army.newdiary.ui.content.SelectFragment
import com.army.newdiary.ui.viewmodel.NewDiaryViewModel

class NewActivity : AppCompatActivity() {
    lateinit var newActivityBinding: ActivityNewBinding
    lateinit var viewModel: NewDiaryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newActivityBinding = ActivityNewBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(NewDiaryViewModel::class.java)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_layout, SelectFragment())
            .commitAllowingStateLoss()

        setContentView(newActivityBinding.root)
    }
}