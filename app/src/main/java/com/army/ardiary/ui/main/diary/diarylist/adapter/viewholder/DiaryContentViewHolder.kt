package com.army.ardiary.ui.main.diary.diarylist.adapter.viewholder

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.army.ardiary.databinding.ItemDiaryContentBinding
import com.army.ardiary.domain.model.DiaryContent

class DiaryContentViewHolder(private val binding: ItemDiaryContentBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private var layoutManager = LinearLayoutManager.VERTICAL

    fun bind(diaryItem: DiaryContent) {

    }
}