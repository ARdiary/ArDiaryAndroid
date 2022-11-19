package com.army.ardiary.data.remote.friend.datasource

import com.army.ardiary.data.remote.friend.dto.FriendDto

interface FriendDataSource {

    suspend fun getFollowingList(): List<FriendDto>
    suspend fun getFollowerList(): List<FriendDto>
}