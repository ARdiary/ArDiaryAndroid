
package com.army.ardiary.ui.profile.friends

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.army.ardiary.data.remote.friend.vo.Friend
import com.army.ardiary.databinding.FragmentFollwingBinding
import com.army.ardiary.ui.BaseFragment
import com.army.ardiary.ui.profile.friends.adapter.FriendRVAdapter
import com.army.ardiary.ui.profile.friends.viewmodel.FriendViewModel
import com.army.ardiary.utils.visibleView

class FollowingFragment : BaseFragment<FragmentFollwingBinding>(FragmentFollwingBinding::inflate) {
    private val friendList = ArrayList<Friend>(5)
    private lateinit var friendRVAdapter: FriendRVAdapter
    private lateinit var friendViewModel: FriendViewModel

    override fun initAfterBinding() {
        networkSetting()
        buttonSetting()
        viewModelSetting()
    }

    private fun networkSetting(){
        // following friend list load but first, put the dummies
        friendList.add(Friend("https://dictionary.cambridge.org/ko/images/thumb/dog_noun_001_04904.jpg?version=5.0.244","test1"))
        friendList.add(Friend("https://www.collinsdictionary.com/images/full/dog_230497594.jpg","test2"))
        friendList.add(Friend("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=1.00xw:0.669xh;0,0.190xh&resize=1200:*","test3"))
        friendList.add(Friend("https://images.immediate.co.uk/production/volatile/sites/4/2022/06/Dog-love-hero-87954c7.jpg?quality=90&resize=940,400","test4"))
        friendList.add(Friend("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHfSLr7bMI_19SlJ7v4kfRWAybmJjexTCcyw&usqp=CAU","test5"))

        friendRVAdapter = FriendRVAdapter(friendList).apply { onRemoveClick = this@FollowingFragment::friendRemove }
        binding.followingRv.adapter = friendRVAdapter
    }
    private fun buttonSetting(){
        binding.editFollowingBtn.setOnClickListener { friendViewModel.editable.postValue(!friendViewModel.editable.value!!) }
    }
    private fun viewModelSetting(){
        friendViewModel = ViewModelProvider(this)
            .get(FriendViewModel::class.java)

        friendViewModel.editable.observe(this, Observer {
            val flag = it
            binding.editFollowingBtn.visibility = visibleView(flag)
            friendList.forEach { it.editable = flag }
            friendRVAdapter.notifyDataSetChanged()
        })
    }

    private fun friendRemove(idx: Int){
        // remove friend
        friendList.removeAt(idx)
        friendRVAdapter.notifyItemRemoved(idx)
        // send remove friend info
    }
}