package com.army.newdiary.ui

import android.graphics.drawable.Drawable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class NewDiaryViewModel : ViewModel() {
    var markerList = emptyList<Drawable>()
    var currentMarker = MutableStateFlow(0)

    fun setMarker(position: Int) {
        viewModelScope.launch { currentMarker.emit(position) }
    }

    fun getMarker(position: Int): Drawable = markerList[position]
    fun getCurrentMarker(): Drawable = getMarker(currentMarker.value)
}