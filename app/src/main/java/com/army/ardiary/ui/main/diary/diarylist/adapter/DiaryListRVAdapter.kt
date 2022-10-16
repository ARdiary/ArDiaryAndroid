package com.army.ardiary.ui.main.diary.diarylist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.army.ardiary.databinding.ItemDiaryListBinding
import com.army.ardiary.domain.model.DiaryContent
import com.army.ardiary.domain.model.DiaryItem
import com.army.ardiary.ui.main.diary.diarylist.adapter.viewholder.DiaryContentViewHolder
import com.army.ardiary.ui.main.diary.diarylist.adapter.viewholder.DiaryListItemViewHolder

class DiaryListRVAdapter : ListAdapter<DiaryContent, RecyclerView.ViewHolder>(diffUtil) {

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
            is DiaryContentViewHolder -> holder.bind(currentList[position])
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<DiaryContent>() {
            override fun areItemsTheSame(oldItem: DiaryContent, newItem: DiaryContent): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: DiaryContent, newItem: DiaryContent): Boolean {
                return oldItem == newItem
            }
        }
    }
}