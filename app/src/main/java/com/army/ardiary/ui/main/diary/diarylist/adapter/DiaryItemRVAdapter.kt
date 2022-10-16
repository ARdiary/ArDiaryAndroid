package com.army.ardiary.ui.main.diary.diarylist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.army.ardiary.databinding.ItemDiaryListBinding
import com.army.ardiary.domain.model.DiaryItem
import com.army.ardiary.ui.main.diary.diarylist.adapter.viewholder.DiaryListItemViewHolder

class DiaryItemRVAdapter : ListAdapter<DiaryItem, RecyclerView.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DiaryListItemViewHolder(
            ItemDiaryListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DiaryListItemViewHolder -> holder.bind(currentList[position])
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<DiaryItem>() {
            override fun areItemsTheSame(oldItem: DiaryItem, newItem: DiaryItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: DiaryItem, newItem: DiaryItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}