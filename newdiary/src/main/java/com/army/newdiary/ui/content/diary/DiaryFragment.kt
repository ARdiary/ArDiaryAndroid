package com.army.newdiary.ui.content.diary

import com.army.newdiary.databinding.FragmentDiaryBinding
import com.army.newdiary.ui.BaseFragment

class DiaryFragment : BaseFragment<FragmentDiaryBinding>(FragmentDiaryBinding::inflate){
    override fun initAfterBinding() {
        buttonSetting()
    }

    private fun buttonSetting(){
        binding.backBtn.setOnClickListener { removeTopFragment() }
    }
}