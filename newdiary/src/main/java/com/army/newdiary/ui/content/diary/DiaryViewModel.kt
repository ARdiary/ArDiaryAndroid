package com.army.newdiary.ui.content.diary

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class DiaryViewModel : ViewModel() {

    val titleText = MutableStateFlow("")
    val contentText = MutableStateFlow("")

}