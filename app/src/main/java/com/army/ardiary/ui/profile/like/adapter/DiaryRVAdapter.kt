package com.army.ardiary.ui.profile.like.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.army.ardiary.databinding.DiaryListItemBinding
import com.army.ardiary.domain.model.DiaryContent
import com.army.ardiary.utils.visibleView
import com.bumptech.glide.Glide

class DiaryRVAdapter(private val diaryList: List<DiaryContent>) :
    RecyclerView.Adapter<DiaryRVAdapter.ViewHolder>() {
    var onLikeClick: (Int) -> Unit = {}

    override fun getItemCount(): Int = diaryList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        DiaryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        parent.context
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(diaryList[position])
        holder.binding.likeIv.setOnClickListener { onLikeClick(position) }
    }

    inner class ViewHolder(val binding: DiaryListItemBinding, val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(diary: DiaryContent) {
            binding.diaryUserNameTv.text = diary.title
            Glide.with(context)
                .load(diary.thumbnailUrl)
                .into(binding.diaryMapIv)
            binding.likeIv.visibility = visibleView(diary.isLike)
            binding.unlikeIv.visibility = visibleView(diary.isLike.not())
        }
    }
}