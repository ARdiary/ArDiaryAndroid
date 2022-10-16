package com.army.ardiary.ui.main.diary.diarylist.adapter.viewholder

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.army.ardiary.databinding.ItemDiaryListBinding
import com.army.ardiary.domain.model.DiaryItem
import com.army.ardiary.ui.main.diary.diarylist.DiaryListActivity.Companion.LINEAR_VERTICAL
import com.army.ardiary.ui.main.diary.diarylist.adapter.DiaryListRVAdapter

class DiaryListItemViewHolder(private val binding: ItemDiaryListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private val diaryListRVAdapter = DiaryListRVAdapter()

    fun bind(diaryItem: DiaryItem, type: Int) {

        binding.diary = diaryItem
        binding.rvDiaryContent.adapter = diaryListRVAdapter
        diaryListRVAdapter.submitList(diaryItem.diaryContent)
        setLayoutManagerType(type)
    }

    private fun setLayoutManagerType(type: Int) {
        diaryListRVAdapter.managerType = type
        binding.rvDiaryContent.apply {
            layoutManager = if (type == LINEAR_VERTICAL) LinearLayoutManager(
                this.context,
                LinearLayoutManager.VERTICAL,
                false
            )
            else GridLayoutManager(this.context, 2)
        }
    }
}