package com.army.ardiary.ui.main.diary.diarylist.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.army.ardiary.databinding.ItemDiaryContentGridBinding
import com.army.ardiary.domain.model.DiaryContent

class DiaryContentGridViewHolder(private val binding: ItemDiaryContentGridBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(diaryContent: DiaryContent) {
        binding.diary = diaryContent
    }
}