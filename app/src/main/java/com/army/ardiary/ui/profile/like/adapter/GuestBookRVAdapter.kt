package com.army.ardiary.ui.profile.like.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.army.ardiary.data.remote.guestbook.vo.GuestBook
import com.army.ardiary.databinding.GuestBookListItemBinding
import com.army.ardiary.utils.visibleView
import com.bumptech.glide.Glide

class GuestBookRVAdapter(private val guestBookList :ArrayList<GuestBook>): RecyclerView.Adapter<GuestBookRVAdapter.ViewHolder>() {
    var onLikeClick:(Int) -> Unit = {}

    override fun getItemCount(): Int = guestBookList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
        = ViewHolder(GuestBookListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false), parent.context)

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.bind(guestBookList[position])
        holder.binding.likeIv.setOnClickListener { onLikeClick(position) }
    }

    inner class ViewHolder(val binding: GuestBookListItemBinding, val context: Context): RecyclerView.ViewHolder(binding.root){
        fun bind(guestBook: GuestBook){
            Glide.with(context)
                .load(guestBook.imagePath)
                .into(binding.diaryMapIv)

            binding.guestBookTitleTv.text = guestBook.title
            binding.diaryUserNameTv.text = guestBook.name
            binding.createDateTv.text = guestBook.date
            binding.diaryDescriptionTv.text = guestBook.description

            binding.likeIv.visibility = visibleView(guestBook.isLike)
            binding.unlikeIv.visibility = visibleView(guestBook.isLike.not())
        }
    }
}