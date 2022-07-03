package com.army.newdiary.ui.content.guestbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.army.newdiary.R
import com.army.newdiary.databinding.FragmentGuestBookBinding
import com.army.newdiary.ui.content.SelectFragment
import com.army.newdiary.ui.viewmodel.NewDiaryViewModel

class GuestBookFragment: Fragment() {
    lateinit var binding: FragmentGuestBookBinding
    lateinit var viewModel: NewDiaryViewModel

    lateinit var parentActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGuestBookBinding.inflate(layoutInflater)
        parentActivity = requireActivity()

        viewModel = ViewModelProvider(parentActivity)
            .get(NewDiaryViewModel::class.java)

        buttonSetting()

        return binding.root
    }

    private fun buttonSetting(){
        binding.backBtn.setOnClickListener { parentActivity.supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE) }
    }
}