package com.army.ardiary.ui.main.diary.diarylist

import androidx.fragment.app.FragmentTransaction
import com.army.ardiary.R
import com.army.ardiary.databinding.ActivityDiaryListBinding
import com.army.ardiary.ui.BaseActivity

class DiaryListActivity2 :
    BaseActivity<ActivityDiaryListBinding>(ActivityDiaryListBinding::inflate) {

    var isBtn = 1 //frag1이면 1, frag2면 2를 통해 버튼 전환

    override fun initAfterBinding() {
        // 먼저 첫 탭 보여주기 (default)
        showTabOne()

        // 버튼 클릭 시 탭2 내용 띄우기
        binding.btnSwitch.setOnClickListener {
            if (isBtn == 1) { //frag1인 상태면 two를 불러오기
                showTabTwo()
            } else { //frag2인 상태면 one를 불러오기
                showTabOne()
            }
        }
    }

    // 함수 작성
    private fun showTabOne() {
        isBtn = 1
        //버튼 모양 background로 변경
        binding.btnSwitch.setImageDrawable(getDrawable(R.drawable.ic_launcher_background))

        //supportFragmentManager.beginTransaction() 이용해서 frameLayout이라는 것을 ListDefaultFragment() class로 변경
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, ListDefaultFragment())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

    }

    private fun showTabTwo() {
        isBtn = 2 //two가 불러와졌으면 isBtn은 2

        //foreground 모양으로 btnSwitch라는 버튼의 모양 바꾸기
        binding.btnSwitch.setImageDrawable(getDrawable(R.drawable.ic_launcher_foreground))

        //supportFragmentManager.beginTransaction() 이용해서 frameLayout이라는 것을 ListImageFragment() class로 변경
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, ListImageFragment())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }
}