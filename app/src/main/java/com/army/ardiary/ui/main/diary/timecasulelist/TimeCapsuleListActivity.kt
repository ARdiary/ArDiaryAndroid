package com.army.ardiary.ui.main.diary.timecasulelist

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.army.ardiary.databinding.ActivityTimeCapsuleListBinding
import com.army.ardiary.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class TimeCapsuleListActivity :
    BaseActivity<ActivityTimeCapsuleListBinding>(ActivityTimeCapsuleListBinding::inflate) {

    val viewModel by viewModels<TimeCapsuleListViewModel>()

    override fun initAfterBinding() {
        initButton()
        initObserver()
    }

    private fun initObserver() {
        viewModel.timeCapsuleList.onEach { }.launchIn(this.lifecycleScope)
    }

    private fun initButton() {
        binding.backBtn.setOnClickListener { finish() }
    }
}