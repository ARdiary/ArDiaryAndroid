package com.army.ardiary.ui.main.diary.diarylist

import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.army.ardiary.databinding.ActivityDiaryListBinding
import com.army.ardiary.ui.BaseActivity
import com.army.ardiary.ui.common.viewutils.showContent
import com.army.ardiary.ui.main.diary.diarylist.adapter.DiaryItemRVAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class DiaryListActivity :
    BaseActivity<ActivityDiaryListBinding>(ActivityDiaryListBinding::inflate) {

    private lateinit var diaryItemRVAdapter: DiaryItemRVAdapter
    private val viewModel by viewModels<DiaryListViewModel>()

    override fun initAfterBinding() {
        initAdapter()
        initObserver()
    }

    private fun initObserver() {
        viewModel.diaryList.flowWithLifecycle(this.lifecycle)
            .onEach {
                diaryItemRVAdapter.submitList(it) {
                    showContent(binding.rvContent, binding.pbLoading, binding.evError)
                }
            }.launchIn(lifecycleScope)
    }

    private fun initAdapter() {
        diaryItemRVAdapter = DiaryItemRVAdapter()
        binding.rvContent.adapter = diaryItemRVAdapter
    }

    companion object {
        val LINEAR_VERTICAL = 0
        val GRID_VERTICAL = 0
    }
}