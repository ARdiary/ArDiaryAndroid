
package com.army.ardiary.ui.profile.like

import androidx.recyclerview.widget.GridLayoutManager
import com.army.ardiary.data.remote.guestbook.vo.GuestBook
import com.army.ardiary.databinding.FragmentGuestBookListBinding
import com.army.ardiary.ui.BaseFragment
import com.army.ardiary.ui.profile.like.adapter.GuestBookRVAdapter

class GuestBookListFragment : BaseFragment<FragmentGuestBookListBinding>(FragmentGuestBookListBinding::inflate) {
    private val guestBookList = ArrayList<GuestBook>(5)
    private lateinit var guestBookRVAdapter: GuestBookRVAdapter

    override fun initAfterBinding() {
        binding.followingRv.layoutManager = GridLayoutManager(this.requireContext(), 2)
        networkSetting()
    }
    private fun networkSetting(){
        // following friend list load but first, put the dummies
        guestBookList.add(GuestBook("https://dictionary.cambridge.org/ko/images/thumb/dog_noun_001_04904.jpg?version=5.0.244","test1", "testing", "2022-02-22","test",true))
        guestBookList.add(GuestBook("https://www.collinsdictionary.com/images/full/dog_230497594.jpg","test2", "testing", "2022-02-22","test",true))
        guestBookList.add(GuestBook("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=1.00xw:0.669xh;0,0.190xh&resize=1200:*","test3","testing", "2022-02-22","test",true))
        guestBookList.add(GuestBook("https://images.immediate.co.uk/production/volatile/sites/4/2022/06/Dog-love-hero-87954c7.jpg?quality=90&resize=940,400","test4","testing", "2022-02-22","test",true))
        guestBookList.add(GuestBook("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHfSLr7bMI_19SlJ7v4kfRWAybmJjexTCcyw&usqp=CAU","test5","testing", "2022-02-22","test",true))

        guestBookRVAdapter = GuestBookRVAdapter(guestBookList).apply { onLikeClick = this@GuestBookListFragment::onLikeClick }
        binding.followingRv.adapter = guestBookRVAdapter
    }
    private fun onLikeClick(idx: Int){
        // remove friend
        guestBookList.removeAt(idx)
        guestBookRVAdapter.notifyItemRemoved(idx)
        // send remove friend info
    }
}