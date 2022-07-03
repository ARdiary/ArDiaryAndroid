package com.army.newdiary.ui.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.army.newdiary.R
import com.army.newdiary.databinding.FragmentSelectBinding
import com.army.newdiary.ui.NewActivity
import com.army.newdiary.ui.content.diary.DiaryFragment
import com.army.newdiary.ui.content.guestbook.GuestBookFragment
import com.army.newdiary.ui.content.timecapsule.TimeCapsuleFragment
import com.army.newdiary.ui.viewmodel.NewDiaryViewModel
import com.google.android.material.tabs.TabLayout

class SelectFragment : Fragment() {
    lateinit var binding: FragmentSelectBinding
    lateinit var viewModel: NewDiaryViewModel

    lateinit var parentActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectBinding.inflate(layoutInflater)
        parentActivity = requireActivity()
        viewModel = ViewModelProvider(parentActivity)
            .get(NewDiaryViewModel::class.java)

        buttonSetting()

        return binding.root
    }
    private fun buttonSetting(){
        binding.backBtn.setOnClickListener { parentActivity.finish() }

        binding.guestBook.setOnClickListener { changeFragment(GuestBookFragment()) }
        binding.diary.setOnClickListener { changeFragment(DiaryFragment()) }
        binding.timeCapsule.setOnClickListener { changeFragment(TimeCapsuleFragment()) }

        binding.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            // ViewModel update
            override fun onTabSelected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun changeFragment(fragment: Fragment): Int
        = parentActivity
            .supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_layout, fragment)
            .addToBackStack(null)
            .commitAllowingStateLoss()
}