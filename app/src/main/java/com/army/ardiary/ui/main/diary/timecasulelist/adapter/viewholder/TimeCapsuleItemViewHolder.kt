package com.army.ardiary.ui.main.diary.timecasulelist.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.army.ardiary.databinding.ItemTimeCapsuleListBinding
import com.army.ardiary.domain.model.TimeCapsuleItem

class TimeCapsuleItemViewHolder(private val binding: ItemTimeCapsuleListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(timeCapsuleItem: TimeCapsuleItem, onClick: (TimeCapsuleItem) -> Unit) {
        binding.clItem.setOnClickListener { onClick(timeCapsuleItem) }
        binding.timecapsule = timeCapsuleItem
    }
}