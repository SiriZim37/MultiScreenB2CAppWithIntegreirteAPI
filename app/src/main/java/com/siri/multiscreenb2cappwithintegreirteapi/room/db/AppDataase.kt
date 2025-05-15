package com.siri.multiscreenb2cappwithintegreirteapi.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.siri.multiscreenb2cappwithintegreirteapi.room.dao.UserDao
import com.siri.multiscreenb2cappwithintegreirteapi.room.entitys.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
