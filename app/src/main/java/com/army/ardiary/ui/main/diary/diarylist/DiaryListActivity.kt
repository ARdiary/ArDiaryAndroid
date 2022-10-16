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
        binding.viewModel = viewModel
        initAdapter()
        initObserver()
        initButton()
        binding.lifecycleOwner = this
    }

    private fun initButton() {
        with(binding) {
            backBtn.setOnClickListener { finish() }
        }
    }

    private fun initObserver() {
        with(viewModel) {
            diaryList.flowWithLifecycle(lifecycle)
                .onEach {
                    diaryItemRVAdapter.submitList(it) {
                        showContent(binding.rvContent, binding.pbLoading, binding.evError)
                    }
                }.launchIn(lifecycleScope)
            layoutType.observe(this@DiaryListActivity) { diaryItemRVAdapter.setLayoutManager(it) }
        }
    }

    private fun initAdapter() {
        diaryItemRVAdapter = DiaryItemRVAdapter()
        binding.rvContent.adapter = diaryItemRVAdapter
    }

    companion object {
        const val LINEAR_VERTICAL = 0
        const val GRID_VERTICAL = 1
    }
}