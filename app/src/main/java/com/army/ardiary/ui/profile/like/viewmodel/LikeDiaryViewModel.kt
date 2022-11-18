package com.army.ardiary.ui.profile.like.viewmodel

import androidx.lifecycle.ViewModel
import com.army.ardiary.domain.usecase.diary.GetLikeDiaryListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LikeDiaryViewModel @Inject constructor(
    private val getLikeDiaryListUseCase: GetLikeDiaryListUseCase
) : ViewModel() {

}