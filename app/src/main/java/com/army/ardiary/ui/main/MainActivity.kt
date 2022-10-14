package com.army.ardiary.ui.main

import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.army.ardiary.databinding.ActivityMainBinding
import com.army.ardiary.ui.BaseActivity
import com.army.ardiary.ui.main.diary.diarylist.DiaryListActivity
import com.army.ardiary.ui.main.diary.timecasulelist.TimeCapsuleListActivity
import com.army.ardiary.ui.main.map.MapActivity
import com.army.ardiary.ui.main.notification.NotificationActivity
import com.army.ardiary.ui.profile.MyProfileActivity

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun initAfterBinding() {
        //TabLayoutMediator
        initAdapter()
        initDrawer()
        initButton()
    }

    private fun initButton() {
        with(binding) {
            btnNotification.setOnClickListener { startNextActivity(NotificationActivity::class.java) }
            btnCamera.setOnClickListener { startNextActivity(MapActivity::class.java) }
        }
    }

    private fun initDrawer() {
        with(binding) {
            btnSideMenu.setOnClickListener { if (!drawerLayout.isOpen) drawerLayout.open() }
        }
        with(binding.drawer) {
            rlProfile.setOnClickListener { startNextActivity(MyProfileActivity::class.java) }
            btnDiary.setOnClickListener { startNextActivity(DiaryListActivity::class.java) }
            btnNotice.setOnClickListener { showToast("공지사항!") }
            btnSettings.setOnClickListener { showToast("설정!") }
            btnTimeCapsule.setOnClickListener { startNextActivity(TimeCapsuleListActivity::class.java) }
        }
    }

    private fun initAdapter() {
        val adapter = MainVPAdapter(supportFragmentManager, this.lifecycle)

        binding.vpContent.adapter = adapter
        binding.vpContent.offscreenPageLimit = adapter.itemCount
        binding.vpContent.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 0) showAppName()
                else hideAppName()
            }
        })
    }

    private fun showAppName() {
        binding.tvAppName.isVisible = true
        binding.btnSearch.isGone = true
        binding.btnCamera.isVisible = true
    }

    private fun hideAppName() {
        binding.tvAppName.isGone = true
        binding.btnSearch.isVisible = true
        binding.btnCamera.isGone = true
    }
}