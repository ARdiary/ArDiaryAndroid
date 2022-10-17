package com.army.ardiary.ui.main.notification

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.army.ardiary.databinding.ActivityNotificationBinding
import com.army.ardiary.ui.BaseActivity
import com.army.ardiary.ui.common.viewutils.showContent
import com.army.ardiary.ui.main.notification.adapter.NotificationRVAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class NotificationActivity() :
    BaseActivity<ActivityNotificationBinding>(ActivityNotificationBinding::inflate) {

    private val viewModel by viewModels<NotificationViewModel>()
    private lateinit var notificationRVAdapter: NotificationRVAdapter

    override fun initAfterBinding() {
        initAdapter()
        initObserver()
        initButton()
    }

    private fun initButton() {
        binding.btnBack.setOnClickListener { finish() }
    }

    private fun initAdapter() {
        notificationRVAdapter = NotificationRVAdapter()
        binding.rvNotCheck.adapter = notificationRVAdapter
    }

    private fun initObserver() {
        viewModel.notificationList.onEach {
            notificationRVAdapter.submitList(it) {
                with(binding) { showContent(llContent, pbLoading, evError) }
            }
        }.launchIn(this.lifecycleScope)
    }
}