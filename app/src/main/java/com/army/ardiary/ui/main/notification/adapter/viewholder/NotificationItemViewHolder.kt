package com.army.ardiary.ui.main.notification.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.army.ardiary.databinding.ItemNotificationListBinding
import com.army.ardiary.domain.model.Notification

class NotificationItemViewHolder(private val binding: ItemNotificationListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(notification: Notification) {
        binding.notification = notification
    }
}