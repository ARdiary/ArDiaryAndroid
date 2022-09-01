package com.army.newdiary.ui.content.guestbook

import com.army.newdiary.databinding.FragmentGuestBookBinding
import com.army.newdiary.ui.common.base.BaseFragment

class GuestBookFragment : BaseFragment<FragmentGuestBookBinding>(FragmentGuestBookBinding::inflate){
    override fun initAfterBinding() {
        buttonSetting()
    }

    private fun buttonSetting(){
        binding.backBtn.setOnClickListener { removeTopFragment() }
    }
}