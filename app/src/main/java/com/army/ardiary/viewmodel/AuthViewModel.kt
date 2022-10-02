package com.army.ardiary.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.army.ardiary.domain.model.User
import com.army.ardiary.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    fun login(email: String) {
        viewModelScope.launch {
            val user = User(email)
            authRepository.login(user)
                .onSuccess { Log.d("Tester", "login success: $it") }
                .onFailure { signUp(user) }
        }
    }

    private fun signUp(user: User) {
        viewModelScope.launch {
            authRepository.signUp(user = user)
                .onSuccess { Log.d("Tester", "signUp success: $it") }
                .onFailure { Log.d("Tester", "signUp fail: $it") }
        }
    }
}