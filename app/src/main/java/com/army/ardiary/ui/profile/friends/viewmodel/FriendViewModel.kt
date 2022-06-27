package com.army.ardiary.ui.profile.friends.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FriendViewModel: ViewModel() {
    var editable = MutableLiveData<Boolean>(false)
}