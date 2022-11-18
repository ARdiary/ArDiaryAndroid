package com.army.ardiary.ui.profile.like

import androidx.recyclerview.widget.GridLayoutManager
import com.army.ardiary.databinding.FragmentDiaryListBinding
import com.army.ardiary.domain.model.DiaryTemp
import com.army.ardiary.ui.BaseFragment
import com.army.ardiary.ui.profile.like.adapter.DiaryRVAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiaryListFragment :
    BaseFragment<FragmentDiaryListBinding>(FragmentDiaryListBinding::inflate) {
    private val diaryList = ArrayList<DiaryTemp>(5)
    private lateinit var diaryRVAdapter: DiaryRVAdapter

    override fun initAfterBinding() {
        binding.followingRv.layoutManager = GridLayoutManager(this.requireContext(), 2)
        networkSetting()
    }

    private fun networkSetting() {
        // following friend list load but first, put the dummies
        diaryList.add(
            DiaryTemp(
                "https://dictionary.cambridge.org/ko/images/thumb/dog_noun_001_04904.jpg?version=5.0.244",
                "test1",
                "testing",
                true
            )
        )
        diaryList.add(
            DiaryTemp(
                "https://www.collinsdictionary.com/images/full/dog_230497594.jpg",
                "test2",
                "testing",
                true
            )
        )
        diaryList.add(
            DiaryTemp(
                "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=1.00xw:0.669xh;0,0.190xh&resize=1200:*",
                "test3",
                "testing",
                true
            )
        )
        diaryList.add(
            DiaryTemp(
                "https://images.immediate.co.uk/production/volatile/sites/4/2022/06/Dog-love-hero-87954c7.jpg?quality=90&resize=940,400",
                "test4",
                "testing",
                true
            )
        )
        diaryList.add(
            DiaryTemp(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHfSLr7bMI_19SlJ7v4kfRWAybmJjexTCcyw&usqp=CAU",
                "test5",
                "testing",
                true
            )
        )

        diaryRVAdapter =
            DiaryRVAdapter(diaryList).apply { onLikeClick = this@DiaryListFragment::onLikeClick }
        binding.followingRv.adapter = diaryRVAdapter
    }

    private fun onLikeClick(idx: Int) {
        // remove friend
        diaryList.removeAt(idx)
        diaryRVAdapter.notifyItemRemoved(idx)
        // send remove friend info
    }
}