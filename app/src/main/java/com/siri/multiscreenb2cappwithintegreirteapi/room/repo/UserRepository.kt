package com.siri.multiscreenb2cappwithintegreirteapi.room.repo

import com.siri.multiscreenb2cappwithintegreirteapi.room.dao.UserDao
import com.siri.multiscreenb2cappwithintegreirteapi.room.entitys.UserEntity
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) {
    suspend fun getUserByEmail(email: String): UserEntity? {
        return userDao.getUserByEmail(email)
    }
}
