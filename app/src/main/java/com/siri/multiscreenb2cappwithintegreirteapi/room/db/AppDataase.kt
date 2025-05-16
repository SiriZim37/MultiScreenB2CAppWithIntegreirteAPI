package com.siri.multiscreenb2cappwithintegreirteapi.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.siri.multiscreenb2cappwithintegreirteapi.room.dao.ProductDao
import com.siri.multiscreenb2cappwithintegreirteapi.room.dao.UserDao
import com.siri.multiscreenb2cappwithintegreirteapi.room.entitys.ProductEntity
import com.siri.multiscreenb2cappwithintegreirteapi.room.entitys.UserEntity

@Database(entities = [ProductEntity::class, UserEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun userDao(): UserDao
}
