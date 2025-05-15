package com.siri.multiscreenb2cappwithintegreirteapi.room.entitys

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val address: String?, // optional
    val profileImageUri: String?, // optional, URI or path
    val registeredAt: Long,
    val passwordHash: String
)
