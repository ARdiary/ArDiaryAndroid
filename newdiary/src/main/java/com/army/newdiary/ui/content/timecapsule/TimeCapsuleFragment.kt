package com.army.newdiary.ui.content.timecapsule

import com.army.newdiary.databinding.FragmentTimeCapsuleBinding
import com.army.newdiary.ui.BaseFragment

class TimeCapsuleFragment : BaseFragment<FragmentTimeCapsuleBinding>(FragmentTimeCapsuleBinding::inflate){
    override fun initAfterBinding() {
        buttonSetting()
    }

    private fun buttonSetting(){
        binding.backBtn.setOnClickListener { removeTopFragment() }
    }
}