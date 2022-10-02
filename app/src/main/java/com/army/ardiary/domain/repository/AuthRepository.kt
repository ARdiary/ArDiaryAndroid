package com.army.ardiary.domain.repository

import com.army.ardiary.domain.model.Auth
import com.army.ardiary.domain.model.User

interface AuthRepository {

    suspend fun login(user: User): Result<Auth>

    suspend fun signUp(user: User): Result<Auth>
}