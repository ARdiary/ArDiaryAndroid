package com.army.ardiary.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.army.ardiary.ApplicationClass.Companion.APP_DATABASE
import com.army.ardiary.data.local.dao.UserDao
import com.army.ardiary.data.local.entities.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        APP_DATABASE
                    ).allowMainThreadQueries().build()
                }
            }

            return instance
        }
    }
}