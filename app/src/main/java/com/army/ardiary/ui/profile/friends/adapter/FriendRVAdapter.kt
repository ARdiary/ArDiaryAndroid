package com.army.ardiary.ui.profile.friends.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.army.ardiary.data.remote.friend.vo.Friend
import com.army.ardiary.databinding.FriendListItemBinding
import com.army.ardiary.utils.visibleView
import com.bumptech.glide.Glide

class FriendRVAdapter(private val friendList: ArrayList<Friend>) :
    RecyclerView.Adapter<FriendRVAdapter.ViewHolder>() {
    var onRemoveClick: (Int) -> Unit = {}

    override fun getItemCount(): Int = friendList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        FriendListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ), parent.context
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(friendList[position])
        holder.binding.deleteBtn.setOnClickListener { onRemoveClick(position) }
    }

    inner class ViewHolder(val binding: FriendListItemBinding, val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(friend: Friend) {
            binding.nameTv.text = friend.name
            Glide.with(context)
                .load(friend.profileImagePath)
                .into(binding.profileImageIv)
            binding.deleteBtn.visibility = visibleView(friend.editable)
        }
    }
}