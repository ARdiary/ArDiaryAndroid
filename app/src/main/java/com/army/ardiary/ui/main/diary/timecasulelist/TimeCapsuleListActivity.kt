package com.army.ardiary.ui.main.diary.timecasulelist

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.army.ardiary.databinding.ActivityTimeCapsuleListBinding
import com.army.ardiary.ui.BaseActivity
import com.army.ardiary.ui.common.viewutils.showContent
import com.army.ardiary.ui.main.diary.timecasulelist.adapter.TimeCapsuleListRVAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class TimeCapsuleListActivity :
    BaseActivity<ActivityTimeCapsuleListBinding>(ActivityTimeCapsuleListBinding::inflate) {

    private val viewModel by viewModels<TimeCapsuleListViewModel>()
    private lateinit var timeCapsuleListRVAdapter: TimeCapsuleListRVAdapter

    override fun initAfterBinding() {
        initAdapter()
        initButton()
        initObserver()
    }

    private fun initAdapter() {
        timeCapsuleListRVAdapter = TimeCapsuleListRVAdapter()
        binding.rvContent.adapter = timeCapsuleListRVAdapter
    }

    private fun initObserver() {
        viewModel.timeCapsuleList.onEach {
            timeCapsuleListRVAdapter.submitList(it) {
                with(binding) { showContent(rvContent, pbLoading, evError) }
            }
        }.launchIn(this.lifecycleScope)
    }

    private fun initButton() {
        binding.backBtn.setOnClickListener { finish() }
    }
}