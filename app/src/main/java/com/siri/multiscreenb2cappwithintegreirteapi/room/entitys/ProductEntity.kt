package com.siri.multiscreenb2cappwithintegreirteapi.room.entitys

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey val pPid: String,
    val pName: String,
    val qua: Int,
    val pPrice: String,
    val pImage: String
)