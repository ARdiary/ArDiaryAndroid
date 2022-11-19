package com.army.ardiary.ui.profile.like

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.army.ardiary.databinding.FragmentGuestBookListBinding
import com.army.ardiary.domain.model.GuestBook
import com.army.ardiary.ui.BaseFragment
import com.army.ardiary.ui.profile.like.adapter.GuestBookRVAdapter
import com.army.ardiary.ui.profile.like.viewmodel.LikeGuestBookViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class GuestBookListFragment :
    BaseFragment<FragmentGuestBookListBinding>(FragmentGuestBookListBinding::inflate) {
    private var guestBookList = ArrayList<GuestBook>(5)
    private lateinit var guestBookRVAdapter: GuestBookRVAdapter

    private val viewModel by viewModels<LikeGuestBookViewModel>()

    override fun initAfterBinding() {
        networkSetting()
    }

    private fun networkSetting() {
        // following friend list load but first, put the dummies
        viewModel.likeGuestBook.onEach {
            guestBookList.addAll(it)
            guestBookRVAdapter = GuestBookRVAdapter(guestBookList).apply {
                onLikeClick = this@GuestBookListFragment::onLikeClick
            }
            binding.followingRv.adapter = guestBookRVAdapter
        }.launchIn(this.lifecycleScope)
    }

    private fun onLikeClick(idx: Int) {
        // remove friend
        guestBookList.removeAt(idx)
        guestBookRVAdapter.notifyItemRemoved(idx)
        // send remove friend info
    }
}