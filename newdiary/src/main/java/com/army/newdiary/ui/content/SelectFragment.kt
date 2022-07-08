package com.army.newdiary.ui.content

import androidx.fragment.app.Fragment
import com.army.newdiary.R
import com.army.newdiary.databinding.FragmentSelectBinding
import com.army.newdiary.ui.BaseFragment
import com.army.newdiary.ui.content.diary.DiaryFragment
import com.army.newdiary.ui.content.guestbook.GuestBookFragment
import com.army.newdiary.ui.content.timecapsule.TimeCapsuleFragment
import com.google.android.material.tabs.TabLayout

class SelectFragment: BaseFragment<FragmentSelectBinding>(FragmentSelectBinding::inflate){

    override fun initAfterBinding() {
        buttonSetting()
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
}