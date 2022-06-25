package com.army.ardiary.data.local.dao

import androidx.room.*
import com.army.ardiary.data.local.entities.User

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM UserTable")
    fun getUsers(): List<User>

    @Query("SELECT * FROM UserTable WHERE id = :id")
    fun getUser(id: Int): User
}