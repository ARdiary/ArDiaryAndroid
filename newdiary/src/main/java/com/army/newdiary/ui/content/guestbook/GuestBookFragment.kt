package com.army.newdiary.ui.content.guestbook

import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.army.newdiary.databinding.FragmentGuestBookBinding
import com.army.newdiary.ui.common.base.BaseFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class GuestBookFragment :
    BaseFragment<FragmentGuestBookBinding>(FragmentGuestBookBinding::inflate) {

    override fun initAfterBinding() {
        buttonSetting()
        initObserve()
    }

    private fun initObserve() {
        rootViewModel.currentMarker.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { binding.previewMarkerLayout.setMarkerImage(rootViewModel.getCurrentMarker()) }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun buttonSetting() {
        binding.backBtn.setOnClickListener { removeTopFragment() }
    }
}