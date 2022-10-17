package com.army.ardiary.ui.main.notification

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.army.ardiary.databinding.ActivityNotificationBinding
import com.army.ardiary.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class NotificationActivity() :
    BaseActivity<ActivityNotificationBinding>(ActivityNotificationBinding::inflate) {

    private val viewModel by viewModels<NotificationViewModel>()

    override fun initAfterBinding() {
        initObserver()
    }

    private fun initObserver() {
        viewModel.notificationList.onEach {
            showToast(it.toString())
        }.launchIn(this.lifecycleScope)
    }
}