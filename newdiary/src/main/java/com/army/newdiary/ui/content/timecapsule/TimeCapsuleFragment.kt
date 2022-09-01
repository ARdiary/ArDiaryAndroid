package com.army.newdiary.ui.content.timecapsule

import android.app.DatePickerDialog
import android.os.Build
import androidx.fragment.app.viewModels
import com.army.newdiary.R
import com.army.newdiary.databinding.FragmentTimeCapsuleBinding
import com.army.newdiary.ui.common.base.BaseFragment

class TimeCapsuleFragment :
    BaseFragment<FragmentTimeCapsuleBinding>(FragmentTimeCapsuleBinding::inflate) {

    private val timeCapsuleViewModel: TimeCapsuleViewModel by viewModels()

    override fun initAfterBinding() {
        binding.timeCapsuleVm = timeCapsuleViewModel
        binding.lifecycleOwner = this.viewLifecycleOwner
        buttonSetting()
        initObserve()
    }

    private fun initObserve() {
        timeCapsuleViewModel.dDayFlag.observe(this) {
            if (it && Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val dialog = DatePickerDialog(
                    this.requireContext(),
                    null,
                    timeCapsuleViewModel.dDay.value!!.year,
                    timeCapsuleViewModel.dDay.value!!.month,
                    timeCapsuleViewModel.dDay.value!!.date,
                )
                dialog.setOnDateSetListener { _, y, m, d ->
                    if (!timeCapsuleViewModel.setDday(y, m, d))
                        showToast(getString(R.string.set_dday_error))
                }
                dialog.show()
            }
        }
    }

    private fun buttonSetting() {
        binding.backBtn.setOnClickListener { removeTopFragment() }
    }
}