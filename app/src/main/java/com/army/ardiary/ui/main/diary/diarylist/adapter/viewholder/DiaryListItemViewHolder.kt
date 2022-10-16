package com.army.ardiary.ui.main.diary.diarylist.adapter.viewholder

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.army.ardiary.databinding.ItemDiaryListBinding
import com.army.ardiary.domain.model.DiaryItem

class DiaryListItemViewHolder(private val binding: ItemDiaryListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private var layoutManager = LinearLayoutManager.VERTICAL

    fun bind(diaryItem: DiaryItem) {

    }
}