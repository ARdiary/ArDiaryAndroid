package com.army.ardiary.data.remote.friend.service

import com.army.ardiary.data.remote.friend.dto.FriendDto
import retrofit2.http.GET

interface FriendService {

    @GET("api/diaries")
    suspend fun getFollowerList(): List<FriendDto>

    @GET("api/diaries")
    suspend fun getFollowingList(): List<FriendDto>
}