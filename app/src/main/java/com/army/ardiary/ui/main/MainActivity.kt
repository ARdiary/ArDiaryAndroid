package com.army.ardiary.ui.main

import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.army.ardiary.databinding.ActivityMainBinding
import com.army.ardiary.ui.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun initAfterBinding() {
        //TabLayoutMediator
        initAdapter()
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