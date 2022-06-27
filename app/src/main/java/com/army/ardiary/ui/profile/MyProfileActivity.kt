package com.army.ardiary.ui.profile

import android.content.Intent
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.army.ardiary.R
import com.army.ardiary.databinding.ActivityMyProfileBinding
import com.army.ardiary.ui.BaseActivity


class MyProfileActivity: BaseActivity<ActivityMyProfileBinding>(ActivityMyProfileBinding::inflate), View.OnClickListener {

    override fun initAfterBinding() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.profile_fragment_layout, MyProfileFragment())
            .commitAllowingStateLoss()
    }

    override fun onClick(v: View?) {}
}