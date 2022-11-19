package com.army.ardiary.data.remote.friend.datasource

import com.army.ardiary.data.remote.friend.dto.FriendDto
import com.army.ardiary.data.remote.friend.service.FriendService
import javax.inject.Inject

class FriendDataSourceImpl @Inject constructor(
    private val service: FriendService
) : FriendDataSource {

    override suspend fun getFollowingList(): List<FriendDto> = service.getFollowingList()

    override suspend fun getFollowerList(): List<FriendDto> = service.getFollowerList()
}