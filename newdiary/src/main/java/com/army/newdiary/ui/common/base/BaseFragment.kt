package com.army.newdiary.ui.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.viewbinding.ViewBinding
import com.army.newdiary.R
import com.army.newdiary.ui.NewDiaryViewModel
import com.army.newdiary.utils.Inflate

abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {
    private var _binding: VB? = null
    protected val binding get() = _binding!!

    val rootViewModel: NewDiaryViewModel by activityViewModels()
    lateinit var parentActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        parentActivity = requireActivity()

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initAfterBinding()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected abstract fun initAfterBinding()

    fun showToast(message: String) = Toast.makeText(parentActivity, message, Toast.LENGTH_SHORT)
        .show()

    fun changeFragment(fragment: Fragment) = parentFragmentManager
        .beginTransaction()
        .replace(R.id.fragment_layout, fragment)
        .addToBackStack(null)
        .commitAllowingStateLoss()

    fun removeTopFragment() = parentActivity
        .supportFragmentManager
        .popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
}