package com.army.ardiary.ui.main.diary.timecasulelist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.army.ardiary.databinding.ItemTimeCapsuleListBinding
import com.army.ardiary.domain.model.TimeCapsuleItem
import com.army.ardiary.ui.main.diary.timecasulelist.adapter.viewholder.TimeCapsuleItemViewHolder

class TimeCapsuleListRVAdapter : ListAdapter<TimeCapsuleItem, RecyclerView.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TimeCapsuleItemViewHolder(
            ItemTimeCapsuleListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TimeCapsuleItemViewHolder -> holder.bind(currentList[position])
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<TimeCapsuleItem>() {
            override fun areItemsTheSame(
                oldItem: TimeCapsuleItem,
                newItem: TimeCapsuleItem
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: TimeCapsuleItem,
                newItem: TimeCapsuleItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}