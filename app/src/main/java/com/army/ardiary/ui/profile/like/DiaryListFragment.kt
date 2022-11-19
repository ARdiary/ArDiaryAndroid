package com.army.ardiary.ui.profile.like

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.army.ardiary.databinding.FragmentDiaryListBinding
import com.army.ardiary.domain.model.DiaryContent
import com.army.ardiary.ui.BaseFragment
import com.army.ardiary.ui.profile.like.adapter.DiaryRVAdapter
import com.army.ardiary.ui.profile.like.viewmodel.LikeDiaryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class DiaryListFragment :
    BaseFragment<FragmentDiaryListBinding>(FragmentDiaryListBinding::inflate) {
    private var diaryList = ArrayList<DiaryContent>(5)
    private lateinit var diaryRVAdapter: DiaryRVAdapter

    private val viewModel by viewModels<LikeDiaryViewModel>()

    override fun initAfterBinding() {
        binding.followingRv.layoutManager = GridLayoutManager(this.requireContext(), 2)
        networkSetting()
    }

    private fun networkSetting() {
        // following friend list load but first, put the dummies
        viewModel.likeDiaryList.onEach {
            diaryList.addAll(it)
            diaryRVAdapter =
                DiaryRVAdapter(diaryList).apply {
                    onLikeClick = this@DiaryListFragment::onLikeClick
                }
            binding.followingRv.adapter = diaryRVAdapter
        }.launchIn(this.lifecycleScope)
    }

    private fun onLikeClick(idx: Int) {
        // remove friend
        diaryList.removeAt(idx)
        diaryRVAdapter.notifyItemRemoved(idx)
        // send remove friend info
    }
}