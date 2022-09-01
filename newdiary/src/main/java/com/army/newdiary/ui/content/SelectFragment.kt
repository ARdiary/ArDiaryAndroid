package com.army.newdiary.ui.content

import android.graphics.drawable.Drawable
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.army.newdiary.R
import com.army.newdiary.databinding.FragmentSelectBinding
import com.army.newdiary.ui.common.base.BaseFragment
import com.army.newdiary.ui.content.diary.DiaryFragment
import com.army.newdiary.ui.content.guestbook.GuestBookFragment
import com.army.newdiary.ui.content.timecapsule.TimeCapsuleFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SelectFragment : BaseFragment<FragmentSelectBinding>(FragmentSelectBinding::inflate) {

    override fun initAfterBinding() {
        buttonSetting()
        initMarkerImage()
        initTabLayout()
        initObserve()
    }

    private fun initObserve() {
        rootViewModel.currentMarker.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { binding.tabLayout.getTabAt(it)?.select() }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun initTabLayout() {
        rootViewModel.markerList.forEach {
            val newTab = binding.tabLayout.newTab().setIcon(it)
            binding.tabLayout.addTab(newTab)
        }
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.apply { rootViewModel.setMarker(position) }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun initMarkerImage() {
        val list = listOf<Drawable>(
            resources.getDrawable(R.drawable.img_sample_pin, null),
            resources.getDrawable(R.drawable.img_sample_star, null),
            resources.getDrawable(R.drawable.img_sample_gift, null),
            resources.getDrawable(R.drawable.img_sample_dragon, null),
        )

        rootViewModel.markerList = list
    }

    private fun buttonSetting() {
        binding.backBtn.setOnClickListener { parentActivity.finish() }

        binding.guestBook.setOnClickListener { changeFragment(GuestBookFragment()) }
        binding.diary.setOnClickListener { changeFragment(DiaryFragment()) }
        binding.timeCapsule.setOnClickListener { changeFragment(TimeCapsuleFragment()) }
    }
}