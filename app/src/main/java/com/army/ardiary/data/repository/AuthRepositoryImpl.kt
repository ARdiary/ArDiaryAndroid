package com.army.ardiary.data.repository

import com.army.ardiary.data.remote.auth.AuthNetworkDataSource
import com.army.ardiary.data.remote.auth.dto.toUserDto
import com.army.ardiary.domain.model.Auth
import com.army.ardiary.domain.model.User
import com.army.ardiary.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authNetworkDataSource: AuthNetworkDataSource
) : AuthRepository {

    override suspend fun login(user: User): Result<Auth> =
        runCatching { authNetworkDataSource.login(user.toUserDto()).toAuth() }

    override suspend fun signUp(user: User): Result<Auth> =
        runCatching { authNetworkDataSource.signUp(user.toUserDto()).toAuth() }
}