package com.army.ardiary.ui.main.diary.diarylist

import com.army.ardiary.databinding.FragmentListDefaultBinding
import com.army.ardiary.ui.BaseFragment

class ListDefaultFragment : BaseFragment<FragmentListDefaultBinding>(FragmentListDefaultBinding::inflate) {

    override fun initAfterBinding() {
        binding.DateAndDay.text = "창덕궁"
    }
}